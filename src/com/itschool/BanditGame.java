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

    public String Play() {
        slot1.run();
        slot2.run();
        slot3.run();
        do {
//            System.out.println("\nStates:");
//            System.out.println(slot1.getState());
//            System.out.println(slot2.getState());
//            System.out.println(slot3.getState());
        } while (slot1.getState() != Thread.State.NEW && slot2.getState() != Thread.State.NEW && slot3.getState() != Thread.State.NEW);

        return slot1.slot + "\t" + slot2.slot + "\t" + slot3.slot;
    }
}
