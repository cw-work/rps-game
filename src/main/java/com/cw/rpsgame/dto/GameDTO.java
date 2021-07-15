package com.cw.rpsgame.dto;

import com.cw.rpsgame.strategy.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.websocket.SendHandler;

@Data
public class GameDTO {

    @JsonProperty("history_id")
    private Long historyId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_shape")
    private Shape userShape;

    @JsonProperty("application_shape")
    private String applicationShape;

    @JsonProperty("winner")
    private String winner;
}
