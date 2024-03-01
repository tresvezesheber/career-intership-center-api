package br.dev.hebio.careerintershipcenterapi.controller;

import br.dev.hebio.careerintershipcenterapi.model.student.StudentDetails;
import br.dev.hebio.careerintershipcenterapi.model.student.StudentUpdate;
import br.dev.hebio.careerintershipcenterapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<StudentDetails>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return ResponseEntity.ok(studentService.getPaginatedList(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDetails> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity updatePassword(@PathVariable Long id, StudentUpdate studentUpdate) {
        studentService.updatePassword(id, studentUpdate);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
