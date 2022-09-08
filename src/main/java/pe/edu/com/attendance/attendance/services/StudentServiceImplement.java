package pe.edu.com.attendance.attendance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.com.attendance.attendance.dao.IStudentDao;
import pe.edu.com.attendance.attendance.domain.ClassSession;
import pe.edu.com.attendance.attendance.domain.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImplement implements IStudentsService{

    @Autowired
    private IStudentDao studentDao;

    @Override
    public List<Student> findAll() {

//        List<Student> studentsList = new ArrayList<>();
//
//        studentsList.add(new Student("Giro","Pinto"));
//
//        studentsList.add(new Student("Oscar","Lobaton"));

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
