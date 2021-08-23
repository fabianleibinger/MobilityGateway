package com.mobilitygateway.routingservice.models;

import com.google.maps.model.LatLng;
import com.mobilitygateway.preferenceservice.models.PreferenceProfile;
import com.mobilitygateway.preferenceservice.models.UserProfile;

public class RoutingRequest {
    private LatLng origin;
    private LatLng destination;
    private String routingService;
    private PreferenceProfile preferenceProfile;
    private UserProfile userProfile;

    public LatLng getOrigin() {
        return origin;
    }

    public void setOrigin(LatLng origin) {
        this.origin = origin;
    }

    public LatLng getDestination() {
        return destination;
    }

    public void setDestination(LatLng destination) {
        this.destination = destination;
    }

    public String getRoutingService() {
        return routingService;
    }

    public void setRoutingService(String routingService) {
        this.routingService = routingService;
    }

    public PreferenceProfile getPreferenceProfile() {
        if (this.preferenceProfile == null) {
            this.preferenceProfile = new PreferenceProfile();
        }
        return preferenceProfile;
    }

    public void setPreferenceProfile(PreferenceProfile preferenceProfile) {
        this.preferenceProfile = preferenceProfile;
    }

    public UserProfile getUserProfile() {
        if (this.userProfile == null) {
            this.userProfile = new UserProfile();
        }
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}