package com.degaltseva.task4;

import com.degaltseva.MyRunnable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task4 implements MyRunnable {

    @Override
    public void run() {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = createHttpRequest();
            HttpResponse<String> response = sendRequest(client, request);
            String ip = parseIpFromResponse(response);
            printIp(ip);
        } catch (IOException | InterruptedException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    private HttpRequest createHttpRequest() {
        return HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/ip"))
                .GET()
                .build();
    }

    private HttpResponse<String> sendRequest(HttpClient client, HttpRequest request)
            throws IOException, InterruptedException {
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private String parseIpFromResponse(HttpResponse<String> response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.body());
        return jsonNode.get("origin").asText();
    }

    private void printIp(String ip) {
        System.out.println("IP-адрес: " + ip);
    }
}
