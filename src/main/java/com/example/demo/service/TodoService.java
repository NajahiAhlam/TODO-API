package com.example.demo.service;

import com.example.demo.Model.Todo;
import com.example.demo.exception.TodoDuplicatedException;
import com.example.demo.exception.TodoNotFoundException;

import java.util.List;

public interface TodoService {


    Todo save(Todo todo) throws TodoDuplicatedException;

    Todo update(Todo todo) throws TodoNotFoundException;

    Long delete(Long id) throws TodoNotFoundException;

    List<Todo> findAll();
}
