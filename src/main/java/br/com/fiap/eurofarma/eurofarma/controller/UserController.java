package br.com.fiap.eurofarma.eurofarma.controller;

import br.com.fiap.eurofarma.eurofarma.model.Employee;
import br.com.fiap.eurofarma.eurofarma.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private EmployeeRepository repository;

    @PostMapping()
    public ResponseEntity<Employee> user(@RequestBody Employee user){
        repository.save(user);
        return ResponseEntity.ok(user);

    }

    @GetMapping()
    public ResponseEntity<Iterable<Employee>> list(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id){
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id){
        var employee = repository.findById(id);
        if(employee.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        repository.delete(employee.get());
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee user){
        var employee = repository.findById(id);
        if(employee.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var userUpdate = employee.get();
        userUpdate.setName(user.getName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setActive(user.isActive());
        userUpdate.setAge(user.getAge());
        userUpdate.setCourse(user.getCourse());
        userUpdate.setOnboarding(user.isOnboarding());
        userUpdate.setSatisfaction(user.getSatisfaction());
        userUpdate.setEntryDate(user.getEntryDate());
        userUpdate.setExitDate(user.getExitDate());
        repository.save(userUpdate);
        return ResponseEntity.ok(userUpdate);
    }
}
