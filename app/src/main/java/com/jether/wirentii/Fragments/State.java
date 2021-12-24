package com.jether.wirentii.Fragments;

public enum State {
    User(3),Owner(2);

    private int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
