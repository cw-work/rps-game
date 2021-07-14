package com.cw.rpsgame.controller;

import com.alibaba.fastjson.JSONObject;
import com.cw.rpsgame.annotation.UserLoginToken;
import com.cw.rpsgame.dto.BaseRequest;
import com.cw.rpsgame.dto.BaseResponse;
import com.cw.rpsgame.dto.GameDTO;
import com.cw.rpsgame.dto.UserDTO;
import com.cw.rpsgame.service.GameService;
import com.cw.rpsgame.service.TokenService;
import com.cw.rpsgame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/play")
    public BaseResponse<GameDTO> play(@RequestBody BaseRequest<GameDTO> request) {
        GameDTO result = gameService.play(request.getArgument());

        return new BaseResponse<GameDTO>(200, "Success.", result);
    }
}
