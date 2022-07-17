package com.ll.proverb;

import java.io.File;
import java.util.Map;

public class WiseSayingTable {
    private String baseDir;

    public WiseSayingTable(String baseDir) {
        this.baseDir = baseDir;
    }
    public void save(WiseSaying wiseSaying) {
        Util.file.mkdir("%s/wise_saying".formatted(baseDir));
        String body = wiseSaying.toJSON();
        Util.file.saveToFile("%s/wise_saying/%d.json".formatted(baseDir, wiseSaying.getId()), body);
    }

    public void save(String content, String author) {
        int id = getLastId(1) + 1;  // save 할 때마다, id 1 증가.
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        save(wiseSaying);
        saveId(id);

    }

    public void saveId(int id) {
        Util.file.saveToFile("%s/wise_saying/saveId.txt".formatted(baseDir), id + "");
    }

    public int getLastId(int i) {
        String id = Util.file.readFromFile("%s/wise_saying/saveId.txt".formatted(baseDir), "");
        if (id.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(id);
    }

    public WiseSaying findById(int id) {
        String path = "%s/wise_saying/%d.json".formatted(baseDir, id);

        if (new File(path).exists() == false) {
            return null;
        }
        Map<String, Object> map = Util.json.jsonToMapFromFile(path);

        if (map == null) {
            return null;
        }
        return new WiseSaying((int) map.get("id"), (String) map.get("content"), (String) map.get("author"));
    }


    public void removeById(int id) {
        String removePath = "%s/wise_saying/%d.json".formatted(baseDir, id);
        new File(removePath).delete();

    }
}