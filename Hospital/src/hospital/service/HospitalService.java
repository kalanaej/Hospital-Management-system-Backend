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
	

	@PUT 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateHospitalDet(String hospitalData) 
	{  
		//Convert the input string to a JSON object  
		JsonObject hospitalObject = new JsonParser().parse(hospitalData).getAsJsonObject(); 
		 
		//Read the values from the JSON object  
		String hospitalID = hospitalObject.get("hospitalID").getAsString(); 
		String mohCode = hospitalObject.get("mohCode").getAsString();  
		String hospitalName = hospitalObject.get("hospitalName").getAsString(); 
		String emailAddress = hospitalObject.get("emailAddress").getAsString();  
		String managerName = hospitalObject.get("managerName").getAsString();
		String address = hospitalObject.get("address").getAsString();
		String telephoneNo = hospitalObject.get("telephoneNo").getAsString();
		 
		String output = hosObj.updateHospitalDet(hospitalID, mohCode, hospitalName, emailAddress, managerName,address,telephoneNo); 
		 
		return output; 
		 
	} 
		 
	@DELETE 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	
	public String deleteHospitalDet(String hospitalData) 
	{  
		//Convert the input string to an XML doc  
		Document doc = Jsoup.parse(hospitalData, "", Parser.xmlParser());     
		
		//Read the value from the element <hospitalID>  
		String hospitalID = doc.select("hospitalID").text(); 
		 
		String output = hosObj.deleteHospitalDet(hospitalID); 
		 
		return output;  
	} 
}
