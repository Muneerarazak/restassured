package BasicCURDOperation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProject {
	@Test
	public void getallproject()
	{
		
		//Step 2: Perform the action
		
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_654");
		resp.then().log().all();
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(200, actstatus);
		
		
	}

}
