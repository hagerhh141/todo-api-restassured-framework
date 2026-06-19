package com.todo.Test;

import com.todo.Actions.TodoActions;
import com.todo.fakeData.TodoData;
import com.todo.fakeData.UserData;
import com.todo.pojo.ErrorMsg;
import com.todo.pojo.Todo;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class TodoTest {
    Todo todo;
    @Test
    public void userAbleToAddTasks()
    {
        String token= UserData.getTokenn();
        Todo todo= TodoData.generateFakeTodo();
        Response response= TodoActions.addTask(todo,token);
        Todo returnedTodo= response.body().as(Todo.class);
        assertThat(response.statusCode(),equalTo(201));
        assertThat(returnedTodo.getItem(),equalTo(todo.getItem()));
    }
    @Test
    public void userNotAbleToAddTasksWithoutIsComplete()
    { todo=new Todo("Learn Appium");
        String token= UserData.getTokenn();
        Response response= TodoActions.addTask(todo,token);
        ErrorMsg returnedError=response.body().as(ErrorMsg.class);
        assertThat(response.statusCode(),equalTo(400));
        assertThat(returnedError.getMessage(),equalTo("\"isCompleted\" is required"));
        //assertThat(response.path("message"),equalTo("\"isCompleted\" is required"));
    }
    @Test
    public void userAbleToGetSingleTaskWithID()
    {
        String token= UserData.getTokenn();
        Todo todo= TodoData.generateFakeTodo();
       String todoID=TodoData.getTodoID(todo,token);
        Response response=  TodoActions.getATask(token,todoID);
        Todo returnedTodo= response.body().as(Todo.class);
          assertThat(response.statusCode(),equalTo(200));
                assertThat(returnedTodo.getItem(),equalTo(todo.getItem()));
    }
    @Test
    public void userAbleToDeleteTaskWithID()
    {
        String token= UserData.getTokenn();
        Todo todo= TodoData.generateFakeTodo();
        String todoID=TodoData.getTodoID(todo,token);
        Response response=  TodoActions.deleteTask(token,todoID);
        Todo returnedTodo= response.body().as(Todo.class);

        assertThat(response.statusCode(),equalTo(200));
        assertThat(returnedTodo.getItem(),equalTo(todo.getItem()));

    }
    }

