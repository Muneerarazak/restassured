package RequestChaining;

import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;

import java.util.Random;

public class PostGetDelete {
	@Test
	public void postgetdelete()
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
       
 	//get operation
	    String projectID = resp.jsonPath().get("projectId");
	    System.out.println(projectID);
	    		given()
	    		.pathParam("pid",projectID)
	    		.when()
	    			.get("/projects/{pid}");
	    
	//delete operation    		
	    		
		given()
		.pathParam("pid",projectID)
	    		.when().delete("/projects/{pid}")
	    		.then().assertThat().statusCode(204).log().all();
	   
     
     
     
		
	}
	

}
