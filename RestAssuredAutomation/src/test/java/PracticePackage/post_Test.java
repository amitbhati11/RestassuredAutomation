package PracticePackage;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class post_Test {
	
	@DataProvider(name="Datapost")
	
	public Object [][]  posttest() {
		
		return new Object[][] {
			{"Raj","laxhmi",2},{"Vijay","Bhawani",1}
			
		};
		
	}
	
	//@Test(dataProvider="Datapost")
	
	public void usedpost(String F_name,String L_name,int SubID) {
		baseURI="http://localhost:3000";
		JSONObject rq=new JSONObject();
		rq.put("F_name",F_name);
		rq.put("L_name",L_name);
		rq.put("SubID", SubID);
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(rq.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).log().all();
		
		
		
	}
	
	@Test
	
	public void getmethod() {
		baseURI="http://localhost:3000";
		
		given().
		get("/users").
		then().
		statusCode(200).log().all()
;	}
	


}
