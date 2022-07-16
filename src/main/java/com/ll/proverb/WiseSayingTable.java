package com.ll.proverb;

public class WiseSayingTable {
    private String baseDir;

    public WiseSayingTable(String baseDir) {
        this.baseDir = baseDir;
    }
    public void save(WiseSaying wiseSaying) {
        Util.file.mkdir("%s/wise_saying".formatted(baseDir));
        String body = "내용";
        Util.file.saveToFile("%s/wise_saying/%d.json".formatted(baseDir, wiseSaying.getId()), body);
    }
    public void save(String content, String author) {
        int id = getLastId() + 1;  // save 할 때마다, id 1 증가.
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        save(wiseSaying);
        saveId(id);

    }

    private void saveId(int id) {
        Util.file.saveToFile("%s/wise_saying/saveId.txt".formatted(baseDir), id + "");
    }

    private int getLastId() {
        String id = Util.file.readFromFile("%s/wise_saying/saveId.txt".formatted(baseDir), "");
        if (id.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(id);
    }
}