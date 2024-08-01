package com.test.kerja.sqa.api.indodax;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class UserPost {
	String baseUri="";
	String paramuserid="";
	String token="864ba7fd66f0e86658fee3c51809f945696f9d20f07482e6f69a7f4dd4614c26";
	JSONObject map = new JSONObject();
//	Stringreqdata+"";
	@BeforeClass
	public void setupget() {
//		baseUri="https://restful-booker.herokuapp.com";
		baseUri="https://gorest.co.in";
		
	}
	
	@Test(priority = 0)
	public void createuser() {
		map.put("name", "ipbvertix123456789");
		map.put("gender", "male");
		map.put("email", "ipbvertix123456789@gmail.com");
		map.put("status", "active");
		
		System.out.println(map.toJSONString());
		String param="/public/v2/users";
	        Response response = RestAssured.given()
	                .header("Accept", "application/json")
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer " + token)
	                .body(map.toJSONString())
	                .post(baseUri+param)
	                ;
	        System.out.println("Response status code: " + response.getStatusCode());
	        System.out.println("Response body: " + response.getBody().asString());
	        ValidatableResponse validateResponse=response.then().statusCode(201).log().all();
	        paramuserid=response.jsonPath().getString("id");
	        System.out.println(paramuserid);
	        map.clear();
	}
	@Test(priority = 1)
	public void createuserpost() {
		map.put("body", "vvertix1234 isi body post");
		map.put("title", "vvertix1234 isi body title post");
		
		System.out.println(map.toJSONString());
		String param="/public/v2/users/"+paramuserid+"/posts";
	        Response response = RestAssured.given()
	                .header("Accept", "application/json")
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer " + token)
	                .body(map.toJSONString())
	                .post(baseUri+param);
	        System.out.println("Response status code: " + response.getStatusCode());
	        System.out.println("Response body: " + response.getBody().asString());
	        ValidatableResponse validateResponse=response.then().statusCode(201).log().all();
	        map.clear();
	}
	@Test(priority = 2)
	public void createtodo() {
		map.put("title", "vvertix1234 test title todo");
		map.put("message", "male");
		map.put("status", "completed");
		map.put("due_on", "2024-08-02T00:00:00.000+05:30");
		
		System.out.println(map.toJSONString());
		String param="/public/v2/users/"+paramuserid+"/todos";
	        Response response = RestAssured.given()
	                .header("Accept", "application/json")
	                .header("Content-Type", "application/json")
	                .header("Authorization", "Bearer " + token)
	                .body(map.toJSONString())
	                .post(baseUri+param);
	        
	        System.out.println("Response status code: " + response.getStatusCode());
	        System.out.println("Response body: " + response.getBody().asString());
	        ValidatableResponse validateResponse=response.then().statusCode(201).log().all();
	        map.clear();
	}
	
//	@Test(priority = 3)
//	public void createcomment() {
//		map.put("name", "namevvertix1234 test title todo");
//		map.put("email", "malevertix@gmail.com");
//		map.put("body", "completed completed 13ead dd");
//		map.put("posts", "must exisit");
//		
//		System.out.println(map.toJSONString());
//		String param="/public/v2/posts/"+paramuserid+"/comments";
//	        Response response = RestAssured.given()
//	                .header("Accept", "application/json")
//	                .header("Content-Type", "application/json")
//	                .header("Authorization", "Bearer " + token)
//	                .body(map.toJSONString())
//	                .post(baseUri+param);
//	        
//	        System.out.println("Response status code: " + response.getStatusCode());
//	        System.out.println("Response body: " + response.getBody().asString());
//	        ValidatableResponse validateResponse=response.then().statusCode(200).log().all();
//	        
//	       
//	        map.clear();
//	}
}
