package com.mobilitygateway.routingservice.models;

import java.util.ArrayList;
import java.util.List;

public class RoutingResultNew {
    private String encodedPolyline;
    private Double durationInMinutes;
    private Double distanceInMeters;
    private String departureTime;
    private String arrivalTime;
    private Integer numberOfTransfers;
    private List<RoutingResultSegmentNew> segments;

    public String getEncodedPolyline() {
        return encodedPolyline;
    }

    public void setEncodedPolyline(String encodedPolyline) {
        this.encodedPolyline = encodedPolyline;
    }

    public Double getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Double durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Double getDistanceInMeters() {
        return distanceInMeters;
    }

    public void setDistanceInMeters(Double distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getNumberOfTransfers() {
        return numberOfTransfers;
    }

    public void setNumberOfTransfers(Integer numberOfTransfers) {
        this.numberOfTransfers = numberOfTransfers;
    }

    public List<RoutingResultSegmentNew> getSegments() {
        if (this.segments == null) {
            this.segments = new ArrayList<>();
        }
        return segments;
    }

    public void setSegments(List<RoutingResultSegmentNew> segments) {
        this.segments = segments;
    }
}
