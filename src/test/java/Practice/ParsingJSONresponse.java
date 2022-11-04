package Practice;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONresponse {
	
	@Test
	void Jsonresponsevalidatiion() {
	
	
	Response res=given()
		.contentType(ContentType.JSON)

	.when()
		.get("http://localhost:3000/store");
	
	Assert.assertEquals(res.getStatusCode(), 200);
	
	//Using json object 
	JSONObject jo = new JSONObject(res.asString());
	//Found the book name
	boolean status = false;
	
	for(int i=0;i<jo.getJSONArray("book").length();i++) {
		
		String BookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		String Bookauthor=jo.getJSONArray("book").getJSONObject(i).get("author").toString();
		String Bookcategory=jo.getJSONArray("book").getJSONObject(i).get("category").toString();
		String Bookprice=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
		System.out.println(BookTitle);
		System.out.println(Bookauthor);
		System.out.println(Bookcategory);
		System.out.println(Bookprice);
		
		if(BookTitle.equals("The Lord of the Rings"));
		{
			status = true;
			break;
		}
	}
	
	Assert.assertEquals(status, true);
	//Sum of price for all the books
	
	double totalprice =0;
	
	for(int j=0; j<jo.getJSONArray("book").length();j++) {
		
		String price = jo.getJSONArray("book").getJSONObject(j).get("price").toString();
		
		totalprice=totalprice+Double.parseDouble(price);
		
		
	}
	System.out.println(totalprice);
	
	
	}
	
	
	
	
	
	
	

}
