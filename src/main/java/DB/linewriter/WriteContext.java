package DB.linewriter;

import DB.domain.Hospital;
import DB.parser.ParseAccordingly;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class WriteContext<T> {
    ParseAccordingly<T> parser;
    String filename;
    List<Hospital> keywords;

    public WriteContext(ParseAccordingly<T> parser) {
        this.parser = parser;
    }

    public void writeSqlQuery(String filename, List<Hospital> keywords) {
        this.filename = filename;
        this.keywords = keywords;
        List<String> list = new ArrayList<>();
        List<String> parseCompleteList;
        try {
            File file = new File(filename);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(file.toPath()), StandardCharsets.UTF_8));


            for (Hospital keyword : keywords) {
                String s = String.format("%s,%s,%s,%s,%s,%s,%s", keyword.getId(), keyword.getAddress(), keyword.getDistrict(),keyword.getCategory(),
                        keyword.getEmergencyRoom(), keyword.getName(), keyword.getSubdivision());
                list.add(s);
            }

            parseCompleteList = parser.parse(list);

            for (String t : parseCompleteList) {
                bw.write(t);
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
