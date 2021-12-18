package com.itschool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DataDownloader extends Thread {
   String text;

   @Override
   public void run() {
      try {
         Document document = Jsoup.connect("http://china.cn").timeout(10000).get();
         text = document.text();
//         System.out.println(text);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }
}