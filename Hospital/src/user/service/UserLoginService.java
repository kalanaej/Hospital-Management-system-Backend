package user.service;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import user.model.UserLogin;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("Login")
public class UserLoginService {

	UserLogin login = new UserLogin();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String validateLogin(@FormParam("Username") String Username, 
							    @FormParam("Password") String Password) 
	{
		String output = login.validateLogin(Username, Password);
		return output;
	}
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readUser(@QueryParam("Username") String Username, 
						   @QueryParam("Password") String Password)
	{
		Username = "kalanaej";
		Password = "kalana123";
		return login.readUser(Username, Password);
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser(String userData)
	{
		//Convert the input string to a JSON object
		JsonObject obj = new JsonParser().parse(userData).getAsJsonObject();
		
		//Read the values from the JSON object
		String Email = obj.get("Email").getAsString();
		String Username = obj.get("Username").getAsString();
		String Password = obj.get("Password").getAsString();
		int Age = obj.get("Age").getAsInt();
		String Address = obj.get("Address").getAsString();
		int PhoneNumber = obj.get("PhoneNumber").getAsInt();
		
		String output = login.updateUser(Email, Username, Password, Age, Address, PhoneNumber);
		return output;
	}	
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(String userData)
	{
		//Convert the input string to an XML document
		Document document = Jsoup.parse(userData, "", Parser.xmlParser());
		
		//Read the value from the element <DoctorID>
		String Username = document.select("Username").text();
		String Password = document.select("Password").text();
		
		String output = login.deleteUser(Username, Password);
		return output;
	}
}
