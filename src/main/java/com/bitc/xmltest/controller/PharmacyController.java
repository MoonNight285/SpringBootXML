package com.bitc.xmltest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PharmacyController {
    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }
}
