package Practice;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CookieandHeadersTest {
	
	
	
	@Test
	void testcookies() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
			.statusCode(200)
			.log().cookies()
			.cookie("AEC", "AakniGMN0czhKslshHE_sit8qwPiZq9TPHa2BsiKYA9SvgHEKvAn1Qvlid0");
	}
	
	
	@Test
	void getcookiesinfo() {
	
	Response res= given()
	
	.when()
		.get("https://www.google.com/");
	
		//Get single cookie info
			String cookie = res.getCookie("AEC");
			System.out.println(cookie);
			
			
		//Get all cookie values
			Map<String,String> cookievalues= res.getCookies();
			
			for(String K: cookievalues.keySet()) { //Keyset will return the cookie keys
				
				String cookie_values = res.getCookie(K);
				System.out.println(K+"          "+cookie_values);
			}
	}
	
	
	@Test
	void getheadervalues() {
		
		Response res= given()
				
				.when()
					.get("https://www.google.com/");
		
		Headers headervalues = res.headers();
		
		for(Header h: headervalues) {
			
			System.out.println(h.getName()+"   "+h.getValue());
		}
		
	}
	

}
