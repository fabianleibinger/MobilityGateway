package com.mobilitygateway.routinggateway;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

/**
 * Http endpoint of the routing gateway.
 */
public class HttpRoutingGateway {
    private static final String BASE_URL = "http://127.0.0.1:8081/";
    private final Integer OK_STATUS_CODE = 200;
    private final Integer OK_STATUS_CODE_POST = 201;
    private final Duration SECONDS_UNTIL_TIMEOUT = Duration.ofSeconds(35);
    private HttpClient httpClient;

    public HttpRoutingGateway() {
        this.httpClient = HttpClient.newBuilder().build();
    }

    /**
     * Sends a GET request to the routing gateway.
     *
     * @param path
     * @return Optional String response body
     */
    public Optional<String> getRequest(String path) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.getCompleteURL(path)))
                .timeout(SECONDS_UNTIL_TIMEOUT)
                .GET();
        HttpRequest request = requestBuilder.build();

        return this.sendRequest(request);
    }

    /**
     * Sends a POST request with json body to the routing gateway.
     *
     * @param path
     * @param body json
     * @return Optional String response body
     */
    public Optional<String> postRequest(String path, String body) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.getCompleteURL(path)))
                .timeout(SECONDS_UNTIL_TIMEOUT)
                .POST(HttpRequest.BodyPublishers.ofString(body));
        requestBuilder.header("Content-Type", "application/json");
        HttpRequest request = requestBuilder.build();

        return this.sendRequest(request);
    }

    /**
     * Returns a response to a http request.
     *
     * @param request
     * @return Optional String response body
     */
    private Optional<String> sendRequest(HttpRequest request) {
        try {
            HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status code: " + response.statusCode());
            if (response.statusCode() == OK_STATUS_CODE || response.statusCode() == OK_STATUS_CODE_POST) {
                return Optional.of(response.body());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to reach routing gateway.");
        }
        return Optional.empty();
    }

    /**
     * Returns a URL including BASE_URL and a path.
     *
     * @param path
     * @return String URL
     */
    public String getCompleteURL(String path) {
        return BASE_URL + path;
    }

    public String getBaseURL() {
        return BASE_URL;
    }

    public Integer getOkStatusCode() {
        return OK_STATUS_CODE;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
}
