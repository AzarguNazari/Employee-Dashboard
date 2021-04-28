package com.dashboard.service;

import com.dashboard.exception.BadRequestException;
import com.dashboard.exception.EmployeeNotFoundException;
import com.dashboard.exception.TaskNotFoundException;
import com.dashboard.model.Employee;
import com.dashboard.model.Task;
import com.dashboard.repository.EmployeeRepository;
import com.dashboard.repository.TaskRepository;
import com.dashboard.interfaces.serviceInterfaces.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public void deleteAllEmployees(){
        employeeRepository.deleteAll();
    }

    @Override
    public void addAllEmployees(List<Employee> users){
        employeeRepository.saveAll(users);
    }

    @Override
    public void addNewEmployee(Employee employee){
        if(employee.getId() != null){
            final Optional<Employee> byId = employeeRepository.findById(employee.getId());
            if(byId.isPresent()) throw new BadRequestException();
        }
        else{
            employeeRepository.save(employee);
        }
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }


    @Override
    public Optional<Employee> getByUsername(String username){
        return employeeRepository.findByUsername(username);
    }

    @Override
    public void deleteById(Integer employeeID){
        final Optional<Employee> employee = employeeRepository.findById(employeeID);
        if(employee.isEmpty()) throw new EmployeeNotFoundException();
        employeeRepository.deleteById(employeeID);
    }

    @Override
    public void update(Integer employeeId, Employee employee) {
        final Optional<Employee> emp = employeeRepository.findById(employeeId);
        if(emp.isEmpty()) throw new EmployeeNotFoundException();
        employee.setId(employeeId);
        employeeRepository.deleteById(employeeId);
        employeeRepository.save(employee);
    }

    @Override
    public void assignTask(Integer employeeId, Integer taskID) {

        final Optional<Task> task = taskRepository.findById(taskID);

        if(task.isEmpty()) throw new TaskNotFoundException();

        final Optional<Employee> employee = employeeRepository.findById(employeeId);

        if(employee.isEmpty()) throw new EmployeeNotFoundException();

        employee.get().getTasks().add(task.get());
    }

    @Override
    public void unassignTask(Integer employeeId, Integer taskID) {

        final Optional<Task> task = taskRepository.findById(taskID);

        if(task.isEmpty()) throw new TaskNotFoundException();

        final Optional<Employee> employee = employeeRepository.findById(employeeId);

        if(employee.isEmpty()) throw new EmployeeNotFoundException();

        employee.get().getTasks().remove(task.get());
    }

    @Override
    public boolean exist(Integer employeeId) {
        return employeeRepository.findById(employeeId).isPresent();
    }

    @Override
    public long count() {
        return employeeRepository.count();
    }

}
