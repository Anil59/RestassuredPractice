package com.testin;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class complexjsonValidation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String responseJson  = new String (Files.readAllBytes(Paths.get("E:\\EclipseWork2\\RestAssuredproject\\src\\test\\resources\\com\\complexJson")));
		
		System.out.println(responseJson);
		
		JsonPath respval = new JsonPath(responseJson);
		
		System.out.println(respval.getList("problems").size());
		
		System.out.println(respval.getList("problems.Diabetes").size());
		
		System.out.println(respval.getList("problems.Diabetes").size());
		
		System.out.println(respval.get("associatedDrug.name[1]"));
		
		System.out.println(respval.get(".medicationsClasses.className[1,2]"));
		
		
		
		

	}

}
