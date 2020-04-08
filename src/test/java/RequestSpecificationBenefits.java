import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBenefits {
	RequestSpecification request1;
	@BeforeClass
	public static void basemethod() {
		

		// Creating request specification using given()
		RequestSpecification request1= RestAssured.given();
		// Setting Base URI
		request1.baseUri("https://restful-booker.herokuapp.com");
		// Setting Base Path
		request1.basePath("/booking");
	}

	//Below two methods are fetching the data from same URI and same Base path. so base conditions 
	//instead of writing in both methods separately, we have written in separate method with the help of RequestSpecifications
	// and in both methods just passing the object of the RequestSpecification parameter. This is the benefit of this interface.
	
		@Test
		public void firstmethod(){
			RestAssured
			.given(request1) //here .with instaed of .given can also be used which has the same purpose
			// WHEN
			.when()
					.get()
			// THEN
			.then()
					.assertThat()
					.statusCode(200);
		}
		
		public void secondmethod() {
			RestAssured
			.given(request1)
			.formParam("firstname", "Diksha")
			// WHEN
			.when()
					.get()
			// THEN
			.then()
					.assertThat()
					.statusCode(200);
		
			
	}

}
