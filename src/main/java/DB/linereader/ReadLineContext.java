package DB.linereader;

import DB.parser.ParseAccordingly;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadLineContext<T> {
    private List<T> list;
    private ParseAccordingly<T> parser;
    private boolean notNeedColumnLine = true;
    public ReadLineContext(ParseAccordingly<T> parser) {
        this.list = new ArrayList<>();
        this.parser = parser;
    }

    public ReadLineContext(ParseAccordingly<T> parser, boolean notNeedColumnLine) {
        this.list = new ArrayList<>();
        this.parser = parser;
        this.notNeedColumnLine = notNeedColumnLine;
    }

    public List<T> readLine(String filename) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
            String str;
            if (notNeedColumnLine) reader.readLine();
            while ((str = reader.readLine()) != null) {
                list.add(parser.parse(str));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.list;
    }
}

