import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider = "BooksData")
	public void addBook(String s1,String s2) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().header("Content-Type","application/json")
				.body(payload.addBook(s1,s2))
				.when().post("Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
		JsonPath js = ResuableAction.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
	}

	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"sdssss","9363"},{"jgjks","4355"},{"bjkk","6889"}};
	}
	

}
