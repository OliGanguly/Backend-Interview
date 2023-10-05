package com.example.RestClient.Controller;

import com.example.RestClient.Model.TodoResponse;
import com.example.RestClient.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class Todo {
    //get single todo
    @Autowired
    private TodoService todoService;

    public Todo(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public TodoResponse getSingleTodo(@PathVariable int id){
        return  todoService.getTodo(id);

    }
}
