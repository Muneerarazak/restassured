package DiffrentWayToPost;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONfile {
	
	@Test
	public void jsonfile()
	{
		baseURI = "http://localhost";
		port = 8084;
				
		File file=new File("./data.json");
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201).log().all();

}}
