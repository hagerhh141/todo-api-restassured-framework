package com.todo.Actions;

import com.todo.base.SpecsBase;
import com.todo.pojo.User;
import com.todo.utils.PropertyReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
// steps of testcases inside a method (given when then)
public class UserActions {
    public static Response registerUser(User user){

        return
                given()
                        .spec(SpecsBase.requestSpecification())
                        .body(user)
                        .when().post(PropertyReader.getProperty("registerEndpoint"))
                        .then().log().all().extract().response();
    }
    public static Response loginUser(User user)
    {
        return  given()
                .spec(SpecsBase.requestSpecification())
                .body(user)
                .when().post(PropertyReader.getProperty("loginEndpoint"))
                .then().log().all().extract().response();
    }
}
