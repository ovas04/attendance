package pe.edu.com.attendance.attendance.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.edu.com.attendance.attendance.domain.ClassSession;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AttendanceController {

    @RequestMapping(value = {"/index","/home"}, method = RequestMethod.GET)
    public String listSessions(Model model){

        ClassSession classSession = new ClassSession("Session 1","");

        List<ClassSession> classSessionList = new ArrayList<>();

        classSessionList.add(classSession);

        classSessionList.add(new ClassSession("Session 2","El profesor boto a un alumno"));

        model.addAttribute("title","List Sessions");

        model.addAttribute("classSessionList", classSessionList);

        return "index";
    }

    @GetMapping("/form")
    public String formSession(Model model){

        ClassSession classSession = new ClassSession();

        model.addAttribute("title","Create New Session Class");

        model.addAttribute("classSession", classSession);

        return "formSession";
    }

    @RequestMapping(value = "/formSession",method = RequestMethod.POST)
    public String saveClassSession(@ModelAttribute("classSession")  ClassSession classSession,
                                   Model model){

        String  name = classSession.getName();

        return "redirect:/index";
    }


}
