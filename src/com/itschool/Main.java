package com.itschool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class Main
{
	//Переменая, которой оперирует инкременатор
	public static int mValue = 0;
	public static boolean isFinished = false;
	static double sum1 = 0;
	static double sum2 = 0;
	static Incrementator mInc;    //Объект побочного потока
	static boolean isFinished1 = false, isFinished2 = false;
	static long[] finish1 = {0, 0, 0, 0};
	static long start = System.currentTimeMillis(), finish;

	public static void main(String[] args) throws InterruptedException
	{
		part1();
		//part2();
	}

	/**
	 * multithreading
	 */
	public static void part1()
	{
		mInc = new Incrementator();   //Создание потока
		System.out.print("Значение = ");
		mInc.start();   //Запуск потока

		// пример работы с потоками, используя доступ к сети
		new Thread
				(
						new Runnable()
						{
							@Override
							public void run()
							{
								try {
									Document document = Jsoup.connect("http://study.cc.ua").timeout(10000).get();
									String text = document.text();
									System.out.println(System.lineSeparator() + text);
									mInc.finish();    //Инициация завершения побочного потока
								}
								catch (Exception ex) {
									ex.printStackTrace();
								}
							}
						}
				).start();

		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try {
					ArrayList<Integer> list = new ArrayList<>();
					for (int i = 0; i < 100000; i++) {
						list.add(i);
						if (i % 1000 == 0) { System.out.println(list.get(i)); }
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}).start();

	}

	public static void part2()
	{
		final int N = 120000000;
		double[] values = new double[N];


		for (int i = 1; i < N; i++) {
			values[i] = ((Math.sqrt(i) + i * 5 + i) / (Math.sqrt(i)) * (i / 7) + 1);
			//System.out.println(values[i]);
		}
		finish = System.currentTimeMillis();
		System.out.println(finish - start);

		// ---------------------------

		final int N1 = 100000000 / 4;
		double[] valuesP = new double[N];

		start = System.currentTimeMillis();

		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try {
					for (int i = 1; i < N1; i++) {
						valuesP[i] = ((Math.sqrt(i) + i * 5 + i) / (Math.sqrt(i)) * (i / 7) + 1);
					}
					finish1[0] = System.currentTimeMillis();
					System.out.println("part1: " + (finish1[0] - start));
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try {
					for (int i = N1; i < N1 * 2; i++) {
						valuesP[i] = ((Math.sqrt(i) + i * 5 + i) / (Math.sqrt(i)) * (i / 7) + 1);
					}
					finish1[1] = System.currentTimeMillis();
					System.out.println("part2: " + (finish1[1] - start));
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try {
					for (int i = N1 * 2; i < N1 * 3; i++) {
						valuesP[i] = ((Math.sqrt(i) + i * 5 + i) / (Math.sqrt(i)) * (i / 7) + 1);
					}
					finish1[2] = System.currentTimeMillis();
					System.out.println("part3: " + (finish1[2] - start));
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				try {
					for (int i = N1 * 3; i < N; i++) {
						valuesP[i] = ((Math.sqrt(i) + i * 5 + i) / (Math.sqrt(i)) * (i / 7) + 1);
					}
					finish1[3] = System.currentTimeMillis();
					System.out.println("part4: " + (finish1[3] - start));
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}).start();
	}
}
