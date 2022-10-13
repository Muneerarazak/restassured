package com.BDDCRUDoperation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BDDgetoperation {
	
	@Test
	public void bddgetoperation()
	{ 
		
		   baseURI = "http://localhost";
		port=8084;
		when()
		.get("/projects")
		.then()
		.log().all();
		
		
	}

}
