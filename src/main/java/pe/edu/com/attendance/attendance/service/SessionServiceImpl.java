package pe.edu.com.attendance.attendance.service;

import org.springframework.stereotype.Service;
import pe.edu.com.attendance.attendance.domain.ClassSession;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService{


    @Override
    public List<ClassSession> findAll() {

        ClassSession classSession = new ClassSession("Session X","");

        List<ClassSession> classSessionList = new ArrayList<>();

        classSessionList.add(classSession);

        classSessionList.add(new ClassSession("Session Y","El profesor boto a un alumno"));

        return classSessionList;
    }

    @Override
    public ClassSession findById(Long id) {
        return null;
    }

    @Override
    public ClassSession save(ClassSession classSession) {
        return null;
    }

    @Override
    public ClassSession delete(Long id) {
        return null;
    }
}
