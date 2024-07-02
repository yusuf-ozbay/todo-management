package org.example.todomanagement.service;

import org.example.todomanagement.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto,Long id);
    void deleteTodo(Long id);

}
