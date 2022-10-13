package Parameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameter {


	@Test
	public void queryparam()
	
	{
		//1: creare pre requites
				baseURI = "http://reqres.in";
	//2:send the request and validate the response
				given()
				.queryParam("page",3)
				.when()
				.get("/api/users")
				.then().assertThat().statusCode(200).log().all();
				
				
		
		
		
}
	
}
