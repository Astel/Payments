package com.epam.lab.payments;

import com.epam.lab.payments.dto.UserDTO;
import com.epam.lab.payments.services.AuthorizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.epam.lab.payments.Constants.EMAIL;
import static com.epam.lab.payments.Constants.PASSWORD;

@Component
@RequiredArgsConstructor
@Log4j
public class UserValidator implements Validator {
    private final AuthorizationService authorizationService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO userDTO = (UserDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, EMAIL, "NotEmpty");
        if (userDTO.getEmail().length() < 6 || userDTO.getEmail().length() > 32) {
            errors.reject(EMAIL, "Size.userForm.email");
            log.info("User email " + userDTO.getEmail() + " has incorrect length"
                    + userDTO.getEmail().length());
        }

        if (authorizationService.findUserByEmail(userDTO.getEmail()) != null) {
            errors.reject(EMAIL, "Duplicate.userForm.email");
            log.info("User email " + userDTO.getEmail() + " has duplicate by "
                    + authorizationService.findUserByEmail(userDTO.getEmail()));
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASSWORD, "NotEmpty");
        if (userDTO.getPassword().length() < 8 || userDTO.getPassword().length() > 32) {
            errors.reject(PASSWORD, "Size.userForm.password");
            log.info("User password has incorrect length");
        }
    }
}
