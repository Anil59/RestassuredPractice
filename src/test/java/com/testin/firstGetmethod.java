package com.testin;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class firstGetmethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI  = "http://localhost:8090/example/v1/hotels";
		given().log().all().queryParam("page","1").queryParam("size","5")
		.when().log().all().get()
		.then().log().all().assertThat().statusCode(200);

	}

}
