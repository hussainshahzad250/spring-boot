package com.sas.controller;

import com.sas.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RootController {

    @Autowired
    private RootService rootService;

    @GetMapping("/getBaseUrl")
    public String getBaseUrl(HttpServletRequest request) {
        return rootService.getBaseUrl(request);
    }
}
