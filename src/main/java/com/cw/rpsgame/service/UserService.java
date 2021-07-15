package com.cw.rpsgame.service;

import com.cw.rpsgame.domain.UserAccount;
import com.cw.rpsgame.domain.UserHistory;
import com.cw.rpsgame.dto.BaseResponse;
import com.cw.rpsgame.dto.GameDTO;
import com.cw.rpsgame.dto.UserDTO;
import com.cw.rpsgame.repository.UserAccountRepository;
import com.cw.rpsgame.repository.UserHistoryRepository;
import liquibase.pro.packaged.G;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    UserHistoryRepository userHistoryRepository;

    @Autowired
    TokenService tokenService;

    public UserDTO login(UserDTO userDTO) {
        UserAccount userAccount = userAccountRepository.findUserByName(userDTO.getName());

        if (userAccount == null || !userAccount.getPassword().equals(userDTO.getPassword())) {
            return null;
        } else {
            BeanUtils.copyProperties(userAccount, userDTO);
            String token = tokenService.getToken(userDTO);
            userDTO.setToken(token);

            return userDTO;
        }
    }

    public UserDTO register(UserDTO userDTO) {
        UserAccount userAccount = new UserAccount();
        userAccount.setName(userDTO.getName());
        userAccount.setPassword(userDTO.getPassword());
        userAccount = userAccountRepository.save(userAccount);

        userDTO.setId(userAccount.getId());
        String token = tokenService.getToken(userDTO);
        userDTO.setToken(token);

        return userDTO;
    }

    public UserDTO getUserHistory(UserDTO userDTO) {
        UserAccount userAccount = userAccountRepository.findUserById(userDTO.getId());

        if (null == userAccount) {
            return null;
        } else {
            List<GameDTO> gameDTOList =
                    Optional.ofNullable(userAccount.getUserHistoryList()).orElse(new ArrayList<>())
                            .stream().map(h -> {
                        GameDTO gameDTO = new GameDTO();
                        gameDTO.setUserId(h.getUserAccount().getId());
                        gameDTO.setHistoryId(h.getId());
                        gameDTO.setUserShape(h.getUserShape());

                        return gameDTO;
                    }).collect(Collectors.toList());
            userDTO.setHistory(gameDTOList);

            return userDTO;
        }
    }

    public GameDTO persistUserHistory(GameDTO gameDTO) {
        UserAccount userAccount = userAccountRepository.findUserById(gameDTO.getUserId());

        if (null == userAccount) {
            return null;
        } else {
            UserHistory userHistory = new UserHistory();
            userHistory.setUserAccount(userAccount);
            userHistory.setUserShape(gameDTO.getUserShape());
            userHistoryRepository.save(userHistory);

            return gameDTO;
        }
    }

    public UserDTO findUserById(Long id) {
        UserAccount userAccount = userAccountRepository.findById(id).get();
        if (null == userAccount) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userAccount, userDTO);
        return userDTO;
    }
}
