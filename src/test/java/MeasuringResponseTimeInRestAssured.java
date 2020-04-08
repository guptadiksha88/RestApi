import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class MeasuringResponseTimeInRestAssured {
	
	@Test
	public void mesaureResponseTimeUsingResponseOptionsMethods()
	{
		// There is no need to add escape character manually. Just paste string within double 
		// quotes. It will automatically add escape sequence as required. 
		String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		
		// Create a request specification 
		RequestSpecification request= RestAssured.given();
		
		// Setting content type to specify format in which request payload will be sent.
		// ContentType is an ENUM. 
		request.contentType(ContentType.JSON);
		//Adding URI
		request.baseUri("https://restful-booker.herokuapp.com/auth");
		// Adding body as string
		request.body(jsonString);
		
		// Calling POST method on URI. After hitting we get Response
		Response response = request.post();
		
		// By default response time is given in milliseconds
		long responseTime1 = response.getTime();
		System.out.println("Response time in ms using getTime():"+responseTime1);
		
		// we can get response time in other format as well
		long responseTimeInSeconds = response.getTimeIn(TimeUnit.SECONDS);
		System.out.println("Response time in seconds using getTimeIn():"+responseTimeInSeconds);
		
		
		// Similar methods 
		long responseTime2 = response.time();
		System.out.println("Response time in ms using time():"+responseTime2);
		
		long responseTimeInSeconds1 = response.timeIn(TimeUnit.SECONDS);
		System.out.println("Response time in seconds using timeIn():"+responseTimeInSeconds1);
		
	}

	@Test
	public void mesaureResponseTimeUsingValidatableResponseOptionsMethods() {
		
		// There is no need to add escape character manually. Just paste string within
		// double
		// quotes. It will automatically add escape sequence as required.
		String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";

		// Create a request specification
		RequestSpecification request = RestAssured.given();

		// Setting content type to specify format in which request payload will be sent.
		// ContentType is an ENUM.
		request.contentType(ContentType.JSON);
		// Adding URI
		request.baseUri("https://restful-booker.herokuapp.com/auth");
		// Adding body as string
		request.body(jsonString);

		// Calling POST method on URI. After hitting we get Response
		Response response = request.post();

		// Getting ValidatableResponse type
		ValidatableResponse valRes = response.then();
		// Asserting response time is less than 2000 milliseconds
		// L just represent long. It is in millisecond by default.
		valRes.time(Matchers.lessThan(3000L));
		// Asserting response time is greater than 2000 milliseconds
		valRes.time(Matchers.greaterThan(2000L));
		// Asserting response time in between some values
		valRes.time(Matchers.both(Matchers.greaterThanOrEqualTo(2000L)).and(Matchers.lessThanOrEqualTo(3000L)));

		// If we want to assert in different time units
		valRes.time(Matchers.lessThan(3L), TimeUnit.SECONDS);
		
				
				
	}
	
}
