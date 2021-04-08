package com.plt875.client;

import com.github.tomakehurst.wiremock.WireMockServer;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoApiClientIntegrationTest {

    private static WireMockServer mockServer;

    private DemoApiClient demoApiClient;

    @BeforeAll
    static void setupMockServer() {
        mockServer = new WireMockServer(options().port(8090));
        mockServer.start();
    }

    @AfterAll
    static void tearDown() {
        mockServer.stop();
    }

    @BeforeEach
    void setup() {
        HttpClient httpClient = DemoApiClientUtil.createHttpClient();
        demoApiClient = new DemoApiClient("http://localhost:8090", httpClient);
    }

    @Test
    void shouldGetCustomerById() throws Exception {
        HttpResponse<String> response = demoApiClient.getCustomerById("id0");
        assertEquals(200, response.statusCode());
        assertTrue(response.body().length() > 0);
    }

    @Test
    void shouldGetCustomer() throws Exception {
        CustomerResponse response = demoApiClient.getCustomer("id0");
        assertEquals("674570d2-0e3c-4f4b-a6a3-4bf0baa40e74", response.getId());
        assertEquals("Mr.", response.getTitle());
        assertEquals("Peter", response.getFirstName());
        assertEquals("Tran", response.getLastName());
    }

    @Test
    void shouldCreateCustomer() throws Exception {
        CreateCustomerRequest request = new CreateCustomerRequest("Mr.", "Peter", "Tran");
        CustomerResponse response = demoApiClient.createCustomer(request);
        assertEquals("674570d2-0e3c-4f4b-a6a3-4bf0baa40e74", response.getId());
        assertEquals("Mr.", response.getTitle());
        assertEquals("Peter", response.getFirstName());
        assertEquals("Tran", response.getLastName());
    }

}
