package pe.edu.com.attendance.attendance.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ClassSession {

    private String name;

    private String observation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateSession;

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
}
