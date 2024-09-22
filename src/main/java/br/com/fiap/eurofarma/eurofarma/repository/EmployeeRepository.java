package br.com.fiap.eurofarma.eurofarma.repository;

import br.com.fiap.eurofarma.eurofarma.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
