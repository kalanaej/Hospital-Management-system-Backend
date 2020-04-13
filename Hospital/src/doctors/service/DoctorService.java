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
}
