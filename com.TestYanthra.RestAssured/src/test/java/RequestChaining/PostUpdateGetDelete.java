package RequestChaining;

import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;

import java.util.Random;

public class PostUpdateGetDelete {
	
	@Test
	public void postupdatgetdelete()
	
	{
		baseURI = "http://localhost";
		port = 8084;
		
		Random ran=new Random();
		int RAN=ran.nextInt(100);
		//Step 1: create a project using POJO
		ProjectLibrary plib=new ProjectLibrary("Muneera","Fedex"+RAN ,"Created",12 );
//post		
     Response resp = given()
      .body(plib)
      .contentType(ContentType.JSON)
      .when()
      .post("/addProject");
     String projectID=resp.jsonPath().get("projectId");
     System.out.println(projectID);
       
     //put
		ProjectLibrary plib2=new ProjectLibrary("Muneera12","Fedex"+RAN ,"complted",20);
		Response resp2 = given()
		.body(plib2)
		.contentType(ContentType.JSON)
		.pathParam("pid",projectID)
		.when()
		.put("/projects/{pid}");
		
		String proId2=resp.jsonPath().get("projectId");
	//get
		given()
		.pathParam("pid2", proId2)
		.when().get("/projects/{pid2}")
		.then().assertThat().statusCode(200).log().all();
//delete				
     given()
     .pathParam("pid2", proId2)
     .when()
    .delete("/projects/{pid2}")
    .then()
    .assertThat().statusCode(204).log().all();
    
    
     
     
     
	
	
	}

}
