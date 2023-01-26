package com.sas.controller;

import com.sas.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

    @Autowired
    private RootService rootService;

    @PostMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("index");
        model.addObject("baseUrl", rootService.getBaseUrl(request));
        return model;
    }
}
