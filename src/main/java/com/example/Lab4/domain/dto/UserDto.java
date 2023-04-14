package com.example.Lab4.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    long id;
    String name;
    List<PostDto> posts;
    @JsonIgnore
    String password;
    String token;
}