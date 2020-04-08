import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BDDStyleDeleteRequest {

	@Test
	public static void deletebddstyle() {
		

		// Delete Booking

		//GIVEN
		RestAssured
			.given()
					.baseUri("https://restful-booker.herokuapp.com/booking/1")
					.cookie("token", "f7dddb1093eab19")
			// WHEN
			.when()
					.delete()
			// THEN
			.then()
					.assertThat()
					.statusCode(201);
		
		// Verifying booking is deleted
		// Given
		RestAssured
		    .given()
				    .baseUri("https://restful-booker.herokuapp.com/booking/1")
		// When
			.when()
					.get()
		// Then
			.then()
					.statusCode(404);

	}
}

