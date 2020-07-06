//package com.example.dashboard.employeedashboard;
//
//
//import org.junit.jupiter.api.Test;
//
//public class EmployeeProfileTest {
//
//    @Test
//    public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived() throws ClientProtocolException, IOException {
//
//        String jsonMimeType = "application/json";
//        HttpUriRequest request = new HttpGet( "https://api.github.com/users/eugenp" );
//
//        // When
//        HttpResponse response = HttpClientBuilder.create().build().execute( request );
//
//        // Then
//        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
//        assertEquals( jsonMimeType, mimeType );
//    }
//
//}
