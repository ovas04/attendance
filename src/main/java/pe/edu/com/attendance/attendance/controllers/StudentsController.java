package pe.edu.com.attendance.attendance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.edu.com.attendance.attendance.domain.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentsController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listStudents(Model model){

        List<Student> studentsList = new ArrayList<>();

        studentsList.add(new Student("Giro","Pinto"));

        studentsList.add(new Student("Oscar","Lobaton"));

        model.addAttribute("students",studentsList);

        model.addAttribute("title","List Students");

        return "students";

    }

    @RequestMapping(value="/form", method =RequestMethod.GET)
    public String newStudentForm(Model model){

        model.addAttribute("title", "Create New Student");
        return "/student/form";
    }



}
