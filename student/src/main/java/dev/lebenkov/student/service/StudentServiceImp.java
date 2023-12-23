package dev.lebenkov.student.service;

import dev.lebenkov.student.dto.StudentDTO;
import dev.lebenkov.student.model.Student;
import dev.lebenkov.student.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentServiceImp implements StudentService {

    StudentRepository studentRepository;
    ModelMapper modelMapper;

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        studentRepository.save(convertToStudent(studentDTO));
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }

    private Student convertToStudent(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }
}
