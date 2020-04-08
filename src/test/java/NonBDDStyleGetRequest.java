
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGetRequest {

	// Without static import and builder pattern
	@Test
	public void GetBookingIds_VerifyStatusCode() {
		
		
		// Create a request specification 
		RequestSpecification request= RestAssured.given();
		
		//Adding URI
		request.baseUri("https://restful-booker.herokuapp.com/booking");
		//request.port(8081); if port is available
		
		// Calling GET method on URI. After hitting we get Response. 
		// Three ways of Calling methods
		Response response = request.get();
		Response response1 = RestAssured.given(request).get();
		Response response2 = RestAssured.given().spec(request).get();
		
		// Let's print response body.
		String resString = response.asString();
		System.out.println("Respnse Details : " + resString);

		/*
		 * To perform validation on response like status code or value, we need to get
		 * ValidatableResponse type of response using then() method of Response
		 * interface. ValidatableResponse is also an interface.
		 */
		ValidatableResponse valRes = response.then();
		// It will check if status code is 200
		valRes.statusCode(200);
		// It will check if status line is as expected
		valRes.statusLine("HTTP/1.1 200 OK");
		
		

	}

}
