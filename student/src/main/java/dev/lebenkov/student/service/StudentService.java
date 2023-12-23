package dev.lebenkov.student.service;

import dev.lebenkov.student.dto.StudentDTO;
import dev.lebenkov.student.model.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentDTO studentDTO);

    List<Student> findAllStudents();

    List<Student> findAllStudentsBySchool(Integer schoolId);
}
