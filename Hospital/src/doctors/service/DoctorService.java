package doctors.service;

import doctors.model.Doctor;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("Doctor")
public class DoctorService {

	Doctor doc = new Doctor();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String insertDoctor(@FormParam("DoctorID") String DoctorID, @FormParam("HospitalName") String HospitalName, @FormParam("DoctorName") String DoctorName, @FormParam("Age") int Age, @FormParam("Specialization") String Specialization, @FormParam("ArriveTime") String ArriveTime, @FormParam("LeaveTime") String LeaveTime)
	{
		String output = doc.insertDoctor(DoctorID, HospitalName, DoctorName, Age, Specialization, ArriveTime, LeaveTime);
		return output;
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctors()
	{
		return doc.readDoctors();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctor(String doctorData)
	{
		//Convert the input string to a JSON object
		JsonObject obj = new JsonParser().parse(doctorData).getAsJsonObject();
		
		//Read the values from the JSON object
		//String ID = obj.get("ID").getAsString();
		String DoctorID = obj.get("DoctorID").getAsString();
		String HospitalName = obj.get("HospitalName").getAsString();
		String DoctorName = obj.get("DoctorName").getAsString();
		int Age = obj.get("Age").getAsInt();
		String Specialization = obj.get("Specialization").getAsString();
		String ArriveTime = obj.get("ArriveTime").getAsString();
		String LeaveTime = obj.get("LeaveTime").getAsString();
		
		String output = doc.updateDoctor(DoctorID, HospitalName, DoctorName, Age, Specialization, ArriveTime, LeaveTime);
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String doctorData)
	{
		//Convert the input string to an XML document
		Document document = Jsoup.parse(doctorData, "", Parser.xmlParser());
		
		//Read the value from the element <itemID>
		String DoctorID = document.select("DoctorID").text();
		
		String output = doc.deleteDoctor(DoctorID);
		return output;
	}
}
