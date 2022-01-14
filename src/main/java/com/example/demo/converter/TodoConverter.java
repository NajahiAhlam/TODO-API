package com.example.demo.converter;

import com.example.demo.Model.Todo;
import com.example.demo.dto.TodoDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class TodoConverter extends AbstractConverter<Todo, TodoDto>{
    private final ModelMapper modelMapper;


    public TodoConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.modelMapper = modelMapper;
    }

    @Override
    public Todo convertToDM(TodoDto todoDto) {
        return modelMapper.map(todoDto, Todo.class);
    }

    @Override
    public TodoDto convertToDTO(Todo todo) {
        return modelMapper.map(todo, TodoDto.class);
    }
}
