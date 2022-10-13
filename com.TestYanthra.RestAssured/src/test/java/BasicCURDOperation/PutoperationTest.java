package BasicCURDOperation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutoperationTest {

	@Test
	public void putoperation()
	{
				
		//Step1: create pre requisites
				JSONObject Obj = new JSONObject();
				Obj.put("createdBy", "HawwaArshia");
				Obj.put("projectName", "Rissmin");
				Obj.put("status", "Completed");
				Obj.put("teamSize", 17);
		
				RequestSpecification request = RestAssured.given();
				request.body(Obj);
				
				request.contentType(ContentType.JSON);//enum block 
				//perform Action
				
				Response resp = request.put("http://localhost:8084/projects/TY_PROJ_004");
		
				//validate the response
				
				resp.then().log();
				System.out.println(resp.getStatusCode());
				
				int actualstatus=resp.getStatusCode();
				
				Assert.assertEquals(actualstatus,200);
				
				
							
				
	}
	
}
