import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PassFileAsPayload {
	
	@Test
	public void passFileAsPayload()
	{
		// Creating a File instance 
		File jsonDataInFile = new File("src/test/resources/sample.json");
		
		//GIVEN
		RestAssured
		    .given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				.contentType(ContentType.JSON)
				// Since I am passing payload as JSON. Anyway it is optional as Rest Assured automatically identifies.
				.body(jsonDataInFile)
		// WHEN
			.when()
				.post()
				// THEN
			.then()
				.assertThat()
				.statusCode(200);
	}
	
	
	/*
	 * @Test public void passXMLFileAsPayload() { // Creating a File instance File
	 * jsonDataInFile = new File("src/test/resources/Payloads/AuthPayload.xml");
	 * 
	 * //GIVEN RestAssured .given()
	 * .baseUri("https://restful-booker.herokuapp.com/auth") // Since I am passing
	 * payload as xml. Anyway it is optional as Rest Assured automatically
	 * identifies. .contentType(ContentType.XML) .body(jsonDataInFile) // WHEN
	 * .when() .post() // THEN .then() .assertThat() .statusCode(200); }
	 */
}
