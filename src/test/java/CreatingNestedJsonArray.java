import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreatingNestedJsonArray {
	
	@Test
	public void CreatingNestedJsonObjectTest()
	{
		
		// JSON Object for first guest
		Map<String,Object> bookingOne = new HashMap<String,Object>();
		bookingOne.put("firstname", "Amod");
		bookingOne.put("lastname", "Mahajan");
		bookingOne.put("totalprice", 222);
		bookingOne.put("depositpaid", true);
		
		Map<String,String> bookingDatesMapForAmod = new HashMap<>();
		bookingDatesMapForAmod.put("checkin", "2021-08-01");
		bookingDatesMapForAmod.put("checkout", "2021-08-02");
		
		bookingOne.put("bookingdates", bookingDatesMapForAmod);
		bookingOne.put("additionalneeds", "Breakfast");
		
		// JSON Object for second guest
		Map<String,Object> bookingTwo = new HashMap<String,Object>();
		bookingTwo.put("firstname", "Animesh");
		bookingTwo.put("lastname", "Prashant");
		bookingTwo.put("totalprice", 111);
		bookingTwo.put("depositpaid", true);
		
		Map<String,String> bookingDatesMapForAnimesh = new HashMap<>();
		bookingDatesMapForAnimesh.put("checkin", "2021-07-01");
		bookingDatesMapForAnimesh.put("checkout", "2021-07-01");
		
		bookingTwo.put("bookingdates", bookingDatesMapForAnimesh);
		bookingTwo.put("additionalneeds", "Breakfast");
		
		// Creating JSON array to add both JSON objects
		List<Map<String,Object>> jsonArrayPayload = new ArrayList<>();
		
		jsonArrayPayload.add(bookingOne);
		jsonArrayPayload.add(bookingTwo);
		
		
		
		//GIVEN
		RestAssured
		   .given()
			  .baseUri("https://restful-booker.herokuapp.com/booking")
			  .contentType(ContentType.JSON)
			  .body(jsonArrayPayload)
			  .log()
			  .all()
		// WHEN
		   .when()
			   .post()
		// THEN
		   .then()
			   .assertThat()
			   // Asserting status code as 500 as it does not accept json array payload
			   .statusCode(500)
			   .log()
			   .all();
	}

}

