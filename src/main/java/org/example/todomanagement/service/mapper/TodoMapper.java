package org.example.todomanagement.service.mapper;

import org.example.todomanagement.dto.TodoDto;
import org.example.todomanagement.entity.Todo;

public class TodoMapper {
    public static Todo toEntity(TodoDto todoDto) {
        Todo todo = new Todo(
                todoDto.getId(),
                todoDto.getTitle(),
                todoDto.getDescripton(),
                todoDto.isComleted()
        );
        return todo;

    }


    public static TodoDto toDto(Todo todo){

        TodoDto todoDto=new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescripton(),
                todo.isComleted()

        );
        return todoDto;

    }
}
