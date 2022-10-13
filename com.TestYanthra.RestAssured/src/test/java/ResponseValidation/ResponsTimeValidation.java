package ResponseValidation;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponsTimeValidation {
	
	@Test
	public void respotime()
	{
		//prerequsite
		//send request
		
		 baseURI = "http://localhost";
		   port= 8084;
	
		 when().get("/projects")
		 .then()
		 .assertThat().time(Matchers.lessThan(500L));
		    //System.out.println(resp.getTime());
		    
		    
		//validate
		
		
	}

}
