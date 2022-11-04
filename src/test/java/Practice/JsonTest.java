package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class JsonTest {
	
	
	
	@Test
	void Testingjson() {
		
		//Approach-1
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://restapi.adequateshop.com/api/Tourist")
			
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("data[0].tourist_name",equalTo("John"))
			.body("total_pages",equalTo(1060));
	
					
		
	}
	
	@Test
	void Testingjson2() {
		
		
		//Approach -2
		
		Response res=given()
				.contentType(ContentType.JSON)
				
			.when()
				.get("http://restapi.adequateshop.com/api/Tourist");
		
			JSONObject jb= new JSONObject(res.asString());
			
			boolean status =false;
			for(int i=0; i<jb.getJSONArray("data").length();i++) {
				
				String tourname=jb.getJSONArray("data").getJSONObject(i).get("tourist_name").toString();
				
				if(tourname.equals("Hakan")) {
					status = true;
					break;
				}
				System.out.println(tourname);
				
			}
			
			String pages=jb.get("total_pages").toString();
			System.out.println(pages);
			
			Assert.assertEquals(Integer.parseInt(pages), 1063);
			Assert.assertEquals(res.getStatusCode(), 200);
			
			
			System.out.println(jb.toString()); //get the entire response for the page
			System.out.println(jb.getJSONArray("data").length()); //get the objects count in the page
			
			
			
	}

}
