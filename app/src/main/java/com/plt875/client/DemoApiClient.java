package com.plt875.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class DemoApiClient {

    private final static Logger LOGGER = Logger.getLogger(Logger.class.getName());

    private String baseUrl;

    private HttpClient httpClient;

    public DemoApiClient(String baseUrl, HttpClient httpClient) {
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
    }

    public HttpResponse<String> getCustomerById(String id) throws IOException, InterruptedException {
        String uri = baseUrl.concat(String.format("/api/v1/customer/%s", id));

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(uri))
                .GET()
                .build();

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

}