package com.test.kerja.sqa.api.indodax;

import static org.testng.Assert.assertEquals;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class UserGet {
	String baseUri="";
//	String paramuserid="7271924";
//	String parampostid="6940545";
//	String paramcommentid="6940545";
//	String paramtodoid="6940545";
	UserPost userPost = new UserPost();
	private String getparamuserid=userPost.paramuserid;
	String token="864ba7fd66f0e86658fee3c51809f945696f9d20f07482e6f69a7f4dd4614c26";
	@BeforeClass
	public void setupget() {
		baseUri="https://gorest.co.in";
	}

	@Test
	public void getalluserbyid() {
		String path="/public/v2/users/";
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
	@Test
	public void getpostcontent() {
		String path="/public/v2/posts";
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
	@Test
	public void getcomment() {
		String path="/public/v2/comments";
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
	@Test
	public void gettodo() {
		String path="/public/v2/todos";
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
