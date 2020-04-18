package appointments.service;

import appointments.model.Appointments;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/appointments")
public class AppointmentsService{
	
	Appointments apObj = new Appointments();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readAppointments() {
		return apObj.readAppointments();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAppointments(
			@FormParam("username") String username, 
			@FormParam("doctor_name") String doctor_name,
			@FormParam("hospital_name") String hospital_name, 
			@FormParam("date") String date,
			@FormParam("payment_type") String payment_type) {

		String output = apObj.insertAppointments(username, doctor_name, hospital_name, date,payment_type);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAppointments(String appData) {

		// Convert the input string to a JSON object
		JsonObject appObject = new JsonParser().parse(appData).getAsJsonObject();

		// Read the values from the JSON object
		String token_number = appObject.get("token_number").getAsString();
		String username = appObject.get("username").getAsString();
		String doctor_name = appObject.get("doctor_name").getAsString();
		String hospital_name = appObject.get("hospital_name").getAsString();
		String date = appObject.get("date").getAsString();
		String payment_type = appObject.get("payment_type").getAsString();

		String output = apObj.updateAppointments(token_number, username, doctor_name, hospital_name, date,payment_type);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAppointments(String appData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(appData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String token_number = doc.select("token_number").text();
		String output = apObj.deleteAppointments(token_number);
		return output;
	}

}
