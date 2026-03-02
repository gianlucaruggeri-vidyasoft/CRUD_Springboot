package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<StudentDTO> getAll() {
        return service.findAll();
    }
    @GetMapping("/{id}")
    public StudentDTO getOne(@PathVariable String id) {
    return service.findById(id);
}

    @PostMapping
    public StudentDTO create(@RequestBody Student student) {
        return service.create(student);
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable String id, @RequestBody Student student) {
        return service.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}