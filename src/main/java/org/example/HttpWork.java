package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpWork {
    public String getJsonString(String urlAddress) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(urlAddress)).setHeader("user-agent", "text")
            .build();

        HttpResponse<Path> response = client
            .send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("./src/main/java/org/example/text.json")));

        String fileContent = Files.readString(Paths.get("./src/main/java/org/example/text.json"));
        return fileContent;
    }
}
