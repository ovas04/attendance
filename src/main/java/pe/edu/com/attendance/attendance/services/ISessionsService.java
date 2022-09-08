package pe.edu.com.attendance.attendance.services;

import pe.edu.com.attendance.attendance.domain.ClassSession;

import java.util.List;

public interface ISessionsService {

    List<ClassSession> findAll();

    ClassSession findById(Long id);

    ClassSession save(ClassSession classSession);

    ClassSession delete(Long id);

}
