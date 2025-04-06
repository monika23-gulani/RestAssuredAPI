import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Given to get the data initial setup- headers, body,query paarameters, base url
		 When - resource , http method type -submit APi
		 Then - assertions*/
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		System.out.println("POST METHOD CALL");
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.addPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		// Convert the response from string to json
		JsonPath path = new JsonPath(response);
		String place_id=path.getString("place_id");
		System.out.println(place_id);
		
		// Update place using5 put
		String address="100 winter walk, USA";
		System.out.println("PUT METHOD CALL");
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"place_id\": \""+place_id+"\",\r\n"
				+ "    \"address\": \""+address+"\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		// Get place using get method call
		System.out.println("GET METHOD CALL");
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", place_id)
				.when().get("maps/api/place/get/json")
				.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js=ResuableAction.rawToJson(getPlaceResponse);
		String actualAddress = js.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, address);
		
	}

}
