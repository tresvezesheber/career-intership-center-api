package br.dev.hebio.careerintershipcenterapi.service;

import br.dev.hebio.careerintershipcenterapi.model.student.Student;
import br.dev.hebio.careerintershipcenterapi.model.student.StudentDetails;
import br.dev.hebio.careerintershipcenterapi.model.student.StudentUpdate;
import br.dev.hebio.careerintershipcenterapi.model.student.StudentView;
import br.dev.hebio.careerintershipcenterapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Page<StudentDetails> getPaginatedList(Pageable pageable) {
        List<StudentDetails> students = studentRepository.findAll(pageable).map(StudentDetails::new).getContent();
        return new PageImpl<>(students, pageable, students.size());
    }

    public StudentDetails getById(Long id) {
        return studentRepository.findById(id).map(StudentDetails::new).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
    }

    private Student findStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
    }

    public void save(StudentView studentView) {
        studentRepository.save(new Student(studentView));
    }

    public StudentDetails updateFromView(Long id, StudentView studentView) {
        Student student = findStudentById(id);

        student.setName(studentView.name());
        student.setRegistration(studentView.registration());
        student.setCpf(studentView.cpf());
        student.setEmail(studentView.email());
        student.setCourse(studentView.course());
        student.setAdmissionDate(studentView.admissionDate());
        student.setGraduationDate(studentView.graduationDate());
        student.setSituation(studentView.situation());

        Student updatedStudent = studentRepository.save(student);

        return new StudentDetails(updatedStudent);
    }

    public void updatePassword(Long id, StudentUpdate studentUpdate) {
        Student student = findStudentById(id);

        student.setPassword(studentUpdate.password());

        studentRepository.save(student);
    }

    public void delete(Long id) {
        Student student = findStudentById(id);

        studentRepository.delete(student);
    }
}
