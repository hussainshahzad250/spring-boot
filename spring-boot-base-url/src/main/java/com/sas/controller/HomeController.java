package com.sas.controller;

import com.sas.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private RootService rootService;

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("index");
        String clientIp = rootService.getClientIp(request);
        model.addObject("clientIp", clientIp);
        model.addObject("hostName", rootService.getLocalHostName());
        model.addObject("hostIP", rootService.getLocalHostIPAddress());
        return model;
    }

}