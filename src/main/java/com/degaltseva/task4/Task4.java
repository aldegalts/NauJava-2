package com.degaltseva.task4;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Task4 {

    public static void startTask4() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/ip"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(response.body());

            String ip = jsonNode.get("origin").asText();

            System.out.println("IP-адрес: " + ip);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
