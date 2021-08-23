package com.mobilitygateway.routinggateway.controllers;

import com.mobilitygateway.exceptions.BadGatewayException;
import com.mobilitygateway.routinggateway.HttpRoutingGateway;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller for a travel information application that handles all requests related to routing.
 */
@RestController
@RequestMapping("routing")
public class RoutingController {
    //Path of the related controller at the upstream routing gateway.
    private static final String PATH_SEGMENT = "routingServices/names";

    /**
     * Returns the names of the available routing services or throws BadGatewayException.
     *
     * @return nameList
     */
    @GetMapping(path = "services")
    @ResponseStatus(HttpStatus.OK)
    public static String getRoutingServices() {
        HttpRoutingGateway httpService = new HttpRoutingGateway();
        Optional<String> responseBody = httpService.getRequest(PATH_SEGMENT);
        if (responseBody.isPresent()) {
            System.out.println("Received routing service names successfully.");
            return responseBody.get();
        } else {
            throw new BadGatewayException("Failed to receive routing service names.");
        }
    }
}
