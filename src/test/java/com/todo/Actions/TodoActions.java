package com.todo.Actions;

import com.todo.base.SpecsBase;
import com.todo.pojo.Todo;
import com.todo.utils.PropertyReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TodoActions {
    public static Response addTask(Todo todo,String token)
    {
        return given()
                .spec(SpecsBase.requestSpecification())
        .auth().oauth2(token)
                .body(todo)
                .when().post(PropertyReader.getProperty("taskAddEndPoint"))
                .then().log().all().extract().response();
    }
    public static Response getATask(String token,String itemId)
    {
        return given()
                .spec(SpecsBase.requestSpecification())
                .auth().oauth2(token)
                .when().get(PropertyReader.getProperty("tasksEndpoint")+itemId)
                .then().log().all().extract().response();
    }
    public static Response deleteTask(String token,String itemId)
    {
        return given()
                .spec(SpecsBase.requestSpecification())
                .auth().oauth2(token)
                .when().delete(PropertyReader.getProperty("tasksEndpoint")+itemId)
                .then().log().all().extract().response();
    }
}
