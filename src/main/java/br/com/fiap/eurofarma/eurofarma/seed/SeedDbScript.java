package br.com.fiap.eurofarma.eurofarma.seed;

import br.com.fiap.eurofarma.eurofarma.model.Employee;
import br.com.fiap.eurofarma.eurofarma.repository.EmployeeRepository;
import com.opencsv.CSVReader;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeedDbScript {

    private final EmployeeRepository employeeRepository;

    public SeedDbScript(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void seedDb() {
        System.out.println("SeedDbScript");
        try {
            InputStreamReader inputStream = new InputStreamReader(getClass().getResourceAsStream("/usuarios.csv"));
            System.out.println(inputStream);
            CSVReader csvReader = new CSVReader(inputStream);
            String[] nextRecord;
            List<Employee> employees = new ArrayList<>();
            csvReader.readNext();

            while ((nextRecord = csvReader.readNext()) != null) {
                Employee employee = new Employee();

                employee.setName(nextRecord[0]);
                employee.setDepartment(nextRecord[1]);
                employee.setEmployee_id(Long.parseLong(nextRecord[2]));
                employee.setBirthDate(nextRecord[3]);
                employees.add(employee);
            }
            csvReader.close();
            employeeRepository.saveAll(employees);
        }catch (Exception e){

            System.out.println("Employee already exists in the database.");
            System.out.println(e.getMessage());
        }
    }

}
