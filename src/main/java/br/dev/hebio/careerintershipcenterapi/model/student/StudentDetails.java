package br.dev.hebio.careerintershipcenterapi.model.student;

import java.time.LocalDateTime;

public record StudentDetails(
        String name,
        String registration,
        String cpf,
        String email,
        String password,
        String role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String course,
        LocalDateTime admissionDate,
        LocalDateTime graduationDate,
        String situation
) {

    public StudentDetails(Student student) {
        this(student.getName(),
                student.getRegistration(),
                student.getCpf(),
                student.getEmail(),
                student.getPassword(),
                student.getRole(),
                student.getCreatedAt(),
                student.getUpdatedAt(),
                student.getCourse(),
                student.getAdmissionDate(),
                student.getGraduationDate(),
                student.getSituation());
    }
}
