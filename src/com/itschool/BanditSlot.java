package com.itschool;

public class BanditSlot extends Thread implements Runnable {
    Slot slot;

    @Override
    public void run() {
/*        for (int i = 0; i < 1000000; i++) {
            double q = Math.pow(i*1.234567, i*i);
        }*/

        int time = 0;
        do {
            slot = Slot.values()[(int) (Math.random() * Slot.values().length)];
            //System.out.println(time);
//            System.out.println(this.getState());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (time++ < 100);
    }
}
