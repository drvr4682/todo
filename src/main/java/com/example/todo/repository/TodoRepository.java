package com.example.todo.repository;

import java.util.ArrayList;

import com.example.todo.model.Todo;

public interface TodoRepository {
    ArrayList<Todo> getTodos();
<<<<<<< HEAD
    Todo getTodoById(int id);
=======
    Todo getTodoByid(int id);
>>>>>>> f4d1cfcb5a1d0c3c9b4a97b61ce06b849eb675e6
    Todo addTodo(Todo todo);
    Todo updateTodo(int id, Todo todo);
    void deleteTodo(int id);
}