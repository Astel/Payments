package com.epam.lab.payments.web;

import com.epam.lab.payments.UserValidator;
import com.epam.lab.payments.dto.UserDTO;
import com.epam.lab.payments.services.AuthorizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

import static com.epam.lab.payments.Constants.LOGIN;
import static com.epam.lab.payments.Constants.REGISTRATION;

@Controller
@RequiredArgsConstructor
@Log4j
public class AuthorizationController {
    private final AuthorizationService authorizationService;
    private final UserValidator userValidator;

    @RequestMapping(value = REGISTRATION, method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        UserDTO user = new UserDTO();
        modelAndView.addObject("user", user);
        modelAndView.setViewName(REGISTRATION);
        return modelAndView;
    }

    @RequestMapping(value = REGISTRATION, method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid UserDTO user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("user", user);
            modelAndView.addObject("successMessage",
                    "Some fields have errors");
            modelAndView.setViewName(REGISTRATION);
            log.info("Some errors when registering user " + bindingResult.getAllErrors());
        } else {
            authorizationService.save(user);
            modelAndView.addObject("successMessage",
                    "User has been registered successfully");
            modelAndView.addObject("user", new UserDTO());
            modelAndView.setViewName(REGISTRATION);
            log.info("User " + user + "has been registered successfully");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ModelAndView adminCreateUser(UserDTO userDTO, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/reports/admin");
        if ("add".equals(userDTO.getOper())) {
            userValidator.validate(userDTO, bindingResult);

            if (bindingResult.hasErrors()) {
                modelAndView.addObject("errorMessage", bindingResult.getAllErrors());
                log.info("Some errors when registering user " + bindingResult.getAllErrors());
            }
            authorizationService.save(userDTO);
        } else if ("del".equals(userDTO.getOper())) {
            authorizationService.delete(userDTO);
        }

        return modelAndView;
    }

    @RequestMapping(value = {"/", LOGIN}, method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            modelAndView.setViewName("reports/userDetails");
        } else {
            modelAndView.setViewName(LOGIN);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ModelAndView updateUser(UserDTO user, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Principal principal = request.getUserPrincipal();
        if (user.getEmail().equals(principal.getName())) {
            authorizationService.update(user);
        }
        modelAndView.setViewName("reports/userDetails");
        return modelAndView;
    }

}
