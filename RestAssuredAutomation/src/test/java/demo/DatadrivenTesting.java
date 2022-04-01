package demo;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.json.simple.JSONObject.*;

import org.json.simple.JSONObject;

//Datadriventesting

  public class DatadrivenTesting extends Dataprovider {
	  
	
	  
	  @Test(dataProvider="testPost")
	   public void testPost(String F_name,String L_name,int SubID) {
		  
		  baseURI="http://localhost:3000";
		  
		  JSONObject rqt=new JSONObject ();
		  rqt.put("F_name",F_name);
		  rqt.put("L_Name",L_name);
		  rqt.put("SubID",SubID);
		  
		  
		  given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rqt.toJSONString())
		  .when()
		  .post("/users")
		  .then()
		  .statusCode(201)
		  .log()
		  .all();
		  
		  
		  
	  }
	  
	  
	
	  @Test(dataProvider="Deletedata")
	  
	  public void deletetest(int ID)
	  
	  {
		  
		  baseURI="http://localhost:3000";
		  
		  given().when().delete("/users"+ID).then().statusCode(200);
		
		  
		  
	  }
	  @Parameters({"ID"})
	  @Test
	  
  public void deletetest2(int ID)
	  
	  {
		  System.out.println("value of id"+ID);
		  baseURI="http://localhost:3000";
		  
		  given().when().delete("/users"+ID).then().statusCode(200);
		
		  
		  
	  }

}
