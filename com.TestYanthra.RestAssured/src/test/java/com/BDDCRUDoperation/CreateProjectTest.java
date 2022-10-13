package com.BDDCRUDoperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.Random;

import io.restassured.http.ContentType;




public class CreateProjectTest {

	@Test
	public void createprojecttest()
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
