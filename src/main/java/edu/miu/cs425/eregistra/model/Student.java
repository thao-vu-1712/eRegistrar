package edu.miu.cs425.eregistra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long studentId = 0L;

    @NotNull(message = "Student Number must not be null")
    @NotEmpty // != ""
    @NotBlank // != "   "
    private String studentNumber;
    @NotNull(message = "First Name must not be null")
    @NotEmpty // != ""
    @NotBlank // != "   "
    private String firstName;
    private String middleName;
    @NotNull(message = "Last Name must not be null")
    @NotEmpty // != ""
    @NotBlank // != "   "
    private String lastName;
    private Double cgpa;
    @NotNull(message = "enrollmentDate must not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enrollmentDate;
    @NotNull(message = "isInternational must not be null")
    private boolean internationalStudent;


}
