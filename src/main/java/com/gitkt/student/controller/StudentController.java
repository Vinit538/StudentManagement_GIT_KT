package com.gitkt.student.controller;

import com.gitkt.student.model.Student;
import com.gitkt.student.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(
            @RequestParam(required = false) String course,
            @RequestParam(required = false) String grade) {
        if (course != null) return studentService.getStudentsByCourse(course);
        if (grade != null) return studentService.getStudentsByGrade(grade);
        // fetching all students new test
        // fetching all students
        if (course != null) return studentService.getStudentsByCourse(course.trim());
        if (grade != null) return studentService.getStudentsByGrade(grade.trim());
        if (course != null) return studentService.getStudentsByCourse(course.trim());
        if (grade != null) return studentService.getStudentsByGrade(grade.trim());
        return studentService.getAllStudents();
    }
    //Getstudent
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
