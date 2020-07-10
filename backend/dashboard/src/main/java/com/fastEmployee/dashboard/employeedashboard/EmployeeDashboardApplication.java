package com.fastEmployee.dashboard.employeedashboard;

import com.fastEmployee.dashboard.employeedashboard.model.employee.Employee;
import com.fastEmployee.dashboard.employeedashboard.model.employee.Role;
import com.fastEmployee.dashboard.employeedashboard.model.employee.Title;
import com.fastEmployee.dashboard.employeedashboard.repository.EmployeeRepository;
import com.fastEmployee.dashboard.employeedashboard.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication(/*exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class}*/)
//@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
//@Import(ServiceConfiguration.class)
public class EmployeeDashboardApplication implements ApplicationRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDashboardApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");
        roleRepository.save(role1);
        roleRepository.save(role2);
        Employee employee1 = new Employee("username1", "firstname1", "lastname1", "password1", 300, Title.DEVELOPER);

        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        roles.add(role2);
        employee1.setRoles(roles);
        employeeRepository.save(employee1);

    }

    // you can run this with SSL/TLS. For example, build the application (`mvn clean install`) in the `oauth` directory, then run:
    //   java -Dspring.profiles.active=production -Dkeystore.file=file:///`pwd`/src/main/resources/keystore.p12 -jar target/oauth-1.0.0.BUILD-SNAPSHOT.jar
//    @Bean
//    @Profile("production")
//    EmbeddedServletContainerCustomizer containerCustomizer(@Value("${keystore.file}") Resource keystoreFile,
//                                                           @Value("${keystore.pass}") String keystorePass) throws Exception {
//
//        String absoluteKeystoreFile = keystoreFile.getFile().getAbsolutePath();
//
//        return (ConfigurableEmbeddedServletContainer container) -> {
//            TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
//            tomcat.addConnectorCustomizers(
//                    (connector) -> {
//                        connector.setPort(8443);
//                        connector.setSecure(true);
//                        connector.setScheme("https");
//
//                        Http11NioProtocol proto = (Http11NioProtocol) connector.getProtocolHandler();
//                        proto.setSSLEnabled(true);
//                        proto.setKeystoreFile(absoluteKeystoreFile);
//                        proto.setKeystorePass(keystorePass);
//                        proto.setKeystoreType("PKCS12");
//                        proto.setKeyAlias("tomcat");
//                    }
//            );
//
//        };
//    }
//
//    @Bean
//    MultipartConfigElement multipartConfigElement() {
//        return new MultipartConfigElement("");
//    }
//
//    @Bean
//    ResourceAssembler<User, org.springframework.hateoas.Resource<User>> userResourceAssembler() {
//        return (u) -> {
//            try {
//                String customersRel = "customers", photoRel = "photo";
//                User user = new User(u);
//                user.setPassword(null);
//                long userId = user.getId();
//                Collection<Link> links = new ArrayList<>();
//                links.add(linkTo(methodOn(UserController.class).loadUser(userId)).withSelfRel());
//                links.add(linkTo(methodOn(UserController.class).loadUserCustomers(userId)).withRel(customersRel));
//                links.add(linkTo(methodOn(UserProfilePhotoController.class).loadUserProfilePhoto(user.getId())).withRel(photoRel));
//                return new org.springframework.hateoas.Resource<>(user, links);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        };
//    }
//
//    @Bean
//    ResourceAssembler<Customer, org.springframework.hateoas.Resource<Customer>> customerResourceResourceAssembler() {
//        return (customer) -> {
//            String usersRel = "user";
//            Class<UserController> controllerClass = UserController.class;
//            Long userId = customer.getUser().getId();
//            customer.setUser(null);
//            org.springframework.hateoas.Resource<Customer> customerResource = new org.springframework.hateoas.Resource<>(customer);
//            customerResource.add(linkTo(methodOn(controllerClass).loadSingleUserCustomer(userId, customer.getId())).withSelfRel());
//            customerResource.add(linkTo(methodOn(controllerClass).loadUser(userId)).withRel(usersRel));
//            return customerResource;
//        };
//    }
//
//    @Configuration
//    static class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
//
//        @Autowired
//        private CrmService crmService;
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(userDetailsService());
//        }
//
//        protected UserDetailsService userDetailsService() {
//            return (username) -> {
//                User u = crmService.findUserByUsername(username);
//                return new org.springframework.security.core.userdetails.User(
//                        u.getUsername(), u.getPassword(), u.isEnabled(),
//                        u.isEnabled(), u.isEnabled(), u.isEnabled(),
//                        AuthorityUtils.createAuthorityList("USER", "write"));
//            };
//        }
//
//    }
//
//
//    @Configuration
//    @EnableResourceServer
//    @EnableAuthorizationServer
//    static class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {
//
//        private final String applicationName = "crm";
//
//        /**
//         * This is required for password grants, which we specify below as one of the  {@literal authorizedGrantTypes()}.
//         */
//        @Autowired
//        private AuthenticationManager authenticationManager;
//
//        @Override
//        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//            endpoints.authenticationManager(authenticationManager);
//        }
//
//        @Override
//        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//            clients.inMemory()
//                    .withClient("android-crm")
//                    .authorizedGrantTypes("password", "authorization_code", "refresh_token")
//                    .authorities("ROLE_USER")
//                    .scopes("write")
//                    .resourceIds(applicationName)
//                    .secret("123456");
//        }
//    }
}
