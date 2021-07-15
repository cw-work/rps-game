package com.cw.rpsgame.controller;

import com.cw.rpsgame.annotation.UserLoginToken;
import com.cw.rpsgame.dto.BaseRequest;
import com.cw.rpsgame.dto.BaseResponse;
import com.cw.rpsgame.dto.UserDTO;
import com.cw.rpsgame.service.TokenService;
import com.cw.rpsgame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<UserDTO> login(@RequestBody BaseRequest<UserDTO> request) {
        UserDTO userDTO = userService.login(request.getArgument());

        if (userDTO == null) {
            return new BaseResponse<UserDTO>(400, "Invalid user or password.", null);
        } else {
            return new BaseResponse<UserDTO>(200, "Success.", userDTO);
        }
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<UserDTO> register(@RequestBody BaseRequest<UserDTO> request) {
        UserDTO userDTO = userService.register(request.getArgument());

        return new BaseResponse<UserDTO>(200, "Success.", userDTO);
    }

    @UserLoginToken
    @PostMapping(value = "/history")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<UserDTO> getUserHistory(@RequestBody BaseRequest<UserDTO> request) {
        UserDTO userDTO = userService.getUserHistory(request.getArgument());

        if (userDTO == null) {
            return new BaseResponse<UserDTO>(400, "Invalid user or password.", null);
        } else {
            return new BaseResponse<UserDTO>(200, "Success.", userDTO);
        }
    }
}
