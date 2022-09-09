package pe.edu.com.attendance.attendance.service;

import pe.edu.com.attendance.attendance.domain.ClassSession;

import java.util.List;

public interface ISessionService {

    List<ClassSession> findAll();

    ClassSession findById(Long id);

    ClassSession save(ClassSession classSession);

    ClassSession delete(Long id);

}
