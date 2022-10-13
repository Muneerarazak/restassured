package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0Authentication {
	@Test
	
	public void oauthAuthentication()
	{
		
		
		//Create a request to generate accesss token 

Response resp = given()
		 .formParam("client_id", "muneera-SDET39")
		 .formParam("client_secret", "83b08b527eea4d50dc2ea967ca3c2e65")
		 .formParam("grant_type", "client_credentials")
		 .formParam("redirect_uri", "http://muneera.com")
		 .formParam("code", "authorization_code")
		 	
	.when()
	
	.post("http://coop.apps.symfonycasts.com/token");

	String token=resp.jsonPath().get("access_token");
	System.out.println(token);
	
	
	//Create another request and use the token to access the APIs

	given()
	.auth().oauth2(token)
	.pathParam("USER_ID", 3841)
	.when()
	 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")
	.then().log().all();
	
	
	
	
	
	
	
	}

	

}
