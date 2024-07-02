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

        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(TodoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
        // Belirtilen id'ye sahip mevcut Todoo'yu veritabanından alalım. Eğer mevcut değilse, bir ResourceNotFoundException fırlatalım.
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        // Güncel verileri Todoo nesnesine atayalım.
        todo.setTitle(todoDto.getTitle());
        todo.setDescripton(todoDto.getDescripton());
        todo.setComleted(todoDto.isComleted());

        // Güncellediğimiz Todoo nesnesini veritabanında kaydedelim.
        Todo updatedTodo = todoRepository.save(todo);

        // Güncellenen Todoo nesnesini TodoDto olarak döndürelim.
        return TodoMapper.toDto(updatedTodo);
    }

    @Override
    public void deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("todo not found with id :" + id));
        todoRepository.deleteById(id);

    }

    @Override
    public TodoDto completeTodo(Long id) {
        //Başta id ile mevcut todoo yu alıyoruz sonra o todoyu günvelleyeceğiz.
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found whit id  :" + id));
        todo.setComleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);
        return TodoMapper.toDto(updatedTodo);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found whit id  :" + id));
        todo.setComleted(Boolean.FALSE);

        Todo updatedTodo = todoRepository.save(todo);
        return TodoMapper.toDto(updatedTodo);

    }


}


