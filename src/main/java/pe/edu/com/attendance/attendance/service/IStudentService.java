package pe.edu.com.attendance.attendance.service;


import pe.edu.com.attendance.attendance.domain.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Long id);

    Student save(Student classSession);

    Student delete(Long id);

}
