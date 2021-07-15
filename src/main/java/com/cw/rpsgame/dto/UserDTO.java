package com.cw.rpsgame.dto;

import com.cw.rpsgame.strategy.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("password")
    private String password;

    @JsonProperty("token")
    private String token;

    @JsonProperty("history")
    private List<GameDTO> history;
}
