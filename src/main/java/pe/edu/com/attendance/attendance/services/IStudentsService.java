package pe.edu.com.attendance.attendance.services;

import pe.edu.com.attendance.attendance.domain.ClassSession;
import pe.edu.com.attendance.attendance.domain.Student;

import java.util.List;

public interface IStudentsService {

    List<Student> findAll();

    Student findById(Long id);

    Student save(Student student);

    Student delete(Long id);

}
