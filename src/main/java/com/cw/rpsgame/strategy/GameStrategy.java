package com.cw.rpsgame.strategy;

import java.util.List;

public interface GameStrategy {
    Shape play(List<Shape> history);
}
