package refactor_practice;

import DB.domain.Hospital;
import DB.linereader.ReadLineContext;
import DB.parser.HospitalParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<String> outsider(List<Hospital> hospitals) {
        List<String> data = new ArrayList<>();
        data.add("INSERT INTO `likeLion-db`.`seoul_hospital` (`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`) VALUES\n");
        for (Hospital h : hospitals) {
            String s = String.format(" (\"%s\",\"%s\",\"%s\",\"%s\",\"%d\",\"%s\",\"%s\"),\n",
                    h.getId(),h.getAddress(),h.getDistrict(), h.getCategory(), Integer.parseInt(h.getEmergencyRoom()), h.getName(), h.getSubdivision());
            data.add(s);
        }
        data.add(";");
        return data;
    }


    public static void main(String[] args) throws IOException {
        //input, output 파일경로
        String inputFileName = "C:\\LikeLion\\2022.10\\221011\\서울시 병의원 위치 정보.csv";
        String outputFileName = "./hospitalData.sql";

        //parser
        ReadLineContext<Hospital> hospitalLineReader = new ReadLineContext<>(new HospitalParser());
        List<Hospital> hospitalLists = hospitalLineReader.readLine(inputFileName);

        //파일 저장
//        FileWrite fw = new FileWrite(datas, outputFileNmae);
//        fw.write();

    }
}