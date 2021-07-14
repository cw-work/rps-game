package com.cw.rpsgame.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long Id;

    @Column(name = "name")
    String name;

    @Column(name = "password")
    String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserHistory> userHistoryList;
}
