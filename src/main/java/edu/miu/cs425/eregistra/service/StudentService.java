package edu.miu.cs425.eregistra.service;

import edu.miu.cs425.eregistra.model.Student;

public interface StudentService {
    Iterable<Student> getAllStudents();
    Student saveStudent(Student book);
    Student getStudentById(Long bookId);
    Student delete(Long bookId);

    public Iterable<Student> searchStudents(String queryString);

}
