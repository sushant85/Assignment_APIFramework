package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;




public class StepUser {
	//Calling Endpoint and storing usernames
	@Given("call ENDPOINT and store all username")
	public static void main(String[] args){
		
		Response response = doGetRequest("https://jsonplaceholder.typicode.com/");
		String usernames=response.jsonPath().getString("username");
		System.out.println(usernames);
	}
	
	//fetching all details and storing in Response
	@When("extract all details with Get http request")
	public static Response doGetRequest(String endpoint){
		RestAssured.defaultParser=Parser.JSON;
		
		return
				given().headers("Content-Type", ContentType.JSON,"Accept",ContentType.JSON).when()
				.get(endpoint).then().contentType(ContentType.JSON).extract().response();
	} 
	
	//validating if user name equal to "Delphine" then print username else not
	@Then("validate user able to find specific username or not")
	
	public void checkusername(String usernames)
	{
		for( String user:usernames)
		{
			Assert.assertEquals(user, "Delphine");
			System.out.println(user);
		}
		
	}
	
	
}		
		


