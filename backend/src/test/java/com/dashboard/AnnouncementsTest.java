package com.dashboard;


import com.dashboard.controller.EmployeeController;
import com.dashboard.model.Employee;
import com.dashboard.model.Title;
import com.dashboard.repository.EmployeeRepository;
import com.dashboard.security.SecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * This class demonstrates how to test a controller using Spring Boot Test
 * (what makes it much closer to a Integration Test)
 *
 * @author moises.macero
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AnnouncementsTest {

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void canRetrieveByIdWhenExists() {
        // given
        given(employeeRepository.findById(1))
                .willReturn(Optional.of(new Employee("ali", "mahmood", "karimi", "pass123", 4000, Title.DEVELOPER)));

        // when
        ResponseEntity<Employee> employeeResponse = restTemplate.getForEntity("/api/v1/employees/1", Employee.class);

        // then
        assertThat(employeeResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(employeeResponse.getBody().equals(Optional.of(new Employee("ali", "mahmood", "karimi", "pass123", 4000, Title.DEVELOPER))));
    }

//    @Test
//    public void canRetrieveByIdWhenDoesNotExist() {
//        // given
//        given(employeeRepository.getSuperHero(2))
//                .willThrow(new NonExistingHeroException());
//
//        // when
//        ResponseEntity<SuperHero> superHeroResponse = restTemplate.getForEntity("/superheroes/2", SuperHero.class);
//
//        // then
//        assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//        assertThat(superHeroResponse.getBody()).isNull();
//    }
//
//    @Test
//    public void canRetrieveByNameWhenExists() {
//        // given
//        given(employeeRepository.getSuperHero("RobotMan"))
//                .willReturn(Optional.of(new SuperHero("Rob", "Mannon", "RobotMan")));
//
//        // when
//        ResponseEntity<SuperHero> superHeroResponse = restTemplate
//                .getForEntity("/superheroes/?name=RobotMan", SuperHero.class);
//
//        // then
//        assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(superHeroResponse.getBody().equals(new SuperHero("Rob", "Mannon", "RobotMan")));
//    }
//
//    @Test
//    public void canRetrieveByNameWhenDoesNotExist() {
//        // given
//        given(employeeRepository.getSuperHero("RobotMan"))
//                .willReturn(Optional.empty());
//
//        // when
//        ResponseEntity<SuperHero> superHeroResponse = restTemplate
//                .getForEntity("/superheroes/?name=RobotMan", SuperHero.class);
//
//        // then
//        assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(superHeroResponse.getBody()).isNull();
//    }
//
//    @Test
//    public void canCreateANewSuperHero() {
//        // when
//        ResponseEntity<SuperHero> superHeroResponse = restTemplate.postForEntity("/superheroes/",
//                new SuperHero("Rob", "Mannon", "RobotMan"), SuperHero.class);
//
//        // then
//        assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//    }
//
//    @Test
//    public void headerIsPresent() throws Exception {
//        // when
//        ResponseEntity<SuperHero> superHeroResponse = restTemplate.getForEntity("/superheroes/2", SuperHero.class);
//
//        // then
//        assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(superHeroResponse.getHeaders().get("X-SUPERHERO-APP")).containsOnly("super-header");
//    }

}
