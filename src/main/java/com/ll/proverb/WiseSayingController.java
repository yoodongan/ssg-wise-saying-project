package com.ll.proverb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private Scanner sc;
    WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public void write(Rq rq) {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.printf("%d번 명언이 등록되었습니다!\n", wiseSaying.getId());
    }
    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------------");
        wiseSayingService.list();
    }
    public void remove(Rq rq) {
        int id = rq.getIntParam("id", 0);
        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }
        WiseSaying wiseSaying1 = wiseSayingService.findById(id);
        if (wiseSaying1 == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다!\n", id);
            return;
        }
        wiseSayingService.remove(wiseSaying1);
        System.out.printf("%d번 명언이 삭제되었습니다!\n", id);
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id", 0);
        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }
        WiseSaying wiseSaying = wiseSayingService.findById(id);
        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다!\n", id);
            return;
        }
        System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modify(id, content, author);

    }






}
