package com.epam.lab.payments.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrdersController {

    @RequestMapping("/orders")
    public String cards(Model model) {
        model.addAttribute("OrdersTitle", "Orders:");
        return "madeOrders.html";
    }
}
