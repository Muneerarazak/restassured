package ResponseValidation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;



public class StaticResponseValidation {
	
	@Test
	public void staticresponsevalidation()
	{
		//step1: prerequisite
		
		
		//step:2 send the request
		 baseURI = "http://localhost";
		   port= 8084;
		   
		   String expData="TY_PROJ_1007";
		 Response resp = when().get("/projects");
		  		     
		//step3: validatio
		   
		String actdata = resp.jsonPath().get("[1].projectId");
		  // String actData = resp.jsonPath().get("[0].projectId");
			
		   Assert.assertEquals(actdata, expData);
			
		   System.out.println("data verfied ");
			
			resp.then().log().all();
		
		
	    	
	}

}
