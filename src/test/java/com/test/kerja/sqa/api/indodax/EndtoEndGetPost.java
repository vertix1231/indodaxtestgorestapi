package com.test.kerja.sqa.api.indodax;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class EndtoEndGetPost {
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
		System.out.println("this is create user==============================");
		map.put("name", RestUtils.getFirstName()+"ipbvertix123456789");
		map.put("gender", "male");
		map.put("email", RestUtils.getFirstName()+"ipbvertix123456789@gmail.com");
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
		System.out.println("this is create post==================================");
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
		System.out.println("this is create todo==============================================");
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
	@Test(priority = 3)
	public void getalluserbyid() {
		System.out.println("this is get user by id=============================================");
		String path="/public/v2/users/"+paramuserid;
		String fixpath=path;
		System.out.println(fixpath);
		 Response response =given()
		.auth().oauth2(token)
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.when()
			.get(baseUri+path);
		
		System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        ValidatableResponse validateResponse=response.then().statusCode(200).log().all();
//        ValidatableResponse validateResponseid=response.then().j;
       
	}
	@Test(priority = 4)
	public void getpostcontent() {
		System.out.println("this is get post content by id========================================");
		String path="/public/v2/users/"+paramuserid+"/posts";
		 Response response =given()
		.auth().oauth2(token)
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.when()
		.get(baseUri+path);
//		.get(baseUri+path);
		 
		 System.out.println("Response status code: " + response.getStatusCode());
	        System.out.println("Response body: " + response.getBody().asString());
	        ValidatableResponse validateResponse=response.then().statusCode(200).log().all();
	       
	}
	@Test(priority = 5)
	public void getcomment() {
		System.out.println("this is get comment by id===============================================");
		String path="/public/v2/posts/"+paramuserid+"/comments";
		Response response =given()
		.auth().oauth2(token)
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.when()
			.get(baseUri+path);
		
		 System.out.println("Response status code: " + response.getStatusCode());
	        System.out.println("Response body: " + response.getBody().asString());
	        ValidatableResponse validateResponse=response.then().statusCode(200).log().all();
	       
//		.get(baseUri+path)
	}
	@Test(priority = 6)
	public void gettodo() {
		System.out.println("this is get todo by id================================================");
		String path="/public/v2/users/"+paramuserid+"/todos";
		Response response =given()
		.auth().oauth2(token)
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.when()
			.get(baseUri+path);
		
		 System.out.println("Response status code: " + response.getStatusCode());
	        System.out.println("Response body: " + response.getBody().asString());
	        ValidatableResponse validateResponse=response.then().statusCode(200).log().all();
	       
	}
}
