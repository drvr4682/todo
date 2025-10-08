package com.example.todo.model;

public class Todo {
    private int id;
    private String todo;
<<<<<<< HEAD
    private String status;
    private String priority;

    public Todo() {}

    public Todo(int id, String todo, String status, String priority) {
        this.id = id;
        this.todo = todo;
        this.status = status;
        this.priority = priority;
    }

    public int getId() { 
        return id;
    }

=======
    private String priority;
    private String status;

    public Todo() {}

    public Todo(int id, String todo, String priority, String status) {
        this.id = id;
        this.todo = todo;
        this.priority = priority;
        this.status = status;
    }

    public int getId() {
        return id;
    }
>>>>>>> f4d1cfcb5a1d0c3c9b4a97b61ce06b849eb675e6
    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD
    public String getTodo() {
=======
    public String getTodo(){
>>>>>>> f4d1cfcb5a1d0c3c9b4a97b61ce06b849eb675e6
        return todo;
    }
    public void setTodo(String todo) {
        this.todo = todo;
    }

<<<<<<< HEAD
=======
    public String getPriority(){
        return priority;
    }
    public void  setPriority(String priority) {
        this.priority = priority;
    }

>>>>>>> f4d1cfcb5a1d0c3c9b4a97b61ce06b849eb675e6
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
<<<<<<< HEAD

    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
=======
>>>>>>> f4d1cfcb5a1d0c3c9b4a97b61ce06b849eb675e6
}