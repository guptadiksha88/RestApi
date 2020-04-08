import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BuilderPatternRestAssured {

	public static void main(String[] args) {

		// Way1
		RequestSpecification req = RestAssured.given();
		req = req.accept(ContentType.JSON);
		req = req.auth().preemptive().basic("username", "password");
		req = req.header("headername", "headervalue");
		req = req.param("paramname", "paramvalue");
		req = req.cookie("cookieName", "value");

		// Way2

		/*
		 * RequestSpecification req1 = RestAssured.given() .accept(ContentType.JSON)
		 * .auth().preemptive().basic("username", "password") .header("headername",
		 * "headervalue") .param("paramname", "paramvalue") .cookie("cookieName",
		 * "value");
		 */	}

}
