package com.gitkt.student.service;

import com.gitkt.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class StudentRepository {

    private final List<Student> store = new ArrayList<>();
    private final AtomicLong idSeq = new AtomicLong(4);

    public StudentRepository() {
        store.add(new Student(1L, "Alice Johnson", "alice@example.com", "Computer Science", "A"));
        store.add(new Student(2L, "Bob Smith",    "bob@example.com",   "Mathematics",      "B"));
        store.add(new Student(3L, "Carol White",  "carol@example.com", "Physics",          "A"));
        store.add(new Student(4L, "White Carol S",  "white@example.com", "Physics",          "B"));
        store.add(new Student(6L, "White S",  "swhite@example.com", "Civil",          "A"));
        store.add(new Student(7L, "Johnson", "johnson@example.com", "Computer Science", "B"));
    }

    public List<Student> findAll() { return store; }

    public Optional<Student> findById(Long id) {
        return store.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(idSeq.getAndIncrement());
            store.add(student);
            return student;
        }
        store.removeIf(s -> s.getId().equals(student.getId()));
        store.add(student);
        return student;
    }

    public List<Student> findByCourse(String course) {
        return store.stream().filter(s -> s.getCourse().equalsIgnoreCase(course)).toList();
    }

    public List<Student> findByGrade(String grade) {
        return store.stream().filter(s -> s.getGrade().equalsIgnoreCase(grade)).toList();
    }

    public void deleteById(Long id) {
        store.removeIf(s -> s.getId().equals(id));
    }
}
