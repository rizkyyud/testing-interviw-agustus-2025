package com.example.demo_tes_interview.service.implement;

import com.example.demo_tes_interview.model.ApiResult;
import com.example.demo_tes_interview.model.PageRespown;
import com.example.demo_tes_interview.service.GetDataService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GetDataImplement implements GetDataService {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(3))
            .build();

    private final ObjectMapper objectMapper;

    @Override
    public PageRespown<ApiResult> find(int page, int size) {
        int p = Math.max(page, 1);
        int s = Math.max(Math.min(size, 100), 1);

        String url = String.format(
                "https://jsonplaceholder.typicode.com/posts?_page=%d&_limit=%d", p, s
        );

        try {
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();

            HttpResponse<String> resp = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            int code = resp.statusCode();
            if (code < 200 || code >= 300) {
                throw new IllegalStateException("Error Hit API dengan respown code : " + code);
            }

            List<ApiResult> data = objectMapper.readValue(
                    resp.body(),
                    new TypeReference<List<ApiResult>>() {}
            );

            return new PageRespown<>(data, p, s);

        } catch (Exception e) {
            throw new RuntimeException("Gagal menjalankan proses ambil Data: " + e.getMessage(), e);
        }
    }
}
