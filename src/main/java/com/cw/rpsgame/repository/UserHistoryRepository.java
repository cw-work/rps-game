package com.cw.rpsgame.repository;

import com.cw.rpsgame.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long>, JpaSpecificationExecutor<UserHistory> {
}
