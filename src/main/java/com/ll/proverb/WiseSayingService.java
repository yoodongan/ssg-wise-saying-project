package com.ll.proverb;


public class WiseSayingService {


    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {

        wiseSayingRepository = new WiseSayingRepository();
    }
    public WiseSaying write(String content, String author) {
        return wiseSayingRepository.add(content, author);
    }
    public void list() {
        wiseSayingRepository.list();
    }

    public WiseSaying findById(int id){
        return  wiseSayingRepository.findById(id);
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingRepository.remove(wiseSaying);

    }
    public void modify(int id, String content, String author) {

        wiseSayingRepository.modify(id, content, author);
    }
}
