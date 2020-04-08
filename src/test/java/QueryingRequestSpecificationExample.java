import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryingRequestSpecificationExample {
	
	public static void main(String[] args) {
		
		// I am adding dummy request details for example
		String JsonBody = "{\"firstName\":\"Amod\"}";
		
		// Creating request specification using given()
		RequestSpecification request1= RestAssured.given();
		// Setting Base URI
		request1.baseUri("https://restful-booker.herokuapp.com")
		// Setting Base Path
		.basePath("/booking")
		.body(JsonBody)
		.header("header1", "headerValue1")
		.header("header2", "headerValue2");
		
		// Querying RequestSpecification
		// Use query() method of SpecificationQuerier class to query 
		QueryableRequestSpecification queryRequest = SpecificationQuerier.query(request1);
		
		// get base URI
		String retrieveURI = queryRequest.getBaseUri();
		System.out.println("Base URI is : "+retrieveURI);
		
		// get base Path
		String retrievePath = queryRequest.getBasePath();
		System.out.println("Base PATH is : "+retrievePath);
		
		// get Body
		String retrieveBody = queryRequest.getBody();
		System.out.println("Body is : "+retrieveBody);
		
		// Get Headers
		Headers allHeaders = queryRequest.getHeaders();
		System.out.println("Printing all headers: ");
		for(Header h : allHeaders)
		{
			System.out.println("Header name : "+ h.getName()+" Header value is : "+h.getValue());
		}
	}

}

