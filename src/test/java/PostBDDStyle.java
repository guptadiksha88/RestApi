import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostBDDStyle {
	
	@Test
	public static void postverb() {
		
		// There is no need to add escape character manually. Just paste string within double 
		// quotes. It will automatically add escape sequence as required. 
		String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		
		
		//GIVEN
		RestAssured
		.given()
			.baseUri("https://restful-booker.herokuapp.com/auth")
			.contentType(ContentType.JSON)
			.body(jsonString)
		// WHEN
		.when()
			.post()
		// THEN
		.then()
			.assertThat()
			.statusCode(200)
			.body("token", Matchers.notNullValue())
			.body("token.length()", Matchers.is(15))
			.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
		
	
	}

}
