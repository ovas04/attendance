package pe.edu.com.attendance.attendance.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.com.attendance.attendance.domain.ClassSession;

public interface IClassSessionDao extends CrudRepository<ClassSession,Long> {

}
