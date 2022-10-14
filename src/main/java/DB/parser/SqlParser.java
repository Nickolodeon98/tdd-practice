package DB.parser;

import DB.domain.Hospital;

import java.util.ArrayList;
import java.util.List;

public class SqlParser implements ParseAccordingly<String>{

    @Override
    public String parse(String toParse) {
        return null;
    }
    @Override
    public List<String> parse(List<String> toParseList) {
        List<String> resultList = new ArrayList<>();
        int count = 0;

        String header = String.format("SELECT * FROM `Seoul-hospitals`.`seoul-hospital`;\nINSERT INTO `Seoul-hospitals`.`seoul-hospital`\n(`id`,`address`," +
                "`district`,`category`,`emergency_room`,`name`,`subdivision`)\nVALUES\n");

        resultList.add(header);

        for (String s : toParseList) {

            String[] keywords = s.split(",");
            String str = String.format(
                    "('%s','%s','%s','%s','%s','%s'", keywords[0], keywords[1], keywords[2],
                    keywords[3], keywords[4], keywords[5]);
            if (keywords[6].equals("null")) {
                str = String.join("", str, ",null)");
            }else {
                str = String.join("", str, String.format(",'%s')",keywords[6]));
            }
            count++;

            if (count == toParseList.size()) {
                str = String.join("",str, ";\n");
            } else str = String.join("",str, ",\n");

            resultList.add(str);
        }

        return resultList;
    }
}
