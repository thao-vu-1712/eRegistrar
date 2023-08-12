package edu.miu.cs425.eregistra.controller;

import edu.miu.cs425.eregistra.model.Student;
import edu.miu.cs425.eregistra.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
    final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/eregistrar/api/student/list")
    public ResponseEntity<Iterable<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping(path = "/eregistrar/api/student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable(name = "studentId") Long studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PostMapping(path = "/eregistrar/api/student/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PutMapping(path = "/eregistrar/api/student/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable(name = "studentId") Long studentId, @RequestBody Student student) {
        student.setStudentId(studentId);
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @DeleteMapping(path = "/eregistrar/api/student/{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable(name = "studentId") Long studentId) {
        return ResponseEntity.ok(studentService.delete(studentId));
    }


}
