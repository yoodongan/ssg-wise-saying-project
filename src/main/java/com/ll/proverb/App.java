package com.ll.proverb;

import java.util.Scanner;

public class App {
    private Scanner sc;
    App() {
        sc = new Scanner(System.in);
    }
    public void run() {
        System.out.println("== 명언 SSG ==");
        outer:
        while(true) {
            String cmd = sc.nextLine();
            switch(cmd) {
                case "등록" :
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();

                case "종료" :
                    break outer;
            }
        }

    }


}
