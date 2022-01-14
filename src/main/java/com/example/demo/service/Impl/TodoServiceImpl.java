package com.example.demo.service.Impl;

import com.example.demo.Model.Todo;
import com.example.demo.exception.TodoDuplicatedException;
import com.example.demo.exception.TodoNotFoundException;
import com.example.demo.service.TodoService;
import lombok.Data;
import org.springframework.stereotype.Service;
import com.example.demo.repository.TodoRepository;

import java.util.List;

@Service
@Data
public class TodoServiceImpl implements TodoService {
    final TodoRepository todoRepository;


    @Override
    public Todo save(Todo todo) throws TodoDuplicatedException {
        Todo todoFromDB = todoRepository.findById(todo.getId()).orElse(null);
        if(todoFromDB != null)
            throw new TodoDuplicatedException(todo.getId());
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(Todo todo) throws TodoNotFoundException {
        Todo todoFromDB = todoRepository.findById(todo.getId()).orElse(null);
        if (todoFromDB == null)
            throw new TodoNotFoundException(todo.getId());
         todo.setId(todoFromDB.getId());
        return todoRepository.save(todo);
    }

    @Override
    public Long delete(Long id) throws TodoNotFoundException {
        Todo todoFromDB = todoRepository.findById(id).orElse(null);
        if (todoFromDB == null)
            throw new TodoNotFoundException(id);
        todoRepository.delete(todoFromDB);
        return id;
    }

    @Override
    public List<Todo> findAll() {

        return todoRepository.findAll();
    }
}
