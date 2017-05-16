package by.bstu.fit.zholnerovich.course.server.endpoint;

import by.bstu.fit.zholnerovich.course.server.soap.GetRegistrationRequest;
import by.bstu.fit.zholnerovich.course.server.soap.GetRegistrationResponse;
import by.bstu.fit.zholnerovich.course.server.utility.RegistrationUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class RegistrationEndpoint {

    private static final String NAMESPACE_URI = "http://bstu.by/fit/zholnerovich/course/server/soap";

    @Autowired
    private RegistrationUtility registrationUtility;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRegistrationRequest")
    @ResponsePayload
    public GetRegistrationResponse getCountry(@RequestPayload GetRegistrationRequest request) {
        GetRegistrationResponse response = new GetRegistrationResponse();
        response.setAnswer(registrationUtility.registrateUser(request.getRegistreringUser()));
        return response;
    }
}