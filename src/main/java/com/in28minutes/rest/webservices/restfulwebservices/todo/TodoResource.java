package com.in28minutes.rest.webservices.restfulwebservices.todo;

import com.in28minutes.rest.webservices.restfulwebservices.todo.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private TodoRepository todoRepository;

    public TodoResource(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/user/{username}/todos")
    public List<Todo> retrieveTodosByUser(@PathVariable String username) {
        return todoRepository.findByUsername(username);
    }

    @GetMapping("/todo/{id}")
    public Todo retrieveTodoByID(@PathVariable int id) {
        return todoRepository.findById(id).get();
    }

    @PostMapping("/todo")
    public Todo createTodo(@RequestBody Todo todo) {
//        Todo createdTodo = todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        todo.setId(null);
        Todo createdTodo = todoRepository.save(todo);
        return createdTodo;
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/todo/{id}")
    public Todo updateTodo(@RequestBody Todo todo) {
        todoRepository.save(todo);
        return todo;
    }
}
