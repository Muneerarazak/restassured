package DiffrentWayToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectUsingJsonObject {
	
	@Test
	public void jsonobject()
	{
		
		baseURI = "http://localhost";
		   port= 8084;
		   Random ran=new Random();
			int RAN = ran.nextInt(100);
			
		 JSONObject obj= new JSONObject();

					obj.put("createdBy", "Muneera");
					obj.put("projectName", "RestAssured209"+RAN);
					obj.put("status", "On Going");
					obj.put("teamSize", 12);
					
		
					given()
					.body(obj)
					.contentType(ContentType.JSON)
					.when()
					.post("/addProject")
					.then()
					.assertThat().statusCode(201)
					.log().all();

					
					
	}

}
