package homePage.service;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import homePage.model.HomePage;

@Path("HomePage")
public class HomePageService {

	HomePage home = new HomePage();
	
	@GET
	@Path("/Doctors")
	@Produces(MediaType.TEXT_HTML)
	public String readHospitals()
	{
		return home.readDoctors();
	}
	
	@GET
	@Path("/Hospitals")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctors()
	{
		return home.readHospitals();
	}
}
