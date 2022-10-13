package DB;

import DB.domain.Hospital;
import DB.linereader.ReadLineContext;
import DB.parser.HospitalParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateHospitalCsv {
    private String filename;
    private ReadLineContext<Hospital> readLineContext;

    public CreateHospitalCsv(String filename) {
        this.filename = filename;
        this.readLineContext = new ReadLineContext<>(new HospitalParser(), false);
    }

    public void writeASqlFile(String newFilename) throws IOException {
        List<Hospital> hospitalList = readLineContext.readLine(filename);
        File file = new File(newFilename);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        writer.write(String.format("SELECT * FROM `Seoul-hospitals`.`seoul-hospital`;\nINSERT INTO `Seoul-hospitals`.`seoul-hospital`\n(`id`,`address`," +
                "`district`,`category`,`emergency_room`,`name`,`subdivision`)\nVALUES\n"));
        int cnt = 0;
        for (Hospital hospital : hospitalList) {
            if (cnt == hospitalList.size() - 1) {
                String str = String.format(
                        "('%s','%s','%s','%s','%s','%s'", hospital.getId(),hospital.getAddress(),hospital.getDistrict(),
                        hospital.getCategory(),hospital.getEmergencyRoom(),hospital.getName());
                writer.write(str);
                if (hospital.getSubdivision() == null) {
                    writer.write(String.format(",%s);\n",hospital.getSubdivision()));
                }else {
                    writer.write(String.format(",'%s');\n",hospital.getSubdivision()));
                }
                break;
            }
            String s = String.format(
                    "('%s','%s','%s','%s','%s','%s'", hospital.getId(),hospital.getAddress(),hospital.getDistrict(),
                    hospital.getCategory(),hospital.getEmergencyRoom(),hospital.getName());
            writer.write(s);

            if (hospital.getSubdivision() == null) {
                writer.write(String.format(",%s),\n",hospital.getSubdivision()));
            }else {
                writer.write(String.format(",'%s'),\n",hospital.getSubdivision()));
            }

            cnt++;
        }

        writer.close();
    }
}

