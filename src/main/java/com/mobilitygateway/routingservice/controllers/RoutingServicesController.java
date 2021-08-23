package com.mobilitygateway.routingservice.controllers;

import com.mobilitygateway.routingservice.models.NameList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        NameList nameList = new NameList();
        List<String> names = new ArrayList<>();
        names.add("Openrouteservice");
        names.add("Valhalla");
        names.add("OpenTripPlanner");
        nameList.setNames(names);
        return nameList;
    }
}
