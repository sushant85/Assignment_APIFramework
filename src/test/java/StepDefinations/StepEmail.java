package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.given;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepEmail {
	
	//calling Endpoint
	@Given("call Endpoint")
	public void call_endpoint(){
		RestAssured.baseURI= "https://jsonplaceholder.typicode.com/comments";
		
	}
	//fetching details of the posts written by user.
	@When("I Perform Get for the PostId")
	public void I_Perform_Get_for_the_PostId(){
	Response postid = given().contentType(ContentType.JSON).log().all().get("/1");
	System.out.println(postid);		
	}
	
//fetching email of the pots and validating email format.
	@Then("Validate Emails are in proper formats or not")
	public void Validate_Emails_are_in_proper_formats_or_not(){
		Response email = given().contentType(ContentType.JSON).log().all().get("/1")
				.then().extract().path("email");
		
	System.out.println(email);
	
	}
	String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	 
	Pattern pattern = Pattern.compile(regex);
	 
	for(String emails: email){
	    Matcher matcher = pattern.matcher(emails);
	    System.out.println(emails +" : "+ matcher.matches());
	}
	
	}
		
}


