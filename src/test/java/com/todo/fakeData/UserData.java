package com.todo.fakeData;

import com.github.javafaker.Faker;
import com.todo.Actions.UserActions;
import com.todo.pojo.User;
import io.restassured.response.Response;

// generation fake data for user
public class UserData {
    public static User generateFakeUser()
    {
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email=faker.internet().emailAddress();
        String password="12345678";
        return new User(firstName,lastName,email,password);
    }
    public static User getRegisteredUser()
    {
         User user=generateFakeUser();
        UserActions.registerUser(user);
        return user;

    }
    public static String getTokenn()
    {
      User user= generateFakeUser();
     Response response= UserActions.registerUser(user);
      return response.body().path("access_token");

    }




}
