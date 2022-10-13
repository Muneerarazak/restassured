package com.BDDCRUDoperation;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

public class DeleteProjectTest {
	@Test
	public void delete()
	{
		baseURI = "http://localhost";
		   port= 8084;
		   
		   when()
		   .delete("/projects/TY_PROJ_1802")
		   .then()
		   .assertThat().statusCode(204)
             .log().all();		
	}

}
