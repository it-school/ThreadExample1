package com.itschool.EX;

public class Dice {
    Cube[] dice;

    public Dice(final int N) {
        dice = new Cube[N];
        for (int i = 0; i < N; i++) {
            dice[i] = new Cube();
        }
        this.throwDice();
    }

    public void throwDice() {
        for (int i = 0; i < dice.length; i++) {
            //System.out.println(dice[i].getState());
            dice[i].run();
            //while (dice[i].isAlive());
        }

        int k = 0;

        do {
            k = 0;
            for (int i = 0; i < dice.length; i++) {
                if (!dice[i].isAlive())
                    k++;
            }
        } while (k != 6);
/*

            if (dice[i].getState() == Thread.State.NEW)
                dice[i].start();
            else
                if (dice[i].getState() == Thread.State.TERMINATED)
                {
                    dice[i].run();
                }
*/

    }

    @Override
    public String toString() {
        String s = "";
        for (Cube cube : dice) {
            s += cube.getNumber() + " ";
        }
        return s;
    }
}
