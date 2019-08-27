package com.itschool;

public class BanditSlot extends Thread implements Runnable {
    Slot slot;

    @Override
    public void run() {
/*        for (int i = 0; i < 1000000; i++) {
            double q = Math.pow(i*1.234567, i*i);
        }*/
        int choice = (int) (Math.random() * 5);
        slot = Slot.values()[choice];
    }
}
