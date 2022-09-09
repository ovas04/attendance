package pe.edu.com.attendance.attendance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.edu.com.attendance.attendance.dao.IStudentDao;
import pe.edu.com.attendance.attendance.domain.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentsController {

    @Autowired
    private IStudentDao studentDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listStudents(Model model){

        model.addAttribute("students",studentDao.findAll());

        model.addAttribute("title","List Students");

        return "students";

    }

    @RequestMapping(value="/form", method =RequestMethod.GET)
    public String newStudentForm(Model model){

        Student student = new Student();

        model.addAttribute("student",student);

        model.addAttribute("title", "Create New Student");

        return "/student/form";
    }

    @RequestMapping(value = "/form-student", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student, Model model){

        studentDao.save(student);

        return "redirect:/student/list";
    }



}
