package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/v1")
    public List<StudentDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}/v1")
    public StudentDTO getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/v1")
    public StudentDTO create(@RequestBody Student student) {
        return service.create(student);
    }

    @PutMapping("/{id}/v1")
    public StudentDTO update(@PathVariable String id, @RequestBody Student student) {
        return service.update(id, student);
    }

    @DeleteMapping("/{id}/v1")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}