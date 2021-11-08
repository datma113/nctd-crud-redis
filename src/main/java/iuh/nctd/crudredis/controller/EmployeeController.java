package iuh.nctd.crudredis.controller;

import iuh.nctd.crudredis.entity.Employee;
import iuh.nctd.crudredis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public List<Employee> getAll() {
        return employeeRepository.getAllEmployees();
    }

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee e) {
        employeeRepository.saveEmployee(e);
        return e;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepository.findEmployeeById(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Employee employee) {
         employeeRepository.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeRepository.deleteEmployee(id);
    }


}
