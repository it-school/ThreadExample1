package com.itschool;

public class Main {
   //Переменная, которой оперирует инкрементатор
   public static int mValue = 0;
   public static boolean isFinished = false;
   static double sum1 = 0;
   static double sum2 = 0;
   static Incremenator mInc;    //Объект побочного потока
   static boolean isFinished1 = false, isFinished2 = false;

   public static void main(String[] args) throws InterruptedException {
      /*
      final int N = 500000000;

      int[] array = new int[N];
      long start = System.currentTimeMillis();

      new Thread
              (
                      new Runnable() {
                         @Override
                         public void run() {
                            try {
                               for (int i = 0; i < N / 2; i++) {
                                  array[i] = (int) (Math.random() * 10);
                               }
                               isFinished1 = true;
                            } catch (Exception ex) {
                               ex.printStackTrace();
                            }
                         }
                      }
              ).start();

      new Thread
              (
                      new Runnable() {
                         @Override
                         public void run() {
                            try {
                               for (int i = N / 2; i < N; i++) {
                                  array[i] = (int) (Math.random() * 10);
                               }
                               isFinished2 = true;
                            } catch (Exception ex) {
                               ex.printStackTrace();
                            }
                         }
                      }
              ).start();

      long stop = System.currentTimeMillis();
      System.out.println(stop - start);

      do {
         Thread.sleep(1);
      } while (!isFinished1 && !isFinished2);

      stop = System.currentTimeMillis();
      System.out.println(stop - start);

*/

/*
      BanditGame banditGame = new BanditGame();
      System.out.println(banditGame.Play(10));
*/

/*
      mInc = new Incremenator();   //Создание потока

      System.out.print("Значение = ");

      mInc.start();   //Запуск потока

      //Троекратное изменение действия инкременатора
      //с интервалом в i*2 секунд
      for (int i = 1; i <= 3; i++) {
         try {
            Thread.sleep(i * 2 * 100); //Ожидание в течении i*2 сек.
         } catch (InterruptedException e) {
         }

         mInc.changeAction();   //Переключение действия
      }

      // Еще пример работы с потоками, но используя доступ к сети
      new Thread
              (
                      new Runnable() {
                         @Override
                         public void run() {
                            try {
                               Document document = Jsoup.connect("http://study.cc.ua").timeout(10000).get();
                               String text = document.text();
                               System.out.println(text);
                               mInc.finish();    //Инициация завершения побочного потока
                            } catch (Exception ex) {
                               ex.printStackTrace();
                            }
                         }
                      }
              ).start();

      new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               ArrayList<Integer> list = new ArrayList<>();
               for (int i = 0; i < 100000; i++) {
                  list.add(i);
                  if (i % 1000 == 0)
                     System.out.println(list.get(i));
               }
            } catch (Exception ex) {
               ex.printStackTrace();
            }
         }
      }).start();

*/
/*
        System.out.println("Information written");
        System.out.println("\nStates:");
        System.out.println(banditGame.slot1.getState());
        System.out.println(banditGame.slot2.getState());
        System.out.println(banditGame.slot3.getState());

//----------------------------

 */
/*
        long start = System.currentTimeMillis();

        dices();

        final int N = 200000000;
        double[] array = new double[N];
        for (int i = 0; i < N; i++) {
            array[i] = Math.random() * 10;
        }
        System.out.println("Array is filled!");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < array.length / 2; i++) {
                        sum1 += array[i];
                        if (i % (array.length / 100) == 0)
                            System.out.println(i / (array.length / 100) + "%");
                    }
                    isFinished1 = true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        System.out.println("1 half");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = array.length / 2; i < array.length; i++) {
                        sum2 += array[i];
                        if (i % (array.length / 100) == 0)
                            System.out.println(i / (array.length / 100) + "%");
                    }
                    isFinished2 = true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        System.out.println("2 half");

        do {
            Thread.sleep(1);
        }
        while (!isFinished1 && !isFinished2);
        System.out.println("Sum = " + (sum1 + sum2));


        long finish = System.currentTimeMillis();

        System.out.println(finish - start);
    }

    private static void dices() throws InterruptedException {
        Cube cube1 = new Cube();
        cube1.start();

        while (cube1.isAlive()) {
            Thread.sleep(10);
        }
*/

/*
        Dice dice = new Dice(6);
        System.out.println(dice);
        dice.throwDice();
        System.out.println(dice);
        dice.throwDice();
        System.out.println(dice);
        dice.throwDice();
        System.out.println(dice);
 */
   }
}
