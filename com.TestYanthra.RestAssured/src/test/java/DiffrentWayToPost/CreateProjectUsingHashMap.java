package DiffrentWayToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

public class CreateProjectUsingHashMap {
	@Test
	public void hashmap()
	{

		baseURI = "http://localhost";
		   port= 8084;
		   Random ran=new Random();
			int RAN = ran.nextInt(100);
			
			HashMap map=new HashMap();
			map.put("createdBy", "Chandan");
			map.put("projectName", "Sony "+RAN);
			map.put("status", "Created");
			map.put("teamSize", 4);
			
			given()
			.body(map)
			.contentType(ContentType.JSON)
			.when()
			.post("/addProject")
			.then()
			.assertThat().statusCode(201).log().all();
			
	}

}
