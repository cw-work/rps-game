package com.cw.rpsgame.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessException extends RuntimeException{

        @JsonProperty("code")
        private Integer code;

        @JsonProperty("message")
        private String message;
}
