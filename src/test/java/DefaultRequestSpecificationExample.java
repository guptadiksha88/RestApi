import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DefaultRequestSpecificationExample {

	@BeforeClass
	public void setupDefaultRequestSpecification()
	{
		// Creating request specification using given()
		RequestSpecification request1= RestAssured.given();
		// Setting Base URI
		request1.baseUri("https://restful-booker.herokuapp.com");
		// Setting Base Path
		request1.basePath("/booking");
		
		RestAssured.requestSpecification = request1; // this sets default specification if in any method specification is not given,
	}
	
	
	@Test
	public void useDefaultRequestSpecification()
	{
		// It will use default RequestSpecification
		Response res = RestAssured.when().get();
		System.out.println("Response for default: "+res.asString());
	}
	
	@Test
	public void overrideDefaultRequestSpecification()
	{
		// Creating request specification using with()
		RequestSpecification request2= RestAssured.with();
		// Setting Base URI
		request2.baseUri("https://restful-booker.herokuapp.com");
		// Setting Base Path
		request2.basePath("/ping");
		// Overriding default request specification
		Response res = RestAssured.given().spec(request2).get();
		System.out.println("Response for overriding: "+res.asString());
	}
}
