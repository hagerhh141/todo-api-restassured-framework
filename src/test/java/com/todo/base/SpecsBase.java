package com.todo.base;

import com.todo.utils.PropertyReader;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class SpecsBase {
    public static RequestSpecification requestSpecification()
    {
        return given()
                .baseUri(PropertyReader.getProperty("baseUrl"))
                .contentType(ContentType.JSON);

    }
}
