package ResponseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseValidation {
	@Test
	public void dynamicrsponse()
	{
		
		 baseURI = "http://localhost";
		   port= 8084;
	
		   
		   String expdata="TY_PROJ_664";
		//step1: prerequisite
		   
		 //step2: send the request

		  Response resp = when().get("/projects");
			//step3:validation
		  
//  using for each and assertion
//		  List <String>list = resp.jsonPath().get("projectId");
//		for(String actdata:list)
//		{
//			Assert.assertEquals(actdata,expdata);
//			System.out.println(actdata);
//		}
		
		  
		  //usinf if condition
//	  List <String>list = resp.jsonPath().get("projectId");
//	  for(String actdata:list)
//	  {
//		  if(actdata.equalsIgnoreCase(expdata))
//				  {
//			  System.out.println(actdata);
//			  break;
//				  }
//	  }
		  
		//using boolean flag
//		  boolean flag=false;
//		  List <String>list = resp.jsonPath().get("projectId");
//	  for(String actdata:list)
//	  {
//		  if(actdata.equalsIgnoreCase(expdata))
//		  {
	//	   System.out.println(actdata);
//			  flag=true; //flag raising
//		  break;
//	  }
//	  }
//	  if(flag)
//	  {
//		  System.out.println("pass");
//	  }
//	  else
//	  {
//		  System.out.println("fail");
//	  }
		 
	  
	  
		  boolean flag=false;
		  List <String>list = resp.jsonPath().get("projectId");
	  for(String actdata:list)
	  {
		  if(actdata.equalsIgnoreCase(expdata))
		  {
		   System.out.println(actdata);
		  flag=true; //flag raising
		  break;
	  }
	  }
	 Assert.assertTrue(flag);
	  
	  
		  
		  
	}

}
