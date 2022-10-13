package DB.parser;

import DB.domain.Hospital;

public class HospitalParser implements ParseAccordingly<Hospital>{

    private String replaceAllQuot(String str) {
        return str.replaceAll("\'", "");
    }

    @Override
    public Hospital parse(String toParse) {
        String[] info = toParse.split(",");
        return new Hospital(replaceAllQuot(info[0]), replaceAllQuot(info[1]), replaceAllQuot(info[3]), replaceAllQuot(info[4]), replaceAllQuot(info[5]));
    }

}
