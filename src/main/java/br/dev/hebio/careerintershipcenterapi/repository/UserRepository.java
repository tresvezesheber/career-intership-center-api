package br.dev.hebio.careerintershipcenterapi.repository;

import br.dev.hebio.careerintershipcenterapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
