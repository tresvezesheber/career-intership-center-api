package br.dev.hebio.careerintershipcenterapi.model.student;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record StudentUpdate(
        @NotEmpty
        String password
) {
}
