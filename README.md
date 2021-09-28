# MobilityGateway

This is a project developed by Fabian Leibinger in terms of his bachelor thesis at Karlruhe Institut für Technologie (KIT) in cooperation with Forschungszentrum Informatik (FZI).
A Java Spring Boot project.

The Mobility Gateway serves as the backend gateway of the travel information system, and therefore accesses the Routing Gateway and a preference service via Http.
The Mobility Gateway implements Http controller classes for the travel_information_app in order to provide the functionality of the background services. 

## Http classes

These classes handle the connection to the Routing Gateway and the preference server. 
Methods for sending basic Http requests enable the Mobility Gateway to send requests with a payload to a specific path of the services.

## exceptions

Meaningful exceptions can be implemented by extending RuntimeException class. The exception will be thrown if added to the ApiExceptionHandler and creating an exception message (ApiException).

## Controller classes

These classes implement Http endpoints that can be used by the travel_information_app. The functionality of the background services is provided via controller classes.

## preferenceservice

User class represents a user management component of the travel_information_app. 
User enables all the features of the preference service, that should be used for a user of the app. Changes to the user management component can be made here.
model classes represent data transfer objects of the preference service.
