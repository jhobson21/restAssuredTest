package getRequest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetData {
	
	
	@Test
	public void testResponseCodeFromFullName() {
		
		String name = "Aruba";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/name/" + name + "?fullText=true");
		
		System.out.println("testResponseCodeFromFullName");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 200);
		System.out.println("Status code is "+code);
		
		JsonPath jsonPathEvaluator = resp.jsonPath();
		String capital = jsonPathEvaluator.get("capital[0]");
		String country = jsonPathEvaluator.get("name[0]");
		System.out.println("Capital city of " + country + " is " + capital);
	}
	
	@Test
	public void testResponseCodeFromPartialName() {
		
		String name = "Arub";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/name/" + name);
		
		System.out.println("testResponseCodeFromPartialName");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 200);
		System.out.println("Status code is "+code);
		
		JsonPath jsonPathEvaluator = resp.jsonPath();
		String capital = jsonPathEvaluator.get("capital[0]");
		String country = jsonPathEvaluator.get("name[0]");
		System.out.println("Capital city of " + country + " is " + capital);
	}
	
	@Test
	public void testResponseCodeFromPartialNameWithMultipleMatches() {
		
		String name = "Aru";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/name/" + name);
		
		System.out.println("testResponseCodeFromPartialNameWithMultipleMatches");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 200);
		System.out.println("Status code is "+code);
		
		String names = resp.jsonPath().getString("name");
		System.out.println("Matching countries are: " + names);
		String capital = resp.jsonPath().getString("capital");
		System.out.println("Capital cities are: " + capital);
	}
	
	@Test
	public void testResponseCodeFromCountryCode() {
		
		String code = "usa";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/alpha/" + code);
		
		System.out.println("testResponseCodeFromCountryCode");
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status code is "+statusCode);
		
		JsonPath jsonPathEvaluator = resp.jsonPath();
		String capital = jsonPathEvaluator.get("capital");
		String country = jsonPathEvaluator.get("name");
		System.out.println("Capital city of " + country + " is " + capital);
	}
	
}
