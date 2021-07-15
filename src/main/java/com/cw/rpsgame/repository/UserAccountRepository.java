package com.cw.rpsgame.repository;

import com.cw.rpsgame.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>, JpaSpecificationExecutor<UserAccount> {

    UserAccount findUserByName(String name);

    UserAccount findUserById(Long id);
}
