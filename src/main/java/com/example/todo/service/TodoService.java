package com.example.todo.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();
    int uniqueTodoId = 6;

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }
 
    @Override
    public ArrayList<Todo> getTodos() {
        return new ArrayList<>(todoList.values());
    }
    
    @Override
    public Todo getTodoByid(int id) {
        Todo todo = todoList.get(id);
        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return todo;
    }
    
    @Override
    public Todo addTodo(Todo todo) {
        todo.setId(uniqueTodoId);
        todoList.put(uniqueTodoId, todo);
        uniqueTodoId += 1;
        return  todo;
    }
    
    @Override
    public Todo updateTodo(int id, Todo todo) {
        Todo existingTodo = todoList.get(id);
        if (existingTodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (todo.getTodo() != null) {
            existingTodo.setTodo(todo.getTodo());
        }
        if (todo.getPriority() != null) {
            existingTodo.setPriority(todo.getPriority());
        }
        if (todo.getStatus() != null) {
            existingTodo.setStatus(todo.getStatus());
        }
        return existingTodo;
    }
    
    @Override
    public void deleteTodo(int id) {
        Todo todo = todoList.get(id);
        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            todoList.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
