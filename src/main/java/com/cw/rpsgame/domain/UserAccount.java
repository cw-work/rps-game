package com.cw.rpsgame.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user_account")
@EntityListeners(AuditingEntityListener.class)
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "password")
    String password;

    @OneToMany(mappedBy = "userAccount", fetch = FetchType.LAZY)
    private List<UserHistory> userHistoryList;
}
