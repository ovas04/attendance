package pe.edu.com.attendance.attendance.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.edu.com.attendance.attendance.domain.ClassSession;
import pe.edu.com.attendance.attendance.service.ISessionService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AttendanceController {

    @Autowired
    private ISessionService sessionService;


    @RequestMapping(value = {"/","/index","/home"}, method = RequestMethod.GET)
    public String listSessions(Model model){

        model.addAttribute("title","List Sessions");

        model.addAttribute("classSessionList",  sessionService.findAll());

        return "index";
    }

    @GetMapping("/form")
    public String formSession(Model model){

        ClassSession classSession = new ClassSession();

        model.addAttribute("title","Create New Session Class");

        model.addAttribute("classSession", classSession);

        return "form-session";
    }

    @RequestMapping(value = "/form-session",method = RequestMethod.POST)
    public String saveClassSession(@ModelAttribute("classSession")  ClassSession classSession,
                                   Model model){

        sessionService.save(classSession);

        return "redirect:/index";
    }


}
