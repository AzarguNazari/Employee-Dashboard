package com.dashboard.hateousTest;//package com.example.dashboard.employeedashboard.hateousTest;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
//@WebAppConfiguration
//@TransactionConfiguration
//@Transactional
//@Ignore
//public class EmployeeHateousTest {
//    @Autowired
//    private WebApplicationContext wac;
//
//    private RestTemplate restTemplate;
//    private int userId = 5;
//    private String jsonDateFormatPattern = "yyyy-MM-dd HH:mm:ss";
//    private MockRestServiceServer mockServer;
//    private MockMvc mockMvc;
//    private MediaType applicationJsonMediaType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
//    private MediaType vndErrorMediaType = MediaType.parseMediaType("application/vnd.error");
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
//        this.mockMvc.perform( get("/users/" + userId + "/customers"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(applicationJsonMediaType))
//                .andExpect(jsonPath("$._embedded.customerList", hasSize(5))) // how many customers are seeded in the schema.sql file? 5.
//                .andExpect(jsonPath("$._embedded.customerList[0].firstName", is("Rossen")));
//    }
//
//    @Test
//    public void testDeletingAUser() throws Exception {
//
//        mockMvc.perform(delete("/users/{userId}", userId))
//                .andExpect(status().isNotFound());
//
//        mockMvc.perform(get("/users/{userId}", userId))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void testCreateCustomer() throws Exception {
//
//        long now = System.currentTimeMillis();
//        String f = "Joe", l = "Doe";
//
//        String jsonOfJoeDoe = "{ \"signupDate\":" + now + ",\"firstName\":\"" + f +
//                "\",\"lastName\":\"" + l + "\"}";
//
//        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/customers", userId)
//                .accept(applicationJsonMediaType)
//                .content(jsonOfJoeDoe)
//                .contentType(this.applicationJsonMediaType))
//                .andExpect(status().isCreated())
//                //  .andExpect(content().contentType(this.applicationJsonMediaType))
//                .andReturn();
//
//        mockServer.verify();
//
//        String locationUri = mvcResult.getResponse().getHeader("Location");
//        Assert.assertTrue(locationUri.contains("/users/" + userId + "/customers/"));
//    }
//
//    @Test
//    public void testLoadingACustomerThatDoesNotExist() throws Exception {
//        this.mockMvc.perform(get("/users/" + 5 + "/customers/" + 24022)
//                .accept(this.applicationJsonMediaType))
//                .andExpect(status().isNotFound())
//                .andExpect(content().contentType(this.vndErrorMediaType));
//
//    }
//
//    @Test
//    public void testLoadingAUserThatDoesNotExist() throws Exception {
//        this.mockMvc.perform(get("/users/" + 400)
//                .accept(this.applicationJsonMediaType))
//                .andExpect(status().isNotFound())
//                .andExpect(content().contentType(this.vndErrorMediaType));
//
//    }
//
//
//    @Test
//    public void testLoadingAUser() throws Exception {
//
//        DateFormat dateFormat = new SimpleDateFormat(jsonDateFormatPattern);
//        int userId = 5;
//        Date date = dateFormat.parse("2013-06-02 15:33:51");
//        this.mockMvc.perform(get("/users/" + userId)
//                .accept(this.applicationJsonMediaType))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(applicationJsonMediaType))
//                .andExpect(jsonPath("$.id", is(userId)))
//                .andExpect(jsonPath("$.firstName", is("Josh")))
//                .andExpect(jsonPath("$.password", isEmptyOrNullString()))
//                .andExpect(jsonPath("$.signupDate", is(date.getTime())))
//                .andExpect(jsonPath("$.lastName", is("Long")))
//                .andExpect(jsonPath("$._links.photo.href", containsString("/users/" + userId + "/photo")))
//                .andExpect(jsonPath("$._links.customers.href", containsString("/users/" + userId + "/customers")))
//                .andExpect(jsonPath("$._links.self.href", containsString("/users/" + userId)));
//
//    }
//}
