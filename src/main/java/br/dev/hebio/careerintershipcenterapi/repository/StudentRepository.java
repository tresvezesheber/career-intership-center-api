package br.dev.hebio.careerintershipcenterapi.repository;

import br.dev.hebio.careerintershipcenterapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
