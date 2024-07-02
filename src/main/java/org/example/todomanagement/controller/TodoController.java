package org.example.todomanagement.controller;

import lombok.AllArgsConstructor;
import org.example.todomanagement.dto.TodoDto;
import org.example.todomanagement.entity.Todo;
import org.example.todomanagement.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/todos")
public class TodoController {

    private TodoService todoService;


    @PostMapping("createTodo")
    public ResponseEntity<TodoDto> adTodo(@RequestBody TodoDto todoDto) {
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long id) {

        TodoDto todoDto = todoService.getTodo(id);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);

    }


    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodo() {

        List<TodoDto> todoDtos = todoService.getAllTodos();
        //return new ResponseEntity<>(todoDtos,HttpStatus.OK);
        //buda başka kullanımı
        return ResponseEntity.ok(todoDtos);

    }

    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long todoId, @RequestBody TodoDto todoDto) {
        // @PathVariable anotasyonu, URL'den gelen id parametresini todoId değişkenine atar.
        // @RequestBody anotasyonu, istek gövdesinden gelen JSON verisini todoDto nesnesine dönüştürür.

        // todoService.updateTodo() metodunu çağırarak, belirtilen id'ye sahip Todoo'yu günceller ve güncellenmiş TodoDto nesnesini alır.
        TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);

        // Güncellenen TodoDto nesnesini HTTP 200 OK durum kodu ile birlikte döndürür.
        return ResponseEntity.ok(updatedTodo);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id")  Long todoId) {

        todoService.deleteTodo(todoId);

        return ResponseEntity.ok("todo deleted successfully!.");

    }

}
