package pe.edu.com.attendance.attendance.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.com.attendance.attendance.domain.ClassSession;
import pe.edu.com.attendance.attendance.domain.Student;
import pe.edu.com.attendance.attendance.domain.StudentsSession;
import pe.edu.com.attendance.attendance.services.ISessionsService;
import pe.edu.com.attendance.attendance.services.IStudentsService;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("classSession")
public class AttendanceController {

    @Autowired
    private ISessionsService sessionsService;

    @Autowired
    private IStudentsService studentsService;


    @RequestMapping(value = {"/index","/home"}, method = RequestMethod.GET)
    public String listSessions(Model model){

        List<ClassSession> classSessionList = sessionsService.findAll();

        model.addAttribute("title","List Sessions");

        model.addAttribute("classSessionList", classSessionList);

        return "index";
    }

    @GetMapping("/form")
    public String formSession(Model model){

        ClassSession classSession = new ClassSession();

        List<StudentsSession> studentsSessions = new ArrayList<>();

        for (Student student : studentsService.findAll()) {

            studentsSessions.add(new StudentsSession(student));

        }

        classSession.setStudentsSessions(studentsSessions);

        model.addAttribute("title","Create New Session Class");

        model.addAttribute("classSession", classSession);

        return "form-sessions";
    }

    @RequestMapping(value = "/formSession",method = RequestMethod.POST)
    public String saveClassSession(@ModelAttribute("classSession")  ClassSession classSession,
                                   Model model, SessionStatus status){

        sessionsService.save(classSession);

        status.setComplete();

        return "redirect:/index";
    }


}
