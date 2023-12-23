package dev.lebenkov.school.service;

import dev.lebenkov.school.dto.SchoolDTO;
import dev.lebenkov.school.model.FullSchoolResponse;
import dev.lebenkov.school.model.School;

import java.util.List;

public interface SchoolService {
    void saveSchool(SchoolDTO schoolDTO);

    List<School> findAllSchools();

    FullSchoolResponse findSchoolsWithStudent(Integer schoolId);
}
