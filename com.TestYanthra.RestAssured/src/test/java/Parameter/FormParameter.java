package Parameter;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameter {
		@Test
		public void formparameterparam()
		{
			baseURI = "http://localhost";
			port = 8084;
			
			//Step 1: create pre requisites

			given()
			.formParam("createdBy", "Muneera")
			  .formParam("projectName", "tyss")
			  .formParam("status", "Completed")
			  .formParam("teamSize", 12)
			  .contentType(ContentType.JSON)
			  
				//Step 2: send the request and validate response
			  .when()
			  .post("/addProject")
			  .then().assertThat().statusCode(201).log().all();

			

		
		}
		
	
	
}
