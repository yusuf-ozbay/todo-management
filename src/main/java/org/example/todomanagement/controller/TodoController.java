package org.example.todomanagement.controller;

import lombok.AllArgsConstructor;
import org.example.todomanagement.dto.TodoDto;
import org.example.todomanagement.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/todos")
public class TodoController {

    private TodoService todoService;


    @PostMapping("createTodo")
    public ResponseEntity<TodoDto> adTodo(@RequestBody TodoDto todoDto){

        TodoDto savedTodo =todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);

    }


}
