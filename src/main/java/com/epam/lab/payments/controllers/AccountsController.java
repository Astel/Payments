package com.epam.lab.payments.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountsController {

    @RequestMapping("/accounts")
    public String cards(Model model) {
        model.addAttribute("AccountsTitle", "Accounts:");
        return "bankAccounts.html";
    }
}
