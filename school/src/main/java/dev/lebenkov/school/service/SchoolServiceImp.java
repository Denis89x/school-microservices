package dev.lebenkov.school.service;

import dev.lebenkov.school.client.StudentClient;
import dev.lebenkov.school.dto.SchoolDTO;
import dev.lebenkov.school.model.FullSchoolResponse;
import dev.lebenkov.school.model.School;
import dev.lebenkov.school.repository.SchoolRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SchoolServiceImp implements SchoolService {

    SchoolRepository schoolRepository;
    StudentClient studentClient;
    ModelMapper modelMapper;

    @Override
    public void saveSchool(SchoolDTO schoolDTO) {
        schoolRepository.save(convertToSchool(schoolDTO));
    }

    @Override
    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public FullSchoolResponse findSchoolsWithStudent(Integer schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );

        var students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }

    private School convertToSchool(SchoolDTO schoolDTO) {
        return modelMapper.map(schoolDTO, School.class);
    }
}
