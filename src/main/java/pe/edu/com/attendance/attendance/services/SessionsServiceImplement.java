package pe.edu.com.attendance.attendance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.com.attendance.attendance.dao.IClassSessionDao;
import pe.edu.com.attendance.attendance.domain.ClassSession;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionsServiceImplement implements  ISessionsService{

    @Autowired
    private IClassSessionDao sessionDao;

    @Override
    public List<ClassSession> findAll() {

//        ClassSession classSession = new ClassSession("Session 1","");
//
//        List<ClassSession> classSessionList = new ArrayList<>();
//
//        classSessionList.add(classSession);
//
//        classSessionList.add(new ClassSession("Session 2","El profesor boto a un alumno"));

        return (List<ClassSession>) sessionDao.findAll();

    }

    @Override
    public ClassSession findById(Long id) {

        return sessionDao.findById(id).orElse(null);
    }

    @Override
    public ClassSession save(ClassSession classSession) {

        return sessionDao.save(classSession);

    }

    @Override
    public ClassSession delete(Long id) {

        ClassSession classSession =  this.findById(id);

        sessionDao.delete(classSession);

        return classSession;

    }
}
