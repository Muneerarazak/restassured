package BasicCURDOperation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteTest {
	@Test
	public void deletetest()
	{
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_005");	 
		
		//validate
	 System.out.println(resp.getStatusCode());
		
	int	actualres=resp.getStatusCode();
	Assert.assertEquals(actualres, 204);
	}

}
