package user.service;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import user.model.UserRegister;

@Path("User")
public class UserRegisterService {

	UserRegister user = new UserRegister();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String insertUser(@FormParam("Email") String Email, 
							 @FormParam("Username") String Username, 
							 @FormParam("Password") String Password,
							 @FormParam("Age") int Age, 
							 @FormParam("Address") String Address, 
							 @FormParam("PhoneNumber") int PhoneNumber)
	{
		String output = user.insertUser(Email, Username, Password, Age, Address, PhoneNumber);
		return output;
	}
}
