import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderExample {

	public static void main(String[] args) {

		// Creating an object of RequestSpecBuilder 
		// request specification can also be taken as Requestspecbuilder class
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		// Setting Base URI
		reqBuilder.setBaseUri("https://restful-booker.herokuapp.com");
		// Setting Base Path
		reqBuilder.setBasePath("/booking");
		//reqBuilder.setPort(8081); // if port is available
		// Getting RequestSpecification reference using builder() method
		RequestSpecification reqSpec = reqBuilder.build();
		
		// Usage in different styles
		// We can directly call http verbs on RequestSpecification
		Response res1= reqSpec.get();
		System.out.println(res1.asString());
		
		
	}
}

