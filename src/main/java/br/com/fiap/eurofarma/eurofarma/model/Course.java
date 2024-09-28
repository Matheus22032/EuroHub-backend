package br.com.fiap.eurofarma.eurofarma.model;

import jakarta.persistence.*;


import java.util.Set;

@Entity
public class Course {
    @Id
    private Long course_id;
    @OneToMany(mappedBy = "course")
    private Set<CourseStatus> coursesStatuses;

    public Course() {
    }

    public Course(Long course_id, Set<CourseStatus> coursesStatuses) {
        this.course_id = course_id;
        this.coursesStatuses = coursesStatuses;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Set<CourseStatus> getCoursesStatuses() {
        return coursesStatuses;
    }

    public void setCoursesStatuses(Set<CourseStatus> employee_id) {
        this.coursesStatuses = employee_id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", employee_id=" + coursesStatuses +
                '}';
    }
}
