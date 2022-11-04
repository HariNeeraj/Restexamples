package Practice;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.Reader;
import java.util.HashMap;


public class Diffwaystocreatebody {
	
	
	@Test(priority=1)
	void bodyusinghashmap() {
		
		HashMap data= new HashMap();
		
		data.put("name", "Hari");
		data.put("location", "India");
		data.put("phone", "9876543211");
		
		String coursesarr[]= {"Java","Selenium"};
		
		data.put("courses", coursesarr);
		
		given()
			
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("Hari"))
			.body("location",equalTo("India"))
			.body("courses[0]",equalTo("Java"))
			.body("courses[1]",equalTo("Selenium"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
	
	}
	/*@Test(priority=1)
	void bodyusingjson() {
		
		JSONObject data=new JSONObject();
		
		data.put("name", "Hari");
		data.put("location", "India");
		data.put("phone", "9876543211");
		
		String coursesarr[]= {"Java","Selenium"};
		
		data.put("courses", coursesarr);
		
		given()
			
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("Hari"))
			.body("location",equalTo("India"))
			.body("courses[0]",equalTo("Java"))
			.body("courses[1]",equalTo("Selenium"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		}*/
	
	
	@Test(priority=1)
	void bodyusingpojoclass() {
		
		
		Pojo_json data = new Pojo_json();
		
		data.setName("Hari");
		data.setLocation("India");
		data.setPhone("8747983743");
		
		
		
		String coursesarr[]= {"Java","Selenium"};
		
		data.setCourses(coursesarr);
		
		given()
			
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("Hari"))
			.body("location",equalTo("India"))
			.body("courses[0]",equalTo("Java"))
			.body("courses[1]",equalTo("Selenium"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		}
	
	
	
	@Test(priority=2)
	void deletetherecord() {
		
		given()
		
		.when()
			.delete("http://localhost:3000/students/4")
		.then()
			.statusCode(200)
			.log().all();
	}

}
