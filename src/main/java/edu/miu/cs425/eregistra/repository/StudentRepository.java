package edu.miu.cs425.eregistra.repository;

import edu.miu.cs425.eregistra.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAllByFirstNameContainingOrLastNameContainingOrMiddleNameContaining(
            String firstName, String lastName, String middleName);
}
