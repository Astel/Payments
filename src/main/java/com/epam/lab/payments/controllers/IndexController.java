package com.epam.lab.payments.controllers;

import com.epam.lab.payments.dao.CreditCardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
/*
    //@GetMapping("/")
    @RequestMapping(value = "/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Cards:");

        return new ModelAndView("index", model);
    }*/

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

}
