package Practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Pojo_json {
	
	
	String name;
	String location;
	String phone;
	String courses[];

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	
	
	@Test
	void testquerypathparams() {
		
		
		given()
		
		.pathParam("pathr", "users")
		.queryParam("page", 2)
		.queryParam("id", 5)
		
		.when()
			.get("https://reqres.in/api/{pathr}")
		.then()
			 .statusCode(200)
			 .log().all();
		
	}
	
}
