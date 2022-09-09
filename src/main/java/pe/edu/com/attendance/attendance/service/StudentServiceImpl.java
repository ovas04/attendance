package pe.edu.com.attendance.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.com.attendance.attendance.dao.IStudentDao;
import pe.edu.com.attendance.attendance.domain.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentDao studentDao;

    @Override
    public List<Student> findAll() {

        return (List<Student>) studentDao.findAll();

    }

    @Override
    public Student findById(Long id) {

        return studentDao.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {

        return studentDao.save(student);
    }

    @Override
    public Student delete(Long id) {

        Student student = this.findById(id);

        studentDao.delete(student);

        return student;
    }
}
