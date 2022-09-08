package pe.edu.com.attendance.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.edu.com.attendance.attendance.domain.ClassSession;
import pe.edu.com.attendance.attendance.domain.Student;
import pe.edu.com.attendance.attendance.services.IStudentsService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentsController {

    @Autowired
    private IStudentsService studentsService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listStudents(Model model){

        List<Student> studentsList = studentsService.findAll();

        model.addAttribute("students",studentsList);

        model.addAttribute("title","List Students");

        return "student/students";

    }

    @GetMapping("/form")
    public String formStudent(Model model){

        Student student = new Student();

        model.addAttribute("title","Create New Student");

        model.addAttribute("student", student);

        return "/student/form";
    }

    @RequestMapping(value = "/form-student",method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student")  Student student,
                                   Model model){

        studentsService.save(student);

        return "redirect:/student/list";

    }





}
