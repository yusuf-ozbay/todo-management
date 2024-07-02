package org.example.todomanagement.service.impl;

import lombok.AllArgsConstructor;
import org.example.todomanagement.dto.TodoDto;
import org.example.todomanagement.entity.Todo;
import org.example.todomanagement.exception.ResourceNotFoundException;
import org.example.todomanagement.repository.TodoRepository;
import org.example.todomanagement.service.TodoService;
import org.example.todomanagement.service.mapper.TodoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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


    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found With id :" + id));
        return TodoMapper.toDto(todo);
    }

    @Override
    public List<TodoDto> getAllTodos() {

        List<Todo> todos= todoRepository.findAll();
        return todos.stream().map(TodoMapper::toDto).collect(Collectors.toList());
    }

}


