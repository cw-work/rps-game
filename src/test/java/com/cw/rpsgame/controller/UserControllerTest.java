package com.cw.rpsgame.controller;

import com.cw.rpsgame.domain.UserAccount;
import com.cw.rpsgame.dto.BaseRequest;
import com.cw.rpsgame.dto.UserDTO;
import com.cw.rpsgame.repository.UserAccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liquibase.pro.packaged.U;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

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
    public void testUserAccountCreation() throws Exception {
        UserAccount userAccount = userAccountRepository.findUserByName("Charlie");
        userAccountRepository.delete(userAccount);

        UserDTO userDTO = new UserDTO();
        userDTO.setName("Charlie");
        userDTO.setPassword("na");
        BaseRequest<UserDTO> baseRequest = new BaseRequest<>();
        baseRequest.setArgument(userDTO);

        mockMvc
                .perform(post("/user/register").content(objectMapper.writeValueAsString(baseRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        userAccount = userAccountRepository.findUserByName("Charlie");
        assertThat(userAccount).isNotNull();
    }

}
