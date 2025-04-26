package com.vismark.kubernetes.MicroServiceWithConfigMapSecretsAndLivenessProbes.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Map;

@RestController
@RequestMapping("/request-details")
public class RequestDetailsController {

    @GetMapping
    public ResponseEntity<String> handleGet(@RequestHeader HttpHeaders headers, @RequestParam Map<String, String> queryParams) {
        System.out.println("GET Request Headers: " + headers);
        System.out.println("GET Request Query Parameters: " + queryParams);
        return new ResponseEntity<>("GET request received", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> handlePost(@RequestHeader HttpHeaders headers, @RequestBody(required = false) String body) {
        System.out.println("POST Request Headers: " + headers);
        System.out.println("POST Request Body: " + body);
        return new ResponseEntity<>("POST request received", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> handlePut(@RequestHeader HttpHeaders headers, @RequestBody(required = false) String body) {
        System.out.println("PUT Request Headers: " + headers);
        System.out.println("PUT Request Body: " + body);
        return new ResponseEntity<>("PUT request received", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> handleDelete(@RequestHeader HttpHeaders headers, @RequestParam Map<String, String> queryParams) {
        System.out.println("DELETE Request Headers: " + headers);
        System.out.println("DELETE Request Query Parameters: " + queryParams);
        return new ResponseEntity<>("DELETE request received", HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<String> handlePatch(@RequestHeader HttpHeaders headers, @RequestBody(required = false) String body) {
        System.out.println("PATCH Request Headers: " + headers);
        System.out.println("PATCH Request Body: " + body);
        return new ResponseEntity<>("PATCH request received", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<String> handleOptions(@RequestHeader HttpHeaders headers) {
        System.out.println("OPTIONS Request Headers: " + headers);
        return new ResponseEntity<>("OPTIONS request received", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<String> handleHead(@RequestHeader HttpHeaders headers) {
        System.out.println("HEAD Request Headers: " + headers);
        return new ResponseEntity<>("HEAD request received", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.TRACE)
    public ResponseEntity<String> handleTrace(@RequestHeader HttpHeaders headers) {
        System.out.println("TRACE Request Headers: " + headers);
        return new ResponseEntity<>("TRACE request received", HttpStatus.OK);
    }
}

