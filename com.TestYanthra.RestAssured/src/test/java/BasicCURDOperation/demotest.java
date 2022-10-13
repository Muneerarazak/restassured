package BasicCURDOperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class demotest {
	
	@Test
	public void demo()
	{
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "testing22");
		obj.put("projectName", "RestAssured304");
		obj.put("status", "On Going");
		obj.put("Created On", "23/09/2022");
		obj.put("teamSize", 12);
		
		
		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);
		
		
		Response res = req.post("http://localhost:8084/addProject");
		System.out.println(res.getStatusCode());
		
		System.out.println(res.then().log().all());
		int actualstaus=res.getStatusCode();
		Assert.assertEquals(actualstaus, 201);
		
	}

}
