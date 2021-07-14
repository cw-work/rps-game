package com.cw.rpsgame.service;

import com.cw.rpsgame.domain.User;
import com.cw.rpsgame.dto.UserDTO;
import com.cw.rpsgame.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO findByUsername(UserDTO userDTO) {
        User user = userRepository.findUserByName(userDTO.getName());
        if (null == user) {
            throw new RuntimeException("Invalid name.");
        }
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id).get();
        if (null == user) {
            throw new RuntimeException("Invalid id.");
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
