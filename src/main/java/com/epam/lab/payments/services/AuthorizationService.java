package com.epam.lab.payments.services;

import com.epam.lab.payments.dao.UserRepository;
import com.epam.lab.payments.domain.UserEntity;
import com.epam.lab.payments.dto.UserDTO;
import com.epam.lab.payments.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j
public class AuthorizationService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(UserDTO userDTO) {
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userMapper.userDtoToUser(userDTO));
        log.info("Save user " + userDTO);
    }

    public void delete(UserDTO userDTO) {
        userRepository.delete(userMapper.userDtoToUser(userDTO));
        log.info("Delete user " + userDTO);
    }

    public void update(UserDTO user) {
        UserEntity oldUser = userRepository.findByEmail(user.getEmail());
        if (!user.getPhone().isEmpty()) {
            oldUser.setPhone(user.getPhone());
        }
        if (!user.getPassword().isEmpty()) {
            oldUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        userRepository.save(oldUser);
        log.info("Update user " + oldUser);
    }

}
