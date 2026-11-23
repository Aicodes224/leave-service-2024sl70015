// BITS ID: 2024sl70015
package com.bits.hr;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class LeaveServiceApplication {

    public static void main(String[] args) throws IOException {

        String environment = System.getenv().getOrDefault("APP_ENV", "development");

        HttpServer server = HttpServer.create(
            new InetSocketAddress("0.0.0.0", 8080), 0
        );

        server.createContext("/health", exchange -> {
            String response = "{\"status\":\"UP\",\"environment\":\""
                    + environment + "\"}";

            exchange.getResponseHeaders().set(
                "Content-Type", "application/json"
            );

            byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);

            exchange.sendResponseHeaders(200, responseBytes.length);

            try (var output = exchange.getResponseBody()) {
                output.write(responseBytes);
            }
        });

        server.start();

        System.out.println("Leave Service started on port 8080");
        System.out.println("Environment: " + environment);
    }
}
