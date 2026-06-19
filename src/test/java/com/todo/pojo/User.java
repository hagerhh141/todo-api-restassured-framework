package com.todo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
// pojo class that have private variables ,their setters and getters
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
// JsonProperty this is for json to can read _
    @JsonProperty("access_token")
    private String accessToken;
    private String userID;

public User(){}
    public User(String firstName,String lastName,String email,String password){
    this.firstName=firstName;
    this.lastName=lastName;
    this.email=email;
    this.password=password;
    }
    public User(String email,String password){
    this.email=email;
    this.password=password;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }
    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
