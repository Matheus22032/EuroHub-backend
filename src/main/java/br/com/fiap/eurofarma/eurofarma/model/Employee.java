package br.com.fiap.eurofarma.eurofarma.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_gen")
    @SequenceGenerator(name = "employee_seq_gen", sequenceName = "employee_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "active")
    private boolean active;
    @Column(name = "age")
    private int age;
    @Column(name = "course")
    private int course;
    @Column(name = "onboarding")
    private boolean onboarding;
    @Column(name = "satisfaction")
    private int satisfaction;
    @Column(name = "entry_date")
    private LocalDate entryDate;
    @Column(name = "exit_date")
    private LocalDate exitDate;


    public Employee(Long id, String name, String lastName, boolean active, int age, int course, boolean onboarding, int satisfaction, LocalDate entryDate, LocalDate exitDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.active = active;
        this.age = age;
        this.course = course;
        this.onboarding = onboarding;
        this.satisfaction = satisfaction;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
    }

    public Employee() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public boolean isOnboarding() {
        return onboarding;
    }

    public void setOnboarding(boolean onboarding) {
        this.onboarding = onboarding;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }
}
