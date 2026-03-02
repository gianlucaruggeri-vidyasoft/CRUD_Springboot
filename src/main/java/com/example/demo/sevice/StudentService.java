package com.example.demo.sevice;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    private StudentDTO toDTO(Student s) {
        StudentDTO dto = new StudentDTO();
        dto.setId(s.getId());
        dto.setName(s.getName());
        dto.setSurname(s.getSurname());
        dto.setEmail(s.getEmail());
        return dto;
    }

    public List<StudentDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO create(Student student) {
        return toDTO(repository.save(student));
    }

    public StudentDTO update(String id, Student details) {
        return repository.findById(id).map(s -> {
            s.setName(details.getName());
            s.setSurname(details.getSurname());
            s.setEmail(details.getEmail());
            return toDTO(repository.save(s));
        }).orElseThrow(() -> new RuntimeException("Studente non trovato"));
    }

    public StudentDTO findById(String id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Studente non trovato"));
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}