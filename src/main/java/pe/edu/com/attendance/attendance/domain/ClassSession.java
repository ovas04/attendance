package pe.edu.com.attendance.attendance.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "class_sessions")
public class ClassSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String observation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_session")
    private Date dateSession;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "class_session_id")
    private List<StudentsSessions> studentsSessionsList;

    public ClassSession() {
    }

    public ClassSession(String name, String observation) {
        this.name = name;
        this.observation = observation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getDateSession() {
        return dateSession;
    }

    public void setDateSession(Date dateSession) {
        this.dateSession = dateSession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StudentsSessions> getStudentsSessionsList() {
        return studentsSessionsList;
    }

    public void setStudentsSessionsList(List<StudentsSessions> studentsSessionsList) {
        this.studentsSessionsList = studentsSessionsList;
    }
}
