package PracticePackage;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class DataProviderPost {

	//@DataProvider(name="DataPost")
	
	public Object [][] post_data(){
		
		
		Object [][] data=new Object [2][2];
		data [0][0]= "Rots";
		data[0][1]="jeo";
		
		data [1][0]= "Richmand";
		data[1][1]="dabas";
		
		return data;
		
		
		
	/*	return new Object [][] {
			
			{"Gram","hick"},{"Albert","Einsten"}
			
		};*/
		
	}
	
//	@Test(dataProvider="DataPost")
	
	public void post_method(String name,String job) {
		
		baseURI="https://reqres.in";
		
		JSONObject req=new JSONObject();
		req.put( "name",  name);
		req.put("job",job);
		
		given().
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		   body(req.toJSONString()).
		when().
		   post("/api/users").
		then().
		    statusCode(201).log().all();
			
	}
	
	@Test
	
	public void get_method() {
		
		baseURI="https://reqres.in";
		
		given().
		get("/api/users?page=2").
		then().
		statusCode(200).
		body("data[1].first_name",equalTo("Lindsay")).
		log().all();
		
	}
	@DataProvider(name="datadelete")
	
	public Object [] deletemethod() {
		return new Object [] {
				2
		};
		
	}
	
	@Test(dataProvider="datadelete")
	
	public void testdelete(int id) {
		baseURI="https://reqres.in";
		
		given().
		when().
		delete("/api/users").
		then().
		statusCode(200).log().all();
	}
}
