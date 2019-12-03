package getRequest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BadData {

	@Test
	public void testResponseCodeFromBadFullName() {
		
		String name = "Arubs";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/name/" + name + "?fullText=true");
		
		System.out.println("testResponseCodeFromBadFullName");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 404);
		System.out.println("Status code is "+code);
	}
	
	@Test
	public void testResponseCodeFromNumericFullName() {
		
		String name = "1989";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/name/" + name + "?fullText=true");
		
		System.out.println("testResponseCodeFromNumericFullName");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 404);
		System.out.println("Status code is "+code);
	}
	
	@Test
	public void testResponseCodeFromAlphaNumericFullName() {
		
		String name = "Arub09";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/name/" + name + "?fullText=true");
		
		System.out.println("testResponseCodeFromAlphaNumericFullName");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 404);
		System.out.println("Status code is "+code);
	}
	
	@Test
	public void testResponseCodeFromBadPartialName() {
		
		String name = "aaab";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/name/" + name);
		
		System.out.println("testResponseCodeFromBadPartialName");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 404);
		System.out.println("Status code is "+code);
	}
	
	@Test
	public void testResponseCodeFromNumericPartialName() {
		
		String name = "1348";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/name/" + name);
		
		System.out.println("testResponseCodeFromNumericPartialName");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 404);
		System.out.println("Status code is "+code);
	}
	
	@Test
	public void testResponseCodeFromBadCountryCode() {
		
		String code = "ZQ";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/alpha/" + code);
		
		System.out.println("testResponseCodeFromBadCountryCode");
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 404);
		System.out.println("Status code is "+statusCode);
	}	
	
	@Test
	public void testResponseCodeFromNumericCountryCode() {
		
		String code = "13";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/alpha/" + code);
		
		System.out.println("testResponseCodeFromNumericCountryCode");
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 404);
		System.out.println("Status code is "+statusCode);
	}
	
	@Test
	public void testResponseCodeFromCountryCodeTooLong() {
		
		String code = "usabd";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/alpha/" + code);
		
		System.out.println("testResponseCodeFromCountryCodeTooLong");
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 400);
		System.out.println("Status code is "+statusCode);
	}
	
	@Test
	public void testResponseCodeFromFullNameTooLong() {
		
		String name = "Arubas";
		Response resp = RestAssured.get("https://restcountries.eu/rest/v2/name/" + name + "?fullText=true");
		
		System.out.println("testResponseCodeFromFullNameTooLong");
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 404);
		System.out.println("Status code is "+code);
	}
}
