package com.itschool;

class Incremenator extends Thread
{
    //О ключевом слове volatile - чуть ниже
    private volatile boolean mIsIncrement = true;
    private volatile boolean mFinish = false;

    public void changeAction()	//Меняет действие на противоположное
    {
        mIsIncrement = !mIsIncrement;
    }
    public void finish()		//Инициирует завершение потока
    {
        mFinish = true;
    }

    @Override
    public void run()
    {
        do
        {
            if(!mFinish)	//Проверка на необходимость завершения
            {
                if(mIsIncrement)
                    Main.mValue++;	//Инкремент
                else
                    Main.mValue--;	//Декремент

                //Вывод текущего значения переменной
                System.out.print(Main.mValue + " ");
            } else {
                System.out.println("Finished");
                return;        //Завершение потока
            }
            try{
                Thread.sleep(100); //Приостановка потока на 1 сек.
            }catch(InterruptedException e){}
        }
        while(true);
    }
}

