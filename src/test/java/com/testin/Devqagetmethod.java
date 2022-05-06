package com.testin;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Devqagetmethod {

@BeforeClass

public static void url()

{
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

}

@Test
public void getRequest()
{
	
	Response response = given()
            .contentType(ContentType.JSON)
            .when()
            .get("/posts")
            .then()
            .extract().response();
	
	System.out.println(response.toString());
	
    Assert.assertEquals(200, response.statusCode());
    Assert.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
}


}



