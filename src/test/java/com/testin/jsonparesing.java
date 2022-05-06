package com.testin;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class jsonparesing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		String response = given().queryParam("page","2").
		
		when().get().
		
		then().log().all().assertThat().statusCode(200).extract().asString();
	
		JsonPath respjson = new JsonPath(response);
		
		//System.out.println(respjson.getInt("per_page"));
		
		System.out.println(respjson.getList("data").size());
		
		for(int i=0;i<=respjson.getList("data").size()-1;i++)
		{
		System.out.println("Id Value is "+respjson.get("data["+i+"].id"));
		System.out.println("email Value is " + respjson.get("data["+i+"].email"));
		System.out.println("first_name is  " + respjson.get("data["+i+"].first_name"));
		System.out.println("last_name is " + respjson.get("data["+i+"].last_name"));
		System.out.println("avatar is " + respjson.get("data["+i+"].avatar"));
		
		}

		
		System.out.println(respjson.get("support.url"));
		
		System.out.println(respjson.get("support.text"));
		

	}

}
