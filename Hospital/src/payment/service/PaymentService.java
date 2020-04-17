package payment.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import payment.model.Payments;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("Payment")
public class PaymentService {

	Payments payment = new Payments();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String validatePayment(@FormParam("CardNumber") String CardNumber, 
							      @FormParam("CVV") String CVV) 
	{
		String output = payment.validatePayment(CardNumber, CVV);
		return output;
	}
}
