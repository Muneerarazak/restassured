package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
	
	@Test
	 public void breartoken()
	 {
			
		baseURI ="https://api.github.com";
		JSONObject jobj=new JSONObject();
		jobj.put("name", "SDET39-RestAssured");
		
		given()
		.auth().oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("/user/repos")
		.then().log().all();
		
		
		
		
	 }

}
