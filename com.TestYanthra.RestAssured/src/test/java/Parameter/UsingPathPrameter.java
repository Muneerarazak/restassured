package Parameter;

import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;

public class UsingPathPrameter {
	
	@Test
	public void pathparam()
	
	{
		
		baseURI = "http://localhost";
		port = 8084;
	  // prerequsit
		given()
		.pathParams("pid", "TY_PROJ_664")
		.when().get("/projects/{pid}")
		.then()
		.assertThat().statusCode(200).log().all();
		
	}

}
