package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModelProperty;

public class Phone { //User

	@ApiModelProperty(required = true)
	private int id;
	private String brand;
	private String model;
	private String displaySize;
	private String RAM;

	public Phone(int id, 
			String brand,
			String model,
			String displaySize,
			String RAM) {
		super();
		this.id = id;
		this.setBrand(brand);
		this.setDisplaySize(displaySize);
		this.setModel(model);
		this.setRAM(RAM); 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}

	public String getRAM() {
		return RAM;
	}

	public void setRAM(String rAM) {
		RAM = rAM;
	}
}
