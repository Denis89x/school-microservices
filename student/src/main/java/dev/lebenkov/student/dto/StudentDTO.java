package dev.lebenkov.student.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDTO {
    String firstname;

    String lastname;

    String email;

    Integer schoolId;

}
