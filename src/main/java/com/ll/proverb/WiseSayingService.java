package com.ll.proverb;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private int wiseSayingId;
    List<WiseSaying> wiseSayingList;

    public WiseSayingService() {
        wiseSayingId = 0;
        wiseSayingList = new ArrayList<>();
    }
    public WiseSaying write(String content, String author) {
        int id = ++wiseSayingId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }
    public void list() {
        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying1 = wiseSayingList.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying1.getId(), wiseSaying1.getContent(), wiseSaying1.getAuthor());
        }
    }

    public WiseSaying findById(int id){
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);

    }
    public void modify(int id, String content, String author) {
        WiseSaying wiseSaying = findById(id);
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }
}
