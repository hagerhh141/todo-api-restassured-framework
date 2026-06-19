package com.todo.Test;

import com.todo.Actions.UserActions;
import com.todo.fakeData.UserData;
import com.todo.pojo.ErrorMsg;
import com.todo.pojo.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class UserTest {
    @Test
    public void userShouldBeAbleToRegister()
    {
        User user= UserData.generateFakeUser();
        Response response= UserActions.registerUser(user);
        User returnedUser =response.body().as(User.class); // deserilization of response body
        assertThat(response.statusCode(),equalTo(201));
        assertThat(returnedUser.getFirstName(),equalTo(user.getFirstName()));
    }
    @Test
    public void userShouldNotRegisterWithEmailThatAlreadyExist()
    {

        User user= UserData.getRegisteredUser();
        Response response= UserActions.registerUser(user);
        ErrorMsg returnedError=response.body().as(ErrorMsg.class);
        assertThat(response.statusCode(),equalTo(400));
        assertThat(returnedError.getMessage(),equalTo("Email is already exists in the Database"));

    }
    @Test

    public void userAbleToLoginWithExistEmailAndValidPassword()
    { User user= UserData.getRegisteredUser();
        User loginData =new User(user.getEmail(),user.getPassword());
           Response response= UserActions.loginUser(loginData);
        User returnedUser=response.body().as(User.class);

        assertThat(response.statusCode(),equalTo(200));
        assertThat(returnedUser.getAccessToken(),not(equalTo(null)));
        assertThat(returnedUser.getFirstName(),equalTo(user.getFirstName()));

            //   assertThat(response.path("access_token"),not(equalTo(null)));
        // best practice that we made   User returnedUser=response.body().as(User.class); and use retuned user under it to deserilise the response body

    }
    @Test
    public void userAbleToLoginWithExistEmailAndInValidPassword()
    {
        User user= UserData.getRegisteredUser();
        User loginDta=new User(user.getEmail(),"1234569999");
        Response response=   UserActions.loginUser(loginDta);
        ErrorMsg returnedErr=response.body().as(ErrorMsg.class);
        assertThat(response.statusCode(),equalTo(401));
        assertThat(returnedErr.getMessage(),equalTo("The email and password combination is not correct, please fill a correct email and password"));
                 }

}
