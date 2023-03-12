package com.sheff.tutorials.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;

    @NotEmpty(message = "Name Surname cannot be empty")
    @Size(min = 1, max = 255)
    private String teacherNameSurname;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email")
    private String teacherEmail;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, max = 18)
    private String teacherPassword;
}
