package com.ll.proverb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    private int wiseSayingId;
    List<WiseSaying> wiseSayingList;
    App() {
        sc = new Scanner(System.in);
        wiseSayingId = 0;
        wiseSayingList = new ArrayList<>();
    }
    public void run() {
        System.out.println("== 명언 SSG ==");
        outer:
        while(true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd);
            switch(rq.getPath()) {
                case "등록" :
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();
                    wiseSayingId++;
                    WiseSaying wiseSaying = new WiseSaying(wiseSayingId, content, author);
                    wiseSayingList.add(wiseSaying);
                    System.out.printf("%d번 명언이 등록되었습니다!\n", wiseSayingId);
                    break;
                case "목록" :
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("---------------------");
                    for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying1 = wiseSayingList.get(i);
                        System.out.printf("%d / %s / %s\n", wiseSaying1.getId(), wiseSaying1.getContent(), wiseSaying1.getAuthor());
                    }
                    break;
                case "삭제" :
                    int id = rq.getIntParam("id", 0);
                    if (id == 0) {
                        System.out.println("번호를 입력해주세요.");
                        continue;
                    }
                    WiseSaying wiseSaying1 = findById(id);
                    if (wiseSaying1 == null) {
                        System.out.printf("%d번 명언은 존재하지 않습니다!\n", id);
                        continue;
                    }

                    wiseSayingList.remove(wiseSaying1);
                    System.out.printf("%d번 명언이 삭제되었습니다!\n", id);
                    break;
                case "종료" :
                    break outer;
            }
        }

    }
    private WiseSaying findById(int id){
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }



}
