package Practice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class JSONandXMLSchemavalidation {

	
	
	@Test
	void jsonschemavalidation() {
		
		
		Response response= given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Tourist");
		response.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
		
		
	}
	
	
	@Test
	void xmlschemavalidation() {
		
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlschema.xsd"));
		
	}
}
