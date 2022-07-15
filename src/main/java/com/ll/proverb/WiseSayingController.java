package com.ll.proverb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private int wiseSayingId;
    private Scanner sc;
    List<WiseSaying> wiseSayingList;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingId = 0;
        wiseSayingList = new ArrayList<>();
    }

    public void write(Rq rq) {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();
        wiseSayingId++;
        WiseSaying wiseSaying = new WiseSaying(wiseSayingId, content, author);
        wiseSayingList.add(wiseSaying);
        System.out.printf("%d번 명언이 등록되었습니다!\n", wiseSayingId);
    }
    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------------");
        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying1 = wiseSayingList.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying1.getId(), wiseSaying1.getContent(), wiseSaying1.getAuthor());
        }
    }
    public void remove(Rq rq) {
        int id = rq.getIntParam("id", 0);
        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }
        WiseSaying wiseSaying1 = findById(id);
        if (wiseSaying1 == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다!\n", id);
            return;
        }

        wiseSayingList.remove(wiseSaying1);
        System.out.printf("%d번 명언이 삭제되었습니다!\n", id);
    }

    public void modify(Rq rq) {
        int id_2 = rq.getIntParam("id", 0);
        if (id_2 == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }
        WiseSaying wiseSaying2 = findById(id_2);
        if (wiseSaying2 == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다!\n", id_2);
            return;
        }
        System.out.printf("명언(기존) : %s\n", wiseSaying2.getContent());
        System.out.print("명언 : ");
        String content_2 = sc.nextLine();

        System.out.printf("작가(기존) : %s\n", wiseSaying2.getAuthor());
        System.out.print("작가 : ");
        String author_2 = sc.nextLine();

        wiseSaying2.setContent(content_2);
        wiseSaying2.setAuthor(author_2);

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
