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
public class TokenServiceTest {

    @Autowired
    TokenService tokenService;

    @Test
    public void testGetToken() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(3l);
        userDTO.setPassword("na");
        assertThat(tokenService.getToken(userDTO)).isEqualTo("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzIn0.zqzPfW0eiVSbZt3a5GSdDYqFLYZXdnt2snHfA2oFHbY");

    }
}
