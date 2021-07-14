package com.cw.rpsgame.service;

import com.cw.rpsgame.domain.User;
import com.cw.rpsgame.dto.GameDTO;
import com.cw.rpsgame.dto.UserDTO;
import com.cw.rpsgame.repository.UserRepository;
import com.cw.rpsgame.strategy.Shape;
import com.cw.rpsgame.strategy.SimpleGameStrategy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    SimpleGameStrategy simpleGameStrategy;

    @Autowired
    UserRepository userRepository;

    public GameDTO play(GameDTO gameDTO) {
        User user = userRepository.findById(gameDTO.getPlayerId()).get();
        Shape shape =  simpleGameStrategy.play(user.getUserHistoryList().stream().map(uh -> uh.getShape()).collect(Collectors.toList()));
        gameDTO.setWinner(judge(gameDTO.getPlayerShape(), shape));

        return gameDTO;
    }

    private String judge(Shape playerShape, Shape shape) {
        return "application"; // :-D
    }
}
