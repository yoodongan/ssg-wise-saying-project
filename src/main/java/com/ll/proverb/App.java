package com.ll.proverb;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private int wiseSayingId;
    App() {
        sc = new Scanner(System.in);
        wiseSayingId = 0;
    }
    public void run() {
        System.out.println("== 명언 SSG ==");
        outer:
        while(true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine();
            switch(cmd) {
                case "등록" :
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();
                    wiseSayingId++;
                    System.out.printf("%d번 명언이 등록되었습니다!\n", wiseSayingId);
                    break;

                case "종료" :
                    break outer;
            }
        }

    }


}
