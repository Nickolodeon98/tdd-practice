package DB;

import DB.domain.Hospital;
import DB.linereader.ReadLineContext;
import DB.linewriter.WriteContext;
import DB.parser.HospitalParser;
import DB.parser.SqlParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateHospitalCsv {
    private String filename;
    private ReadLineContext<Hospital> readLineContext;
    WriteContext<String> writeContext;

    public CreateHospitalCsv(String filename) {
        this.filename = filename;
        this.readLineContext = new ReadLineContext<>(new HospitalParser(), false);
        this.writeContext = new WriteContext<>(new SqlParser());
    }
    public CreateHospitalCsv() {
    }
//    public String createSqlQuery(Hospital hospital) {
//        String sql = String.format("SELECT * FROM `Seoul-hospitals`.`seoul-hospital`;\nINSERT INTO `Seoul-hospitals`.`seoul-hospital`\n(`id`,`address`," +
//                "`district`,`category`,`emergency_room`,`name`,`subdivision`)\nVALUES\n");
//        sql = String.join("", sql, String.format(
//                "('%s','%s','%s','%s','%s','%s'", hospital.getId(),hospital.getAddress(),hospital.getDistrict(),
//                hospital.getCategory(),hospital.getEmergencyRoom(),hospital.getName()));
//
//        if (hospital.getSubdivision() == null) {
//            sql = String.join("", sql, String.format(",%s);\n",hospital.getSubdivision()));
//        }else {
//            sql = String.join("", sql, String.format(",%s);\n",hospital.getSubdivision()));
//        }
//
//        return sql;
//    }
    public void writeASqlFile(String newFilename) throws IOException {
        List<Hospital> hospitalList = readLineContext.readLine(filename);

        writeContext.writeSqlQuery(newFilename, hospitalList);
//        File file = new File(newFilename);
//        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//
//        writer.write(String.format("SELECT * FROM `Seoul-hospitals`.`seoul-hospital`;\nINSERT INTO `Seoul-hospitals`.`seoul-hospital`\n(`id`,`address`," +
//                "`district`,`category`,`emergency_room`,`name`,`subdivision`)\nVALUES\n"));
//        int count = 0;
//        for (Hospital hospital : hospitalList) {
//            if (count == hospitalList.size() - 1) {
//                String str = String.format(
//                        "('%s','%s','%s','%s','%s','%s'", hospital.getId(),hospital.getAddress(),hospital.getDistrict(),
//                        hospital.getCategory(),hospital.getEmergencyRoom(),hospital.getName());
//                writer.write(str);
//                if (hospital.getSubdivision() == null) {
//                    writer.write(String.format(",%s);\n",hospital.getSubdivision()));
//                }else {
//                    writer.write(String.format(",'%s');\n",hospital.getSubdivision()));
//                }
//                break;
//            }
//            String s = String.format(
//                    "('%s','%s','%s','%s','%s','%s'", hospital.getId(),hospital.getAddress(),hospital.getDistrict(),
//                    hospital.getCategory(),hospital.getEmergencyRoom(),hospital.getName());
//            writer.write(s);
//
//            if (hospital.getSubdivision() == null) {
//                writer.write(String.format(",%s),\n",hospital.getSubdivision()));
//            }else {
//                writer.write(String.format(",'%s'),\n",hospital.getSubdivision()));
//            }
//
//            count++;
//        }
//
//        writer.close();
    }
}

