package pe.edu.com.attendance.attendance.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.com.attendance.attendance.domain.ClassSession;
import pe.edu.com.attendance.attendance.domain.Student;
import pe.edu.com.attendance.attendance.domain.StudentsSessions;
import pe.edu.com.attendance.attendance.service.ISessionService;
import pe.edu.com.attendance.attendance.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("classSession")
public class AttendanceController {

    @Autowired
    private ISessionService sessionService;

    @Autowired
    private IStudentService studentService;


    @RequestMapping(value = {"/","/index","/home"}, method = RequestMethod.GET)
    public String listSessions(Model model){

        model.addAttribute("title","List Sessions");

        model.addAttribute("classSessionList",  sessionService.findAll());

        return "index";
    }

    @GetMapping("/form")
    public String formSession(Model model){

        ClassSession classSession = new ClassSession();

        List<StudentsSessions> studentsSessionsList = new ArrayList<>();

        for ( Student student : studentService.findAll()){

            studentsSessionsList.add(new StudentsSessions(student));

        }

        classSession.setStudentsSessionsList(studentsSessionsList);

        model.addAttribute("title","Create New Session Class");

        model.addAttribute("classSession", classSession);

        return "form-session";
    }

    @RequestMapping(value = "/form-session",method = RequestMethod.POST)
    public String saveClassSession(@ModelAttribute("classSession")  ClassSession classSession,
                                   Model model, SessionStatus status){

        sessionService.save(classSession);

        status.setComplete();

        return "redirect:/index";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detailsClassSession(@PathVariable(value = "id") Long id, Map<String,Object> model){

        model.put("title","Details of Session");

        ClassSession ClassSession = sessionService.findById(id);

        model.put("ClassSession",ClassSession);


        return "details";

    }


}
