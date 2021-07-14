package com.cw.rpsgame.strategy;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class SimpleGameStrategy implements GameStrategy{

    @Override
    public Shape play(List<Shape> history) {
        Random random = new Random();
        switch (random.nextInt(3) + 1) {
            case 1:
                return Shape.ROCK;
            case 2:
                return Shape.PAPER;
            case 3:
                return Shape.SCISSOR;
            default:
                return Shape.ROCK;
        }
    }
}
