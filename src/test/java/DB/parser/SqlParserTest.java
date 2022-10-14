package DB.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SqlParserTest {
    List<String> list = new ArrayList<>();
    SqlParser sqlParser = new SqlParser();

    @Test
    @DisplayName("파싱 확인")
    void makeSqlQueryTest() {
        String s = String.format("%s,%s,%s,%s,%s,%s,%s", "A1120837", "서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)", "서울특별시 금천구",
                "C", "2", "가산기대찬의원", "내과");
        list.add(s);
        String expected = "SELECT * FROM `Seoul-hospitals`.`seoul-hospital`;\n" +
                "INSERT INTO `Seoul-hospitals`.`seoul-hospital`\n" +
                "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n" +
                "VALUES\n" +
                "('A1120837','서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)','서울특별시 금천구','C','2','가산기대찬의원','내과');\n";
        Assertions.assertEquals(expected, String.join("", sqlParser.parse(list).get(0), sqlParser.parse(list).get(1)));
    }
}