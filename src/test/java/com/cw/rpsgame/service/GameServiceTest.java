package com.cw.rpsgame.service;

import com.cw.rpsgame.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Slf4j
public class GameServiceTest {

    @Autowired
    GameService gameService;

    @Test
    public void testPlayNormal() {
        // positive test
        // test one-time game play and verify the result and verify the result and the game record
    }

    @Test
    public void testPlayMultiple() {
        // positive test
        // test multiple-time game play and verify the result and the game record
    }

    @Test
    public void testPlayInvalidInput() {
        // negative test
        // test invalid game play input and verify the result
    }
}
