package com.BDDCRUDoperation;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateOperationTest {
	@Test
	public void  update()
	
	
	{

		   baseURI = "http://localhost";
		   port= 8084;
		
		Random ran=new Random();
		int RAN = ran.nextInt(100);
		JSONObject obj= new JSONObject();
		obj.put("createdBy", "Muneera");
		obj.put("projectName", "RestAssured207");
		obj.put("status", "On Going");
		obj.put("teamSize", 12);
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.put("/project/TY_PROJ_648")
		.then()
		.log().all();
		
				
		
	}

}
