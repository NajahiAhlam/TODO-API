package com.example.demo.controller;

import com.example.demo.service.TodoService;
import com.example.demo.converter.TodoConverter;
import com.example.demo.dto.TodoDto;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("todo")
@Data
public class TodoController {
    final TodoService todoService;
    final TodoConverter todoConverter;
    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody TodoDto todoDto) throws Exception {
        if (todoDto == null)
            return ResponseEntity.badRequest().body(" todo is not valid");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todoConverter.convertToDTO(todoService.save(todoConverter.convertToDM(todoDto))));
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@Valid @RequestBody TodoDto todoDto) throws Exception {
        if (todoDto == null)
            return ResponseEntity.badRequest().body("todo is not valid");
        return ResponseEntity
                .ok()
                .body(todoConverter.convertToDTO(todoService.update(todoConverter.convertToDM(todoDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        if (id == null)
            return ResponseEntity.badRequest().body("todo's id is not valid");
        return ResponseEntity.ok().body("todo [" + todoService.delete(id) + "] deleted successfully.");
    }

    @GetMapping("/")
    public ResponseEntity<List<TodoDto>> findAll() {
        return ResponseEntity.ok().body(todoConverter.convertToDTOs(todoService.findAll()));
    }

}
