import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class BDDStyleGetRequestWithStaticImport {

	
	@Test
	public void GetBookingIds_VerifyStatusCode() {
		
		// Given
		given()
			.baseUri("https://restful-booker.herokuapp.com")
		// When
		.when()
			.get("/booking")
		// Then
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			// To verify booking count
			.body("bookingid", hasSize(10))
			// To verify booking id at index 3
			.body("bookingid[3]", equalTo(3));			
		

	}

}

