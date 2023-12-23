package dev.lebenkov.student.controller;

import dev.lebenkov.student.dto.StudentDTO;
import dev.lebenkov.student.model.Student;
import dev.lebenkov.student.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {

    StudentService studentService;

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody StudentDTO studentDTO) {
        studentService.saveStudent(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student was successfully saved!");
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudents(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }
}
