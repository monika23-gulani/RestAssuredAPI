import io.restassured.path.json.JsonPath;

public class complexJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(payload.complexJson());
		int count = js.getInt("courses.size()");
		System.out.println(count);

		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);

		String title = js.get("courses[0].title");
		System.out.println(title);

		for (int i = 0; i < count; i++) {
			System.out.println(js.get("courses[" + i + "].title").toString());
			System.out.println(js.get("courses[" + i + "].price").toString());
		}

		System.out.println("print no of courses sold by RPA course");
		for (int i = 0; i < count; i++) {
			String courseTile = js.get("courses[" + i + "].title");
			if (courseTile.equalsIgnoreCase("RPA")) {
				int copies = js.get("courses[" + i + "].copies");
				System.out.println(copies);
				break;
			}
		}


	}

}
