package com.cw.rpsgame.service;

import com.cw.rpsgame.domain.UserAccount;
import com.cw.rpsgame.dto.GameDTO;
import com.cw.rpsgame.repository.UserAccountRepository;
import com.cw.rpsgame.strategy.GameEngine;
import com.cw.rpsgame.strategy.Shape;
import com.cw.rpsgame.strategy.SimpleGameStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    GameEngine gameEngine;

    @Autowired
    UserService userService;

    public GameDTO play(GameDTO gameDTO) {
        gameDTO.setWinner(gameEngine.play(gameDTO.getUserShape()).toString());
        userService.persistUserHistory(gameDTO);

        return gameDTO;
    }
}
