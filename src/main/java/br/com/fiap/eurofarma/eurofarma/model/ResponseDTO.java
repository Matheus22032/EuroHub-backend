package br.com.fiap.eurofarma.eurofarma.model;

import java.util.List;

public class ResponseDTO {
    List<EmployeeResponse> employees;

    public ResponseDTO() {
    }

    public ResponseDTO(List<EmployeeResponse> employees) {
        this.employees = employees;
    }

    public List<EmployeeResponse> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeResponse> employees) {
        this.employees = employees;
    }
}
