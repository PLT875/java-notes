package com.plt875.client;

import java.net.http.HttpClient;

public final class DemoApiClientUtil {

    public static HttpClient createHttpClient() {
        return HttpClient.newHttpClient();
    }

}
