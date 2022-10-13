package DB;

import DB.domain.Hospital;
import DB.parser.HospitalParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospitalParserTest {
    String str = "'A1120837',서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동),서울특별시 금천구,C,2,가산기대찬의원,null";

    @Test
    @DisplayName("파싱 작업")
    void hospitalParsing() {
        HospitalParser hospitalParser = new HospitalParser();

        Hospital hospital = hospitalParser.parse(str);
        Assertions.assertEquals("A1120837", hospital.getId());
        Assertions.assertEquals("서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)", hospital.getAddress());
    }
}