package edu.miu.cs425.eregistra.repository;

import edu.miu.cs425.eregistra.model.Role;
import edu.miu.cs425.eregistra.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
