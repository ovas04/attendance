package pe.edu.com.attendance.attendance.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.com.attendance.attendance.domain.Student;

public interface IStudentDao extends CrudRepository<Student,Long> {
}
