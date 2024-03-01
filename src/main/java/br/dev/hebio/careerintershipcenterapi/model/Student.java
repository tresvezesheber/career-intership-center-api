package br.dev.hebio.careerintershipcenterapi.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User{

    @NotEmpty
    private String registration;

    @NotEmpty
    private String course;

    @NotEmpty
    private LocalDateTime admissionDate;

    private LocalDateTime graduationDate;

    private String situation;
}
