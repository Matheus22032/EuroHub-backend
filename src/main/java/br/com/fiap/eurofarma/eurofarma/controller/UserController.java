package br.com.fiap.eurofarma.eurofarma.controller;

import br.com.fiap.eurofarma.eurofarma.model.*;
import br.com.fiap.eurofarma.eurofarma.repository.CourseRepository;
import br.com.fiap.eurofarma.eurofarma.repository.CourseStatusRepository;
import br.com.fiap.eurofarma.eurofarma.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {

    private final EmployeeRepository employeeRepository;

    private final CourseRepository courseRepository;

    private final CourseStatusRepository courseStatusRepository;

    public UserController(EmployeeRepository employeeRepository, CourseRepository courseRepository, CourseStatusRepository courseStatusRepository){
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
        this.courseStatusRepository = courseStatusRepository;
    }


    @PostMapping()
    public ResponseEntity<EmployeeResponse> user(@RequestBody EmployeeDTO employeeDTO){
        Long courseId = employeeDTO.course_id();
        Optional<Employee> employee = employeeRepository.findById(employeeDTO.employee_id());


        if(employee.isPresent()){
            employee.get().setSignature(employeeDTO.signature());
            Course course = new Course();
            course.setCourse_id(courseId);
            CourseStatusKey courseStatusKey = new CourseStatusKey();
            courseStatusKey.setCourse_id(courseId);
            courseStatusKey.setEmployee_id(employeeDTO.employee_id());


            CourseStatus courseStatus = new CourseStatus();
            courseStatus.setCourse(course);
            courseStatus.setEmployee(employee.get());
            courseStatus.setId(courseStatusKey);
            courseStatus.setStatus(true);
            courseRepository.save(course);
            courseStatusRepository.save(courseStatus);
            employeeRepository.save(employee.get());
            return ResponseEntity.ok(new EmployeeResponse(employee.get().getEmployee_id(), employee.get().getSignature(), employee.get().getDepartment(), employee.get().getBirthDate(), employee.get().getName(), true));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<ResponseDTO> getUserByCourse( @PathVariable long courseId){
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent()){
            var courseStatus = course.get().getCoursesStatuses();
            List<EmployeeResponse> employeeResponseList = new ArrayList<>();
            courseStatus.forEach(courseStatus1 -> {
                var employee = employeeRepository.findById(courseStatus1.getId().getEmployee_id());
                employee.ifPresent(value -> employeeResponseList.add(new EmployeeResponse(value.getEmployee_id(),value.getSignature() , value.getDepartment(), value.getBirthDate(), value.getName(), courseStatus1.getStatus())));
            });

            return ResponseEntity.ok(new ResponseDTO(employeeResponseList));
        }
        return ResponseEntity.ok().build();

    }
}
