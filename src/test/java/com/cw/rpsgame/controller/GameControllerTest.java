package com.cw.rpsgame.controller;

import com.cw.rpsgame.domain.UserAccount;
import com.cw.rpsgame.dto.BaseRequest;
import com.cw.rpsgame.dto.UserDTO;
import com.cw.rpsgame.repository.UserAccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper = new ObjectMapper();

    Long id;

    @BeforeEach
    public void setUp() throws Exception {
        UserAccount userAccount = userAccountRepository.findUserByName("Charlie");
        if (null == userAccount) {
            userAccount = new UserAccount();
            userAccount.setName("Charlie");
            userAccount.setPassword("na");
            userAccount = userAccountRepository.save(userAccount);
        }
        this.id = userAccount.getId();
    }

    @AfterEach
    public void clearData() throws Exception {
        UserAccount userAccount = userAccountRepository.findUserByName("Charlie");
        if (null != userAccount) {
            userAccountRepository.delete(userAccount);
        }
    }

    @Test
    public void testPlaySimple() throws Exception {
        // positive test
    }

    @Test
    public void testPlayInvalidInput() throws Exception{
        // negative test

    }
}
