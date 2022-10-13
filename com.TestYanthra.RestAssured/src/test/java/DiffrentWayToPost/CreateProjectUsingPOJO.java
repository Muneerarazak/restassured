package DiffrentWayToPost;


import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.Random;

import org.testng.annotations.Test;

public class CreateProjectUsingPOJO{
	
@Test
	
	public void usingpojo()
	{
		baseURI = "http://localhost";
		   port= 8084;
		   Random ran=new Random();
			int RAN = ran.nextInt(100);
			ProjectLibrary plib=new ProjectLibrary("Muneera","Microsoft"+RAN, "completed",10);
			given()
			.body(plib)
			.contentType(ContentType.JSON)
			.when()
			.post("/addProject")
			.then()
			.assertThat().statusCode(201).log().all();
			
	}

}
