import com.ll.proverb.Util;
import com.ll.proverb.WiseSaying;
import com.ll.proverb.WiseSayingTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WiseSayingTableTest {
    private WiseSayingTable wiseSayingTable;

    public WiseSayingTableTest() {
        wiseSayingTable = new WiseSayingTable("test_data");   // 테스트 코드에 WiseSayingTable 을 가져온다. (test_data디렉토리를 계속 만들어야 하므로.)
    }
    @BeforeEach
    public void beforeEach() {
        Util.file.deleteDir("test_data");
        wiseSayingTable.save("진짜 문제는 사람들의 마음이다. 그것은 절대로 물리학이나 윤리학의 문제가 아니다", "아인슈타인");
        wiseSayingTable.save("나는 생각한다. 고로 나는 존재한다.", "데카르트");
    }

    @Test
    public void 등록을_하면_명언과_작가를_물어본다() {
        WiseSayingTable wiseSayingTable = new WiseSayingTable("test_data");
        WiseSaying wiseSaying = new WiseSaying(1, "진짜 문제는 사람들의 마음이다. 그것은 절대로 물리학이나 윤리학의 문제가 아니다", "아인슈타인");
        wiseSayingTable.save(wiseSaying);

        assertTrue(new File("test_data/wise_saying/1.json").exists());
    }
    @Test
    public void 저장_id_자동증가() {  // 객체 저장 시,  id 자동 증가하는 기능 테스트.
        WiseSayingTable wiseSayingTable = new WiseSayingTable("test_data");

        wiseSayingTable.save("진짜 문제는 사람들의 마음이다. 그것은 절대로 물리학이나 윤리학의 문제가 아니다", "아인슈타인");
        assertTrue(new File("test_data/wise_saying/1.json").exists());
        wiseSayingTable.save("나는 생각한다. 고로 나는 존재한다.", "데카르트");
        assertTrue(new File("test_data/wise_saying/2.json").exists());
    }
    @Test
    public void 저장() {
        int id = wiseSayingTable.getLastId(1);
        wiseSayingTable.save("진짜 문제는 사람들의 마음이다. 그것은 절대로 물리학이나 윤리학의 문제가 아니다", "아인슈타인");

        assertTrue(new File("test_data/wise_saying/%d.json".formatted(id)).exists());
    }

    @Test
    public void 조회() {  // 객체 조회 기능 테스트.
        WiseSaying wiseSaying = wiseSayingTable.findById(1);
        assertEquals(1, wiseSaying.getId());
        assertEquals("진짜 문제는 사람들의 마음이다. 그것은 절대로 물리학이나 윤리학의 문제가 아니다", wiseSaying.getContent());
        assertEquals("아인슈타인", wiseSaying.getAuthor());

    }
    @Test
    public void 삭제() {  // 객체 삭제 기능 테스트.
        wiseSayingTable.removeById(1);
        WiseSaying wiseSaying = wiseSayingTable.findById(1);
        assertEquals(null, wiseSaying);  // null 이면 테스트 통과.
    }







}