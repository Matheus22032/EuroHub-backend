package br.com.fiap.eurofarma.eurofarma.model;


import jakarta.persistence.*;

@Entity
public class CourseStatus {
    @EmbeddedId
    private CourseStatusKey id;

    private boolean status;

    @Column(columnDefinition = "TEXT")
    private String signature;

    @ManyToOne
    @MapsId("employee_id")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    private Course course;

    public CourseStatus() {
    }

    public CourseStatus(CourseStatusKey id, boolean status, String signature, Employee employee, Course course) {
        this.id = id;
        this.status = status;
        this.signature = signature;
        this.employee = employee;
        this.course = course;
    }
    public CourseStatusKey getId() {
        return id;
    }

    public void setId(CourseStatusKey id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "CourseStatus{" +
                "id=" + id +
                ", status=" + status +
                ", employee=" + employee +
                ", course=" + course +
                '}';
    }
}
