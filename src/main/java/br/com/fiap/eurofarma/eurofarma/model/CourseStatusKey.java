package br.com.fiap.eurofarma.eurofarma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseStatusKey implements Serializable {

    @Column(name = "employee_id")
    private Long employee_id;
    @Column(name = "course_id")
    private Long course_id;

    public CourseStatusKey(Long employee_id, Long course_id) {
        this.employee_id = employee_id;
        this.course_id = course_id;
    }

    public CourseStatusKey() {
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseStatusKey that = (CourseStatusKey) o;
        return Objects.equals(getEmployee_id(), that.getEmployee_id()) && Objects.equals(getCourse_id(), that.getCourse_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployee_id(), getCourse_id());
    }

    @Override
    public String toString() {
        return "CourseStatusKey{" +
                "employee_id=" + employee_id +
                ", course_id=" + course_id +
                '}';
    }
}
