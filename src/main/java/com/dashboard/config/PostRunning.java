package com.dashboard.config;

import com.dashboard.model.employee.Employee;
import com.dashboard.model.employee.Title;
import com.dashboard.model.task.Priority;
import com.dashboard.model.task.Task;
import com.dashboard.repository.RoleRepository;
import com.dashboard.repository.TaskRepository;
import com.dashboard.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty("insertDataAuto")
public class PostRunning implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void run(String... args) throws Exception {

        // ROLES
//        Role admin = new Role("ADMIN");
//        Role user = new Role("USER");
//        roleRepository.save(admin);
//        roleRepository.save(user);

        // TASKS
        Task task1 = new Task("Task1", "Descriptoin1", Priority.LOW);
        Task task2 = new Task("Task2", "Descriptoin2", Priority.NORMAL);
        Task task3 = new Task("Task3", "Descriptoin3", Priority.HIGH);
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);


        // EMPLOYEES
        Employee employee1 = new Employee("username1", "firstname1", "lastname1", "password1", 1000, Title.DEVELOPER);
        employeeService.addNewEmployee(employee1);
        Employee employee2 = new Employee("username2", "firstname2", "lastname2", "password2", 2000, Title.DEVELOPER);
        employeeService.addNewEmployee(employee2);
        Employee employee3 = new Employee("username3", "firstname3", "lastname3", "password3", 3000, Title.HR);
        employeeService.addNewEmployee(employee3);
        Employee employee4 = new Employee("username4", "firstname4", "lastname4", "password4", 4000, Title.MANAGER);
        employeeService.addNewEmployee(employee4);
        Employee employee5 = new Employee("username5", "firstname5", "lastname5", "password5", 5000, Title.DEVELOPER);
        employeeService.addNewEmployee(employee5);
    }
}
