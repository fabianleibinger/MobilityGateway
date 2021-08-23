package com.routing.gateway.routingservice.controllers;

import com.routing.gateway.routingservice.models.NameList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for a travel information application that handles all requests related to routing.
 */
@RestController
@RequestMapping("routingServices")
public class RoutingServicesController {
    /**
     * Returns the names of the available routing services or throws BadGatewayException.
     *
     * @return nameList
     */
    @GetMapping(path = "names")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static NameList getRoutingServices() {
        //TODO call correct controller moved to different service
        //return RoutingServiceController.getRoutingServices();
        return null;
    }
}
