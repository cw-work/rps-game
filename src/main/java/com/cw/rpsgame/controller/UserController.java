package com.cw.rpsgame.controller;

import com.cw.rpsgame.annotation.UserLoginToken;
import com.cw.rpsgame.dto.BaseRequest;
import com.cw.rpsgame.dto.BaseResponse;
import com.cw.rpsgame.dto.UserDTO;
import com.cw.rpsgame.service.TokenService;
import com.cw.rpsgame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public BaseResponse<UserDTO> login(@RequestBody BaseRequest<UserDTO> request) {
        UserDTO userForBase = userService.findByUsername(request.getArgument());

        if (userForBase == null) {
            return new BaseResponse<UserDTO>(401, "Invalid user.", null);
        } else {
            if (!userForBase.getPassword().equals(request.getArgument().getPassword())) {
                return new BaseResponse<UserDTO>(402, "Invalid password.", null);
            } else {
                String token = tokenService.getToken(userForBase);
                UserDTO userDTO = request.getArgument();
                userDTO.setToken(token);
                return new BaseResponse<UserDTO>(200, "Success.", userDTO);
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getUserHistory")
    public BaseResponse<UserDTO> getUserHistory(@RequestBody BaseRequest<UserDTO> request) {
        UserDTO userForBase = userService.findByUsername(request.getArgument());

        if (userForBase == null) {
            return new BaseResponse<UserDTO>(401, "Invalid user.", null);
        } else {
            if (!userForBase.getPassword().equals(request.getArgument().getPassword())) {
                return new BaseResponse<UserDTO>(402, "Invalid password.", null);
            } else {
                return new BaseResponse<UserDTO>(200, "Success.", userForBase);
            }
        }
    }
}
