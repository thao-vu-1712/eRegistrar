package edu.miu.cs425.eregistra.config;

import edu.miu.cs425.eregistra.model.Role;
import edu.miu.cs425.eregistra.model.User;
import edu.miu.cs425.eregistra.repository.RoleRepository;
import edu.miu.cs425.eregistra.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserCreator {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository rolRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void init() {
        Role admin = new Role("ROLE_ADMIN", null);
        List<Role> adminRoles = new ArrayList<>();
        admin = rolRepository.save(admin);
        Role student = new Role("ROLE_STUDENT",null);
        List<Role> studentRoles = new ArrayList<>();
        student = rolRepository.save(student);
        Role registrar = new Role("ROLE_REGISTRAR",null);
        List<Role> registrarRoles = new ArrayList<>();
        registrar = rolRepository.save(registrar);
        adminRoles.add(admin);

        User user = userRepository.save(new User("ana.admin@eregistrar.com", bCryptPasswordEncoder.encode("Manager0"), true, true, true, true, null));
        userRepository.save(user);
        user.setRoles(adminRoles);
        userRepository.save(user);

        registrarRoles.add(registrar);
        userRepository.save(new User("bob.registrar@eregistrar.com", bCryptPasswordEncoder.encode("Manager0"), true, true, true, true, registrarRoles));


        studentRoles.add(student);
        userRepository.save(new User("carlos.student@eregistrar.com", bCryptPasswordEncoder.encode("Manager0"), true, true, true, true, studentRoles));
    }
}
