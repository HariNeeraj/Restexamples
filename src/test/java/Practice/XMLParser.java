package Practice;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class XMLParser {
	
	
		
	@Test
	void Xmlparsing() {
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
			
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page",equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[1].email",equalTo("qweqw@mail.ru"));
		

	}
	
	@Test
	void XMLTest() {
		
		
		Response res= given()
				.when()
					.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getHeader("Content-Type"), "application/xml; charset=utf-8");
		
		XmlPath xobj= new XmlPath(res.asString());
		
		List<String> names = xobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean status =false;
		for (String tnames:names) {
			
			if(tnames.equals("vano")) {
				status= true;
				break;
			}
			
		}
		
		
		
		
		
				
				
	}
	
}

