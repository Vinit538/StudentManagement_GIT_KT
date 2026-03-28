package com.gitkt.student.service;

import com.gitkt.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        System.out.println("[SOFT] fetching all students");
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        if (id <= 0) throw new RuntimeException("Invalid student id: " + id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public Student createStudent(Student student) {
        System.out.println("[MIXED] creating student");
        return repository.save(student);
    }
    //Update student
    public Student updateStudent(Long id, Student updated) {
        Student existing = getStudentById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setCourse(updated.getCourse());
        existing.setGrade(updated.getGrade());
        return repository.save(existing);
    }
    //Get Student by course and grade
    public List<Student> getStudentsByCourse(String course) {
        if (course == null || course.isBlank()) throw new RuntimeException("Course cannot be empty");
        return repository.findByCourse(course);
    }

    public List<Student> getStudentsByGrade(String grade) {
        if (grade == null || grade.isBlank()) throw new RuntimeException("Grade cannot be empty");
        return repository.findByGrade(grade);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
