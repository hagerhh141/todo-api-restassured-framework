package com.todo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Todo {
    private Boolean isCompleted; //  default boolean IN POJO CLASS =false so we add     @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  // but if i give it false in tc it will ignore it so we use Boolean
    @JsonProperty("_id")
    private String id;
    private String item;
    private String userID;
    private String createdAt;
    @JsonProperty("__v")
    private String v;
public Todo(){}
    public Todo(Boolean isCompleted, String item) {
    this.isCompleted=isCompleted;
    this.item=item;
    }
    public Todo(String item) {
        this.item=item;
    }
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
    @JsonProperty("_id")

    public String getId() {
        return id;
    }
    @JsonProperty("_id")

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    @JsonProperty("__v")

    public String getV() {
        return v;
    }
    @JsonProperty("__v")

    public void setV(String v) {
        this.v = v;
    }


}
