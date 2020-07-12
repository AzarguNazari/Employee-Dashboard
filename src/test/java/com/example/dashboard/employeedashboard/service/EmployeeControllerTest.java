//package com.example.dashboard.employeedashboard.service;
//
//
//import org.apache.commons.io.IOUtils;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.client.MockRestServiceServer;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.context.WebApplicationContext;
//
//import javax.transaction.Transactional;
//import java.nio.charset.Charset;
//import org.springframework.core.io.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
//import static net.bytebuddy.matcher.ElementMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@WebAppConfiguration
//@Transactional
//public class EmployeeControllerTest {
//
//    @Autowired
//    private WebApplicationContext wac;
//
//    private RestTemplate restTemplate;
//    private int userId = 5;
//    private String jsonDateFormatPattern = "yyyy-MM-dd HH:mm:ss";
//    private MockRestServiceServer mockServer;
//    private MockMvc mockMvc;
//    private MediaType applicationJsonMediaType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
//    private MediaType vndErrorMediaType = MediaType.parseMediaType("application/json");
//
//    @Value("classpath:/spring-dog-3.png")
//    private Resource spring3DogPng;
//
//    @Before
//    public void setup() {
//        List<HttpMessageConverter<?>> converters = new ArrayList<>();
//        converters.add(new StringHttpMessageConverter());
//        converters.add(new MappingJackson2HttpMessageConverter());
//
//        this.restTemplate = new RestTemplate();
//        this.restTemplate.setMessageConverters(converters);
//
//        this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }
//
//    @Test
//    public void testLoadingUserCustomers() throws Exception {
////        this.mockMvc.perform(get("/users/" + userId + "/customers"))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andExpect(content().contentType(applicationJsonMediaType))
////                .andExpect(jsonPath("$", hasSize(5))) // how many customers are seeded in the schema.sql file? 5.
////                .andExpect(jsonPath("$[0].firstName", is("Rossen")));
//    }
//
//    @Test
//    public void testPostingAProfilePhoto() throws Exception {
//        byte[] pngBytes = IOUtils.toByteArray(this.spring3DogPng.getInputStream());
//        String uri = "/users/{user}/photo";
//        mockMvc.perform(post(uri, userId).content(pngBytes).contentType(MediaType.MULTIPART_FORM_DATA)).andReturn();
//
//
//
////        mockMvc.perform(get(uri, userId).accept(pngMediaType)).andExpect(content().contentType(pngMediaType)).andReturn();
//    }
//
//}