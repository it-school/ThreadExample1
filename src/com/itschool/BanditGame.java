package com.itschool;

public class BanditGame {
    BanditSlot slot1;
    BanditSlot slot2;
    BanditSlot slot3;

    public BanditGame() {
        slot1 = new BanditSlot();
        slot2 = new BanditSlot();
        slot3 = new BanditSlot();
    }

    public String Play() throws InterruptedException {
        slot1.start();
        slot2.start();
        slot3.start();
        do {
            System.out.println("\nStates:");
            System.out.println(slot1.getState());
            System.out.println(slot2.getState());
            System.out.println(slot3.getState());
        } while (slot1.getState() != Thread.State.TERMINATED && slot2.getState() != Thread.State.TERMINATED && slot3.getState() != Thread.State.TERMINATED);

        return slot1.slot + "\t" + slot2.slot + "\t" + slot3.slot;


    }
}

class threadState implements Runnable {
    public void run() {
        String state = Thread.currentThread().getState().toString();
        String name = Thread.currentThread().getName();
        System.out.println(name + " is in " + state + " state");
    }
}
