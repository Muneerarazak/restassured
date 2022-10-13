package RequestChaining;

import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectAndGetProject {
	
	@Test
	public void requestchaining()
	{
		
		baseURI = "http://localhost";
		port = 8084;
		Random ran=new Random();
		int RAN=ran.nextInt(100);
		//Step 1: create a project using POJO

		ProjectLibrary plib=new ProjectLibrary("Muneera","Fedex"+RAN ,"Created",12 );
		
	Response resp = given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		 .post("/addProject");
		 
		
		//capture the project id
	
//	String proId=resp.jsonPath().get("projectId");
//	System.out.println(proId);
//	resp.then().log().all();
//	
	//create a get request and pass proId as path parameter

	String proId=resp.jsonPath().get("projectId");

	given()
	.pathParam("pid", proId)
	.when().get("/projects/{pid}")
	.then().assertThat().statusCode(200).log().all();
	
		
	}
	
	

}
