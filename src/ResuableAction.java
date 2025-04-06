import io.restassured.path.json.JsonPath;

public class ResuableAction {
	
	public static JsonPath rawToJson(String response)
	{
		return new JsonPath(response);
	}

}
