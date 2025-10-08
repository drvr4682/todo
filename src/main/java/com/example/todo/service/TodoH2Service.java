package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.todo.model.Todo;
import com.example.todo.model.TodoRowMapper;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoH2Service implements TodoRepository {
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Todo> getTodos(){
        List<Todo> todoList = db.query("SELECT * FROM TODOLIST", new TodoRowMapper());
        return new ArrayList<>(todoList);
    }
    
    @Override
    public Todo getTodoById(int id){
        try {
            return db.queryForObject("SELECT * FROM TODOLIST WHERE ID = ?", new TodoRowMapper(), id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
    @Override
    public Todo addTodo(Todo todo){
        String sql = "INSERT INTO TODOLIST(TODO, STATUS, PRIORITY) VALUES (?, ?, ?)";
        db.update(sql, todo.getTodo(), todo.getStatus(), todo.getPriority());

        Todo savedTodo = db.queryForObject(
            "SELECT * FROM TODOLIST WHERE TODO = ? AND STATUS = ? AND PRIORITY = ?",
            new TodoRowMapper(), todo.getTodo(), todo.getStatus(), todo.getPriority()
        );

        return savedTodo;
    }

    @Override
    public Todo updateTodo(int id, Todo todo){
        Todo existing = getTodoById(id);

        if (todo.getTodo() != null) {
            db.update("UPDATE TODOLIST SET TODO = ? WHERE ID = ?", todo.getTodo(), id);
        }

        if(todo.getStatus() != null) {
            db.update("UPDATE TODOLIST SET STATUS = ? WHERE ID = ?", todo.getStatus(), id);
        }

        if(todo.getPriority() != null) {
            db.update("UPDATE TODOLIST SET PRIORITY = ? WHERE ID = ?", todo.getPriority(), id);
        }

        return getTodoById(id);
    }
    
    @Override
    public void deleteTodo(int id){
        int rowsAffected = db.update("DELETE FROM TODOLIST WHERE ID = ?", id);

        if (rowsAffected == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
