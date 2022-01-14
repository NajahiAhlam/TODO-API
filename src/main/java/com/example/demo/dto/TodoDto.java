package com.example.demo.dto;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TodoDto {
    @NotNull
    private Long id;
    @NotBlank
    @NotNull
    private String content;
    private Boolean done = false;
}
