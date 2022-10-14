package DB.parser;

import DB.domain.Hospital;

import java.util.List;

public class HospitalParser implements ParseAccordingly<Hospital>{
    @Override
    public Hospital parse(String toParse) {
        toParse = toParse.replaceAll("\'", "");
        String[] info = toParse.split(",");
        return new Hospital(info[0], info[1], info[2], info[6], info[10], info[7]);
    }

    @Override
    public List<String> parse(List<String> toParseList) {
        return null;
    }

}
