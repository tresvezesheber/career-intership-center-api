package br.dev.hebio.careerintershipcenterapi.model.student;

import br.dev.hebio.careerintershipcenterapi.model.User;
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
public class Student extends User {

    @NotEmpty
    private String course;

    @NotEmpty
    private LocalDateTime admissionDate;

    private LocalDateTime graduationDate;

    private String situation;

    public Student(StudentView studentView) {
        super(studentView.name(), studentView.registration(), studentView.cpf(), studentView.email(), studentView.cpf(), "ROLE_STUDENT");
        this.course = studentView.course();
        this.admissionDate = studentView.admissionDate();
        this.graduationDate = studentView.graduationDate();
        this.situation = studentView.situation();
    }
}
