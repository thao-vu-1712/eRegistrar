package edu.miu.cs425.eregistra.service.impl;

import edu.miu.cs425.eregistra.model.Student;
import edu.miu.cs425.eregistra.repository.StudentRepository;
import edu.miu.cs425.eregistra.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student book) {
        return studentRepository.save(book);
    }

    @Override
    public Student getStudentById(Long bookId) {
        return studentRepository.findById(bookId).orElse(null);
    }

    @Override
    public Student delete(Long bookId) {
        Student student = getStudentById(bookId);
        if (student != null) {
            studentRepository.delete(student);
        }
        return student;
    }

    @Override
    public Iterable<Student> searchStudents(String queryString) {
        return studentRepository.findAllByFirstNameContainingOrLastNameContainingOrMiddleNameContaining(queryString, queryString, queryString);
    }
}
