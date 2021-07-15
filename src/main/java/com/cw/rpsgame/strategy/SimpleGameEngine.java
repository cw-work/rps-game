package com.cw.rpsgame.strategy;

import lombok.Data;

@Data
public class SimpleGameEngine implements GameEngine{

    private GameStrategy gameStrategy;

    @Override
    public GameResult play(Shape userShape) {
        Shape applicationShape = gameStrategy.generateShape();

        switch (applicationShape) {
            case ROCK:
                switch (userShape) {
                    case ROCK:
                        return GameResult.DRAW;
                    case PAPER:
                        return GameResult.WIN;
                    case SCISSOR:
                        return GameResult.LOSS;
                    default:
                        return GameResult.DRAW;
                }
            case PAPER:
                switch (userShape) {
                    case ROCK:
                        return GameResult.LOSS;
                    case PAPER:
                        return GameResult.DRAW;
                    case SCISSOR:
                        return GameResult.WIN;
                    default:
                        return GameResult.DRAW;
                }
            case SCISSOR:
                switch (userShape) {
                    case ROCK:
                        return GameResult.WIN;
                    case PAPER:
                        return GameResult.LOSS;
                    case SCISSOR:
                        return GameResult.DRAW;
                    default:
                        return GameResult.DRAW;
                }
            default:
                return GameResult.DRAW;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private GameStrategy gameStrategy;

        public Builder gameStrategy(GameStrategy gameStrategy) {
            this.gameStrategy = gameStrategy;
            return this;
        }

        public GameEngine build() {
            SimpleGameEngine simpleGameEngine = new SimpleGameEngine();
            simpleGameEngine.setGameStrategy(this.gameStrategy);

            return simpleGameEngine;
        }
    }
}
