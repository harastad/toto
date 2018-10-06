package com.epam.training.toto.domain;

public enum Outcome {
    ONE('1'),
    TWO('2'),
    DRAW('X');

    private final char outcome;
    Outcome(char outcome) {
        this.outcome = outcome;
    }
}
