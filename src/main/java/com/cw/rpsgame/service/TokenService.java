package com.cw.rpsgame.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cw.rpsgame.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String getToken(UserDTO user) {
        return JWT.create().withAudience(user.getId().toString())
                .sign(Algorithm.HMAC256(user.getPassword()));
    }
}
