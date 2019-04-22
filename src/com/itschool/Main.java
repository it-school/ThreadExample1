package com.itschool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class Main {
    //Переменая, которой оперирует инкременатор
    public static int mValue = 0;

    static Incremenator mInc;	//Объект побочного потока

    public static void main(String[] args)
    {
        mInc = new Incremenator();	//Создание потока

        System.out.print("Значение = ");

        mInc.start();	//Запуск потока

        //Троекратное изменение действия инкременатора
        //с интервалом в i*2 секунд
        for(int i = 1; i <= 3; i++)
        {
            try{
                Thread.sleep(i*2*100); //Ожидание в течении i*2 сек.
            }catch(InterruptedException e){}

            mInc.changeAction();	//Переключение действия
        }

        mInc.finish();	//Инициация завершения побочного потока

        // Еще пример работы с потоками, но используя доступ к сети

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Document document = Jsoup.connect("http://study.cc.ua").timeout(30000).get();
                    String text = document.text();
                    System.out.println(text);
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = 0; i < 100000; i++)
                    {
                        list.add(i);
                    }

                    for (Integer i : list)
                    {
                        System.out.println(i);
                    }
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }).start();

        System.out.println("Information written");
    }

}
