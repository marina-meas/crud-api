package com.example.demo.controller;

import com.example.demo.service.TestCallAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestCallAPIController {
    private final TestCallAPIService testCallAPIService;

    @Autowired
    public TestCallAPIController(TestCallAPIService testCallAPIService) {
        this.testCallAPIService = testCallAPIService;
    }


    @PostMapping("/post-data")
    public Mono<String> postData() {
//        System.out.println("jsonData"+jsonData);
        // Call ExternalApiService to post data to external API
        return testCallAPIService.postDataToExternalApi();
    }
    @PostMapping("/send-sms")
    public Mono<String> sendSMS() {
        // Call ExternalApiService to post data to external API
        return testCallAPIService.sendSMS();
    }
}
