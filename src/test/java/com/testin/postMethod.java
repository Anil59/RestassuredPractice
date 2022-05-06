package com.testin;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

public class postMethod {
	
	static int Newid = ComplexJson.ranInt(1,1000);

	public static void main(String[] args) {
		
		String city = ComplexJson.getAlphaNumericString(10);
		
		String description = ComplexJson.getAlphaNumericString(15);
				
		String name = ComplexJson.getAlphaNumericString(8);
					
		int rating = ComplexJson.ranInt(1,1000);
				
		 RestAssured.baseURI = "http://localhost:8090/example/v1/hotels/";
		 
		 //post 
	 
		 Response response = given()
	                .header("Content-type", "application/json")
	                .body(ComplexJson.postbody(city,description,Newid,name,rating))
	                .when()
	                .post("postDetails")
	                .then().log().all()
	                .extract().response();
		 
		 System.out.println("Response is "+response.getHeader("Location"));
		 
		 String getIdValArr[] = response.getHeader("Location").split("/");

		 String getIdVal = getIdValArr[getIdValArr.length-1];
		
		 System.out.println("getIdValue is "+getIdVal);
		 
		 Assert.assertEquals(201, response.statusCode());
		 
		 //Get Method 
		
		 given().header("Content-Type","application/json").
				
		 when().log().all().get(getIdVal).
		
		 then().log().all().assertThat().statusCode(200);
		 
		
		 //put Method 
		 
		 given().header("Content-Type","application/json")
		 
		 //.pathParam("id", Long.parseLong(getIdVal))
		 
		 .body(ComplexJson.postbody(city,description,Integer.valueOf(getIdVal),ComplexJson.getAlphaNumericString(8),rating)).
		 
		 when().log().all().put(getIdVal).

		 then().log().all().extract().response();
		 
		//Get Method 
			
		 given().header("Content-Type","application/json").
				
		 when().log().all().get(getIdVal).
		
		 then().log().all().assertThat().statusCode(200);
		 
		 
		 //Delete 
		 
		 given().
		 
		 when().log().all().delete(getIdVal).
		 
		 then().log().all().assertThat().statusCode(204);
		 
		//Get Method 
			
		 given().header("Content-Type","application/json").
				
		 when().log().all().get(getIdVal).
		
		 then().log().all().assertThat().statusCode(404);

			 

	}

}
