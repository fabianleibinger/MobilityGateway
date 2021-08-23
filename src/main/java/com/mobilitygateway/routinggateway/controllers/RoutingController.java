package com.mobilitygateway.routinggateway.controllers;

import com.mobilitygateway.exceptions.BadGatewayException;
import com.mobilitygateway.routinggateway.HttpRoutingGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller for a travel information application that handles all requests related to routing.
 */
@RestController
@RequestMapping("routing")
public class RoutingController {

    /**
     * Returns the names of the available routing services or throws BadGatewayException.
     *
     * @return nameList json
     */
    @GetMapping(path = "services")
    @ResponseStatus(HttpStatus.OK)
    public static String getRoutingServices() {
        HttpRoutingGateway httpService = new HttpRoutingGateway();
        Optional<String> responseBody = httpService.getRequest("routingServices/names");
        if (responseBody.isPresent()) {
            System.out.println("Received routing service names successfully.");
            return responseBody.get();
        } else {
            throw new BadGatewayException("Failed to receive routing service names.");
        }
    }

    /**
     * Returns routes for a routing request or throws BadGatewayException.
     *
     * @param routingRequest json
     * @return routingResponse json
     */
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public static String receiveRoutes(String routingRequest) {
        HttpRoutingGateway httpService = new HttpRoutingGateway();
        Optional<String> responseBody = httpService.postRequest("routing", routingRequest);
        if (responseBody.isPresent()) {
            System.out.println("Received routes successfully");
            return responseBody.get();
        } else {
            throw new BadGatewayException("Failed to receive routes.");
        }
    }
}
