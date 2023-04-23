package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return todoService.findAll();
    }

    @GetMapping("/user/{username}/todos")
    public List<Todo> retrieveTodosByUser(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @GetMapping("/todo/{id}")
    public Todo retrieveTodoByID(@PathVariable int id) {
        return todoService.findById(id);
    }

    @PostMapping("/user/{username}/todo")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = todoService.addTodo(username,todo.getDescription(),todo.getTargetDate(),todo.isDone());
        return createdTodo;
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/todo/{id}")
    public Todo updateTodo(@RequestBody Todo todo) {
        todoService.updateTodo(todo);
        return todo;
    }
}
