package user.service;

import java.sql.SQLException;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import doctors.model.Doctor;
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
}
