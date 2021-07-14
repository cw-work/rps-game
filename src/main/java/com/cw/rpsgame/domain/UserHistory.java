package com.cw.rpsgame.domain;

import com.cw.rpsgame.strategy.Shape;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "user_history")
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Where(clause = "deleted = false")
public class UserHistory {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "shape")
    @Enumerated(EnumType.STRING)
    private Shape shape;
}
