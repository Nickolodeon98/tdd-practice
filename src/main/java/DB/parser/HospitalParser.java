package DB.parser;

import DB.domain.Hospital;

public class HospitalParser implements ParseAccordingly<Hospital>{

    @Override
    public Hospital parse(String toParse) {
        String[] info = toParse.split(",");
        return new Hospital(info[0], info[1], info[3], info[4], info[5]);
    }

}
