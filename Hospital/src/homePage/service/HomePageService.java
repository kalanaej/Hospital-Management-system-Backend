package homePage.service;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import homePage.model.HomePage;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

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
