package org.example.todomanagement.service.impl;

import lombok.AllArgsConstructor;
import org.example.todomanagement.dto.TodoDto;
import org.example.todomanagement.entity.Todo;
import org.example.todomanagement.repository.TodoRepository;
import org.example.todomanagement.service.TodoService;
import org.example.todomanagement.service.mapper.TodoMapper;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {



        Todo todo = TodoMapper.toEntity(todoDto);
        Todo savedTodo = todoRepository.save(todo);
        return TodoMapper.toDto(savedTodo);


    }

}
