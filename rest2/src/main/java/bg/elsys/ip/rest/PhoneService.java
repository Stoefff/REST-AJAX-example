package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneService { //UserService
	private static PhoneService instance;

	public static PhoneService getInstance() {
		if (instance == null) {
			instance = new PhoneService();
		}
		return instance;
	}

	private List<Phone> PhoneList = new ArrayList<>();

	public PhoneService() {
		PhoneList.add(new Phone(1, "Samsung", "S6", "5", "3"));
		PhoneList.add(new Phone(1, "Samsung", "S7", "6", "4"));
		PhoneList.add(new Phone(1, "Lainovo", "P7", "4", "1"));
		PhoneList.add(new Phone(1, "Iphone", "7", "5", "3"));
		PhoneList.add(new Phone(1, "Sony", "Z6", "6", "4"));
		
	}

	public List<Phone> getPhone() {
		return Collections.unmodifiableList(PhoneList);
	}

	public void addPhone(Phone phone) {
		PhoneList.add(phone);
	}
	
	public PagedResponse getPhonesFilteredAndPaged(
			int page, 
			int perPage, 
			String Brand,
			String Model,
			String DisplaySize,
			String RAM){
		
		long previousEntries = page * perPage;
		List<Phone> pageOfPhones = PhoneList
				.stream()
				.filter((u) -> Brand == null || u.getBrand().toLowerCase().startsWith(Brand.toLowerCase()))
				.filter((u) -> Model == null || u.getBrand().toLowerCase().startsWith(Model.toLowerCase()))
				.filter((u) -> DisplaySize == null || u.getBrand().toLowerCase().startsWith(DisplaySize.toLowerCase()))
				.filter((u) -> RAM == null || u.getBrand().toLowerCase().startsWith(RAM.toLowerCase()))
				.skip(previousEntries)
				.limit(perPage)
				.collect(Collectors.toList());

		int totalPages = (int) Math.ceil(((double) PhoneList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfPhones, page, totalPages);

		return response;
		
	}

/*
	public PagedResponse getPhonesFilteredByBrand(int page, int perPage, String Brand) {
		long previousEntries = page * perPage;
		List<Phone> pageOfPhones = PhoneList
				.stream()
				.filter((u) -> u.getBrand()
					.equals(Brand) || Brand == null)
					.skip(previousEntries)
					.limit(perPage)
					.collect(Collectors.toList());

		int totalPages = (int) Math.ceil(((double) PhoneList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfPhones, page, totalPages);

		return response;
	}
	
	public PagedResponse getPhonesFilteredByModel(int page, int perPage, String Model) {
		long previousEntries = page * perPage;
		List<Phone> pageOfPhones = PhoneList
				.stream()
				.filter((u) -> u.getModel()
					.equals(Model) || Model == null)
					.skip(previousEntries)
					.limit(perPage)
					.collect(Collectors.toList());

		int totalPages = (int) Math.ceil(((double) PhoneList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfPhones, page, totalPages);

		return response;
	}
	
	public PagedResponse getPhonesFilteredByDisplaySize(int page, int perPage, String DisplaySize) {
		long previousEntries = page * perPage;
		List<Phone> pageOfPhones = PhoneList
				.stream()
				.filter((u) -> u.getDisplaySize()
					.equals(DisplaySize) || DisplaySize == null)
					.skip(previousEntries)
					.limit(perPage)
					.collect(Collectors.toList());

		int totalPages = (int) Math.ceil(((double) PhoneList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfPhones, page, totalPages);

		return response;
	}
	
	public PagedResponse getPhonesFilteredByRAM(int page, int perPage, String RAM) {
		long previousEntries = page * perPage;
		List<Phone> pageOfPhones = PhoneList
				.stream()
				.filter((u) -> u.getRAM()
					.equals(RAM) || RAM == null)
					.skip(previousEntries)
					.limit(perPage)
					.collect(Collectors.toList());

		int totalPages = (int) Math.ceil(((double) PhoneList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfPhones, page, totalPages);

		return response;
	}
	
	public PagedResponse getPhonesByPage(int page, int perPage){
		long previousEntries = page * perPage;
		List<Phone> pageOfPhones = PhoneList
				.stream()
				.skip(previousEntries)
				.limit(perPage)
				.collect(Collectors.toList());

		int totalPages = (int) Math.ceil(((double) PhoneList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfPhones, page, totalPages);

		return response;
	}
*/
	
	public List<String> getAllDistinctBrands() {
		return PhoneList.stream()
				.map((u) -> u.getBrand())
				.distinct()
				.collect(Collectors.toList());
	}
}
