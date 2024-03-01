package br.dev.hebio.careerintershipcenterapi.model.student;

import java.time.LocalDateTime;

public record StudentView(
    String name,
    String registration,
    String cpf,
    String email,
    String course,
    LocalDateTime admissionDate,
    LocalDateTime graduationDate,
    String situation
) {
}
