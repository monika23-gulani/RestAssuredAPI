import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class sumOfCourses {

	@Test
	public void sumOfCourses()
	{
		int sum=0;
		JsonPath js=new JsonPath(payload.complexJson());
		int count = js.getInt("courses.size()");
		for (int i = 0; i < count; i++) {
			int price = js.get("courses[" + i + "].price");
			int copies = js.get("courses[" + i + "].copies");
			int amount = price*copies;
			sum = sum+amount;
			
		}
		System.out.println("Total amount"+sum);
		int purchaseAMount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAMount);
	}
}
