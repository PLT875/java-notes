package com.plt875.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class DemoApiClient {

    private final static Logger LOGGER = Logger.getLogger(Logger.class.getName());

    private final static String CUSTOMER_RESOURCE_ENDPOINT = "/api/v1/customer/%s";

    private final static String CUSTOMER_ENDPOINT = "/api/v1/customer";

    private String baseUrl;

    private HttpClient httpClient;

    public DemoApiClient(String baseUrl, HttpClient httpClient) {
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
    }

    public HttpResponse<String> getCustomerById(String id) throws IOException, InterruptedException {
        String uri = baseUrl.concat(String.format(CUSTOMER_RESOURCE_ENDPOINT, id));

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(uri))
                .GET()
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public CustomerResponse getCustomer(String id) throws ExecutionException, InterruptedException {
        String uri = baseUrl.concat(String.format(CUSTOMER_RESOURCE_ENDPOINT, id));

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(uri))
                .GET()
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::toCustomerResponse).get();
    }

    public CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) throws JsonProcessingException,
            ExecutionException, InterruptedException {

        String uri = baseUrl.concat(CUSTOMER_ENDPOINT);

        String requestBody = toRequestBody(createCustomerRequest);
        System.out.println(requestBody);

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::toCustomerResponse).get();
    }

    public CustomerResponse toCustomerResponse(String responseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(responseBody, CustomerResponse.class);
        } catch (JsonProcessingException e) {
            throw new CompletionException(e);
        }
    }

    public String toRequestBody(CreateCustomerRequest createCustomerRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(createCustomerRequest);
    }

}