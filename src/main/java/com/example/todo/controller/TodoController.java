package com.example.todo.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.todo.model.*;
import com.example.todo.service.*;
=======
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;

>>>>>>> f4d1cfcb5a1d0c3c9b4a97b61ce06b849eb675e6

@RestController
public class TodoController {

<<<<<<< HEAD
    @Autowired
    private TodoH2Service todoService;
=======
    TodoService todoService = new TodoService();
>>>>>>> f4d1cfcb5a1d0c3c9b4a97b61ce06b849eb675e6

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/todos/{id}")
<<<<<<< HEAD
    public Todo getTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
=======
    public Todo getTodoByid(@PathVariable("id") int id) {
        return todoService.getTodoByid(id);
>>>>>>> f4d1cfcb5a1d0c3c9b4a97b61ce06b849eb675e6
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

<<<<<<< HEAD
    @PutMapping("/todos/{id}") 
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo) {
=======
    @PutMapping("/todos/{id}")
    Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
>>>>>>> f4d1cfcb5a1d0c3c9b4a97b61ce06b849eb675e6
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
<<<<<<< HEAD
    public void deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
    }
}
=======
    public void deleteTodo(@PathVariable("id") int id){
        todoService.deleteTodo(id);
    }
}
>>>>>>> f4d1cfcb5a1d0c3c9b4a97b61ce06b849eb675e6
