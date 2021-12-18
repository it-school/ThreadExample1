package com.itschool;

public class BanditGame {
    BanditSlot slot1;
    BanditSlot slot2;
    BanditSlot slot3;

    public BanditGame() {

    }

    public String Play(int time) throws InterruptedException {
        slot1 = new BanditSlot();
        slot2 = new BanditSlot();
        slot3 = new BanditSlot();

/*        System.out.println(slot1.getState());
        System.out.println(slot2.getState());
        System.out.println(slot3.getState());*/
        if (!slot1.isAlive() && !slot2.isAlive() && !slot3.isAlive()) {
            slot1.start();
            slot2.start();
            slot3.start();

            slot1.join();
            slot2.join();
            slot3.join();
        }
/*
        do {
            Thread.sleep(1);
        } while (slot1.getState() != Thread.State.TERMINATED && slot2.getState() != Thread.State.TERMINATED && slot3.getState() != Thread.State.TERMINATED);
 */
/*
        System.out.println("\nStates:");
        System.out.println(slot1.getState());
        System.out.println(slot2.getState());
        System.out.println(slot3.getState());
*/
        String result = "0";
        if (slot1.slot == slot2.slot && slot1.slot == slot3.slot && slot1.slot == Slot.bar)
            result = "10000";
        else if (slot1.slot == slot2.slot && slot1.slot == slot3.slot && slot1.slot == Slot.cherry)
            result = "1000";
        else if (slot1.slot == slot2.slot && slot1.slot == slot3.slot && slot1.slot == Slot.five)
            result = "500";
        else if (slot1.slot == slot2.slot && slot1.slot == slot3.slot && slot1.slot == Slot.seven)
            result = "300";
        else if (slot1.slot == slot2.slot && slot1.slot == slot3.slot && slot1.slot == Slot.lemon)
            result = "100";
        else if (slot1.slot == slot2.slot && slot1.slot == slot3.slot && slot1.slot == Slot.watermelon)
            result = "50";
        else if (slot1.slot == slot2.slot && slot1.slot == slot3.slot && slot1.slot == Slot.zero)
            result = "10";


        return slot1.slot + "\t" + slot2.slot + "\t" + slot3.slot + " -> " + result;
    }

    // todo check if win
}

class ThreadState implements Runnable {
    public void run() {
        String state = Thread.currentThread().getState().toString();
        String name = Thread.currentThread().getName();
        System.out.println(name + " is in " + state + " state");
    }
}