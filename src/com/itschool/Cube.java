package com.itschool;

public class Cube extends Thread {
    private int number;

    public int getNumber() {
        return number;
    }

    private int genNumber() {
        return (int) (1 + Math.random() * 6);
    }

    @Override
    public void run() {
        this.number = this.genNumber();
    }
}
