package pe.edu.com.attendance.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.com.attendance.attendance.dao.IClassSessionDao;
import pe.edu.com.attendance.attendance.domain.ClassSession;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService{

    @Autowired
    private IClassSessionDao classSessionDao;

    @Override
    public List<ClassSession> findAll() {

        return (List<ClassSession>) classSessionDao.findAll();

    }

    @Override
    public ClassSession findById(Long id) {

        return classSessionDao.findById(id).orElse(null);

    }

    @Override
    public ClassSession save(ClassSession classSession) {
        return classSessionDao.save(classSession);
    }

    @Override
    public void delete(Long id) {
        classSessionDao.deleteById(id);
    }
}
