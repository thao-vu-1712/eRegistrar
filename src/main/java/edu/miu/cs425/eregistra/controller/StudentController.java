package edu.miu.cs425.eregistra.controller;

import edu.miu.cs425.eregistra.model.Student;
import edu.miu.cs425.eregistra.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/eregistrar/students")
    public String studentsPage(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "public/students";
    }

    @GetMapping("/eregistrar/register")
    public String registerGetPage(Model model){
        model.addAttribute("student", new Student());
        return "public/register";
    }

    @PostMapping("/eregistrar/register")
    public String saveStudent(@ModelAttribute("student") Student student) {
        System.out.println("THAO:" + student);
        studentService.saveStudent(student);
        return "redirect:/eregistrar/students";
    }

    @PostMapping("/eregistrar/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId, Model model) {
        studentService.delete(studentId);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/eregistrar/edit/{studentId}")
    public String editStudentGetPage(@PathVariable Long studentId, Model model){
        Student student = studentService.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
        }
        else {
            model.addAttribute("student", new Student());
        }
        return "public/edit";
    }

    @PostMapping("/eregistrar/edit/{studentId}")
    public String editStudent(@ModelAttribute("student") Student student, @PathVariable Long studentId){
        student.setStudentId(studentId);
        studentService.saveStudent(student);
        return "redirect:/eregistrar/students";
    }

    @GetMapping(value = {"/eregistrar/search"})
    public ModelAndView searchStudents(@RequestParam String searchString) {
        var modelAndView = new ModelAndView();
        var students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("public/students");
        return modelAndView;
    }
}
