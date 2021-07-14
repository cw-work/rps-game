package com.cw.rpsgame.dto;

import com.cw.rpsgame.strategy.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.websocket.SendHandler;

@Data
public class GameDTO {

    @JsonProperty("player_id")
    private Long playerId;

    @JsonProperty("player_name")
    private String playerName;

    @JsonProperty("player_shape")
    private Shape playerShape;

    @JsonProperty("winner")
    private String winner;
}
