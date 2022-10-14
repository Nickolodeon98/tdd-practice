package DB;

import DB.domain.Hospital;
import DB.parser.HospitalParser;
import refactor_practice.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HospitalParserTest {
    HospitalParser hospitalParser = new HospitalParser();
    String line1 = "A1120837,서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동),C,의원,G099,응급의료기관 이외,2,외과: 상시진료 내과는 당분간 휴진,서울시 송파구 문정동 장지동 법조단지 위례 가락동 가락시장역 위치 삼성서울병원 외래교수 출신 구강외과 전문의 진료 진료과목 - 임플란트 치조골 뼈이식 수술 매복 사랑니 발치 턱관절 악관절 질환의 치료 교정 치료 및 기타 보존 보철(크라운 브릿지 인레이) 신경치료,방이역 1번출구 바로옆 굿모닝 신한증권 뒷건물,가산기대찬의원,02-6267-2580,02-920-5374,1930,1930,1930,1930,1930,1500,1500,1500,900,900,900,900,900,900,1000,1000,85,11,126.8841225,37.4803938,2022-04-07 14:55";
    String line2 = "A1104130,서울특별시 강남구 도산대로 118 (논현동 신사빌딩 2층),C,의원,G099,응급의료기관 이외,2,비만클리닉,365일 진료 국민건강보험공단 검진 지정병원 점심시간 13~14시,신사역 1번 출구 인근,365엠씨의원,02-516-3650,02-920-5374,2000,2000,1900,2000,2000,1600,1400,1400,1100,1100,1100,1100,1100,1100,900,900,60,38,127.0218085,37.5166042,2021-06-07 14:54";
    String line3 = "B1100027,서울특별시 강남구 봉은사로 612 (삼성동),E,한방병원,G099,응급의료기관 이외,2,진료과목마다 진료시간 다릅니다. 전화 확인 후 방문해주세요.,,봉은사역 5번 출구 삼성1동주민센터 옆,(의)가산의료재단광동한방병원,02-2222-4888,,1800,1800,1800,1800,1800,1500,,,900,900,900,900,900,900,,,61,70,127.0621478,37.51427969,2022-09-07 14:55";

    private void assertHospital(Hospital hospital, String eId, String eAddress, String eDistrict, String eCategory, String eEmergencyRoom, String eName, String eSubdivision) {
        Assertions.assertEquals(eId, hospital.getId());
        //주소가 잘 파싱 되는지 테스트 추가
        Assertions.assertEquals(eAddress, hospital.getAddress());
        //District
        Assertions.assertEquals(eDistrict, hospital.getDistrict());
        //Category
        Assertions.assertEquals(eCategory, hospital.getCategory());
        //Emergency Room
        Assertions.assertEquals(eEmergencyRoom, hospital.getEmergencyRoom());
        //Name
        Assertions.assertEquals(eName, hospital.getName());
        // Subdivision
        Assertions.assertEquals(eSubdivision, hospital.getSubdivision());
    }

    @Test
    @DisplayName("파싱 작업")
    void hospitalParsing() {

        assertHospital(hospitalParser.parse(this.line1), "A1120837", "서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)", "서울특별시 금천구",
                "C", "2", "가산기대찬의원", null);
        assertHospital(hospitalParser.parse(this.line2), "A1104130", "서울특별시 강남구 도산대로 118 (논현동 신사빌딩 2층)", "서울특별시 강남구",
                "C", "2", "365엠씨의원", null);
        assertHospital(hospitalParser.parse(this.line3), "B1100027", "서울특별시 강남구 봉은사로 612 (삼성동)", "서울특별시 강남구",
                "E", "2", "(의)가산의료재단광동한방병원", "한방병원");
    }

//    @Test
//    @DisplayName("SQL 쿼리 생성")
//    void makeSQLQueryTest() {
//        HospitalParser hospitalParser = new HospitalParser();
//        Hospital hospital = hospitalParser.parse(this.line1);
//
//        CreateHospitalCsv createHospitalCsv = new CreateHospitalCsv();
//
//        Assertions.assertEquals("SELECT * FROM `Seoul-hospitals`.`seoul-hospital`;\nINSERT INTO `Seoul-hospitals`.`seoul-hospital`\n(`id`,`address`," +
//                "`district`,`category`,`emergency_room`,`name`,`subdivision`)\nVALUES\n('A1120837','서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)'" +
//                        ",'서울특별시 금천구','C','2','가산기대찬의원',null);\n",createHospitalCsv.createSqlQuery(hospital));
//
//
//    }

//    @Test
//    @DisplayName("테스트 케이스")
//

//    @Test
//    @DisplayName("SQL 쿼리")
//    void sqlQueryTest() {
//        HospitalParser hospitalParser = new HospitalParser();
//        Hospital hospital = hospitalParser.parse(this.line1);
//        Main main = new Main();
//
//        String s = "INSERT INTO `likeLion-db`.`seoul_hospital` (`id`,`address`," +
//                "`district`,`category`,`emergency_room`,`name`,`subdivision`) VALUES\n";
//        String y = ",  (\"A1120837\",\"서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)\"" +
//                ",\"서울특별시 금천구\",\"C\",\"2\",\"가산기대찬의원\",\"null\"),\n, ;";
//
//        List<String> sList = new ArrayList<>();
//        sList.add(s);
//        sList.add(y);
//
//        List<Hospital> list = new ArrayList<>();
//        list.add(hospital);
//        Assertions.assertEquals(sList.get(0), main.outsider(list).get(0));
//    }
}