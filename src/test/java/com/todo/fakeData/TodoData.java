package com.todo.fakeData;

import com.github.javafaker.Faker;
import com.todo.Actions.TodoActions;
import com.todo.pojo.Todo;
import io.restassured.response.Response;

public class TodoData {
    public static Todo generateFakeTodo()
    {
        Faker faker=new Faker();
        String item=faker.book().title();
        Boolean isCompleted=false;
        return new Todo(isCompleted,item);
    }
    public static String getTodoID(Todo todo,String token)
    {
     Response response= TodoActions.addTask(todo,token);
     return response.body().path("_id");
    }
}
