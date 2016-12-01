package bg.elsys.ip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/phones") //users
@Api(value = "Api for querying phones")
public class PhoneResource { //UserResource

	@GET
	@ApiOperation(value = "get  all phones")
	@Produces(MediaType.APPLICATION_JSON)
	public PagedResponse getPhones(
			@QueryParam("page") int page, 
			@QueryParam("perPage") int perPage,
			@QueryParam("Brand") String Brand,
			@QueryParam("Model") String Model,
			@QueryParam("DisplaySize") String DisplaySize,
			@QueryParam("RAM") String RAM) {

		PhoneService phoneService = PhoneService.getInstance();
		PagedResponse phonesInPages = phoneService.getPhonesFilteredAndPaged(
				page, 
				perPage,
				Brand,
				Model,
				DisplaySize,
				RAM);
		
		return phonesInPages;
	}
	
	@POST
	@ApiOperation(value = "add new phone", response = Phone.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPhone(Phone phone) {
		PhoneService.getInstance().addPhone(phone);

		return Response.ok(phone).status(Status.CREATED).build();
	}
	
	@Path("/brand")
	@GET
	@ApiOperation("get all distinct phone brands")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllDistinctPhoneBrands(){
		return PhoneService.getInstance().getAllDistinctBrands();
	}

}
