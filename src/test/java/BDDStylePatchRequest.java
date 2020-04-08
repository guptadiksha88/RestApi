import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BDDStylePatchRequest {

	@Test
	public static void patchbddstyle() {

		// There is no need to add escape character manually. Just paste string within
		// double
		// quotes. It will automatically add escape sequence as required.
		//in patch no complete body is required. only changes to be put in jsonString
		String jsonString = "{\r\n" + "\"firstname\" : \"Amod\",\r\n" + "\"lastname\" : \"Mahajan\",\r\n"+"}";

		//GIVEN
		RestAssured
			.given()
					.baseUri("https://restful-booker.herokuapp.com/booking/1")
					.cookie("token", "e88375c0fde687a") // access token needs to be generated every time else it will throw error code 403
					.contentType(ContentType.JSON)
					.body(jsonString)
			// WHEN
			.when()
					.patch()
			// THEN
			.then()
					.assertThat()
					.statusCode(200)
					.body("firstname", Matchers.equalTo("Amod"))
					.body("lastname", Matchers.equalTo("Mahajan"));

	}
}

