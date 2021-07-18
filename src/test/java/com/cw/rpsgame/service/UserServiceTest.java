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
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testLoginSimple() {
        // positive test
        // test simple user login
    }

    @Test
    public void testLoginInvalidInput() {
        // negative test
        // test invalid user login
    }

    @Test
    public void testRegisterSimple() {
        // positive test
        // test simple user register
    }

    @Test
    public void testRegisterInvalidInput() {
        // negative test
        // test invalid user register
    }

    @Test
    public void testGetUserHistorySimple() {
        // positive test
        // test get user history
    }

    @Test
    public void testGetUserHistoryInvalidInput() {
        // negative test
        // test get user history with invalid input
    }
}
