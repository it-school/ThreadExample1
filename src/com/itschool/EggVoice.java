package com.itschool;

class EggVoice extends Thread
{
	@Override
	public void run()
	{
		for (int i = 0; i < 5; i++) {
			try {
				sleep(1000);   //Приостанавливает поток на 1 сек
				System.out.println(this.getState());
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("яйцо!");
		}
		//Слово «яйцо» сказано 5 раз
	}
}
