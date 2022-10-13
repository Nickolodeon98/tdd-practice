package DB;

import DB.CreateHospitalCsv;

import java.io.IOException;

public class CreateHospitalCsvMain {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\LikeLion\\2022.10\\221011\\서울시 병의원 위치 정보.csv";
        CreateHospitalCsv createHospitalCsv = new CreateHospitalCsv(filename);

        createHospitalCsv.writeASqlFile("./testScript.sql");
    }
}
