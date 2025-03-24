package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String testController() {
        return "Hello World";
    }

    @GetMapping("/testGetMapping")
    public String testControllerWithPath() {
        return "Hello World! testGetMapping";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id ) {
        return "Hello World! testPathVariables " + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerWithRequestParam(@RequestParam(required = false) int id) {
        return "Hello World! testRequestParam " + id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerWithRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Hello World! testRequestBody " + testRequestBodyDTO.getId() + "Message " + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerWithResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("Hello World!");
        list.add("Choi Seung Hoon");

        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        return response;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerWithResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        return ResponseEntity.ok().body(response);
    }
}








