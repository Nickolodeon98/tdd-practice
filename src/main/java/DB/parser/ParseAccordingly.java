package DB.parser;

import java.util.List;

public interface ParseAccordingly<T> {
    T parse(String toParse);
    List<String> parse(List<String> toParseList);
}

