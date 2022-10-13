package DiffrentWayToPost;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJOClasses.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjectWithDiffDataDataDriven{
	@Test(dataProvider="getData")
	public void datadriven(String createdBy, String projectName, String status, int teamSize)
	{
		
		baseURI = "http://localhost";
		port = 8084;
		//prerequisites
		Random ran=new Random();
		int RAN=ran.nextInt(100);
		ProjectLibrary pLib = new ProjectLibrary(createdBy, projectName+RAN, status, teamSize);
		
		
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		.post("/addProject")
		.then().log().all();
	}

		@DataProvider(name="getData")
		public Object[][] data()
		{
			
			Object[][] obj =new Object[10][4];
			
			obj[0][0]="Muneera";
			obj[0][1]="Apple";
			obj[0][2]="Completed";
			obj[0][3]=12;
		
			obj[1][0]="Aleena";
			obj[1][1]="Lg";
			obj[1][2]="Completed";
			obj[1][3]=12;
		
			obj[2][0]="Muneera";
			obj[2][1]="VIDEOCON";
			obj[2][2]="Completed";
			obj[2][3]=12;
		
		
			obj[3][0]="Muneera";
			obj[3][1]="ONPLUS";
			obj[3][2]="Completed";
			obj[3][3]=12;
		
			obj[4][0]="Muneera";
			obj[4][1]="NOKIA";
			obj[4][2]="Completed";
			obj[4][3]=12;
			
			obj[5][0]="HAWWA";
			obj[5][1]="SAMSUNG";
			obj[5][2]="Completed";
			obj[5][3]=12;
			
			obj[6][0]="Muneera";
			obj[6][1]="HP";
			obj[6][2]="ON GOING";
			obj[6][3]=10;
			
			obj[7][0]="MUNNY";
			obj[7][1]="ACER";
			obj[7][2]="Completed";
			obj[7][3]=12;
			
			obj[8][0]="Muneera Sherief";
			obj[8][1]="HP";
			obj[8][2]="Completed";
			obj[8][3]=32;
			
			obj[9][0]="Muneera Razak";
			obj[9][1]="COMPAC";
			obj[9][2]="Completed";
			obj[9][3]=34;
			
			
			
			return obj;
		
		}
		
		
		
	}
	


