package edu.miu.cs.cs425.eregistrarwebapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotNull(message = "studentNumber is required")
    @NotBlank(message = "student Number can not be blank")
    private String studentNumber;
    @NotNull(message = "First Name is required")
    @NotBlank(message = "First Name can not be blank")
    private String firstName;
    private String middleName;
    @NotNull(message = "Last Name is required")
    @NotBlank(message = "Last Name can not be blank")
    private String lastName;
    private Double cgpa;
    @NotNull(message = "Enrollment date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    private String isInternational;

    public Student(String studentNumber, String firstName, String middleName,
                   String lastName, Double cgpa, LocalDate enrollmentDate, String isInternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }
}
