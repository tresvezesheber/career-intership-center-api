package br.dev.hebio.careerintershipcenterapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User{

    @NotEmpty
    @Column(unique = true)
    private String registration;

    @NotEmpty
    private String course;

    @NotEmpty
    private LocalDateTime admissionDate;

    private LocalDateTime graduationDate;

    private String situation;
}
