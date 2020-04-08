import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDDDeleteRequest {

	@Test
	public static void deletenonbddstyle() {

		// Create a request specification
		RequestSpecification request = RestAssured.given();

		// Setting a cookie for authentication as per API documentation
		request.cookie("token", "f4e70e7b9bbcd05");
		// Adding URI
		request.baseUri("https://restful-booker.herokuapp.com/booking/1");
		

		// Calling PUT method on URI. After hitting we get Response
		Response response = request.delete();

		// Printing Response as string
		System.out.println(response.asString());

		// Get Validatable response to perform validation
		ValidatableResponse validatableResponse = response.then();

		// Validate status code as 201 as per API documentation
		validatableResponse.statusCode(201);

		// Validate if booking is actually deleted. 
		RequestSpecification getRequestSpec = RestAssured.given();
		
		// Adding URI
		getRequestSpec.baseUri("https://restful-booker.herokuapp.com/booking/1");
		
		// Calling GET request
		Response res = getRequestSpec.get();
		
		// Get Validatable response to perform validation
		ValidatableResponse valRes = res.then();
		
		// It will check if status code is 404 as booking id should not be found
		valRes.statusCode(404);
		

	}
}
