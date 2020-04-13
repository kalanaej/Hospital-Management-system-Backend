package hospital.service;

import hospital.model.Hospital; 

//For REST Service 
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON 
import com.google.gson.*; 

//For XML 
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;

@Path("/Hospitals") 
public class HospitalService {
	
	
Hospital hosObj = new Hospital();
	
	
	@GET  
	@Path("/")  
	@Produces(MediaType.TEXT_HTML) 
	public String ReadHospitals() {
		
		return hosObj.readHospitalDetails(); 
		
	}
	
	
	@POST 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertHoapitalDet(
			@FormParam("mohCode") String mohCode,       
			@FormParam("hospitalName") String hospitalName,    
			@FormParam("emailAddress") String emailAddress,       
			@FormParam("managerName") String managerName,
			@FormParam("address") String address,
			@FormParam("telephoneNo") String telephoneNo)
	{  
		String output = hosObj.insertHoapitalDet(mohCode, hospitalName, emailAddress, managerName,address,telephoneNo);  
		return output; 
		
	} 
	

	

}
