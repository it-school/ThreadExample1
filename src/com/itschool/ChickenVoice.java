package com.itschool;
public class ChickenVoice	//Класс с методом main()
{
    static EggVoice mAnotherOpinion;	//Побочный поток
    static Dinosaur dinoOpinion;    //Побочный поток

    public static void main(String[] args)
    {
        mAnotherOpinion = new EggVoice();	//Создание потока
        dinoOpinion = new Dinosaur();    //Создание потока
        System.out.println("Спор начат...");
        mAnotherOpinion.start(); 			//Запуск потока
        dinoOpinion.start();

        for(int i = 0; i < 5; i++)
        {
            try{
                Thread.sleep(1000);	//Приостанавливает поток на 1 секунду
            }catch(InterruptedException e){}
            System.out.println("курица!");
        }

        //Слово «курица» сказано 5 раз

        if(mAnotherOpinion.isAlive())	//Если оппонент ещё не сказал последнее слово
        {
            try{
                mAnotherOpinion.join();	//Подождать пока оппонент закончит высказываться.
            }catch(InterruptedException e){}

            System.out.println("Первым появилось яйцо!");
        }
        else	//если оппонент уже закончил высказываться
        {
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }
}

