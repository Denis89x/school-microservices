package dev.lebenkov.school.controller;

import dev.lebenkov.school.dto.SchoolDTO;
import dev.lebenkov.school.model.FullSchoolResponse;
import dev.lebenkov.school.model.School;
import dev.lebenkov.school.service.SchoolService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SchoolController {

    SchoolService schoolService;

    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody SchoolDTO studentDTO) {
        schoolService.saveSchool(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("School was successfully saved!");
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllStudents() {
        return ResponseEntity.ok(schoolService.findAllSchools());
    }

    @GetMapping("/with-student/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllStudents(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolsWithStudent(schoolId));
    }
}
