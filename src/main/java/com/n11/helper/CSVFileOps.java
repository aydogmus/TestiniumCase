package com.n11.helper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVFileOps {
    private static final String COMMA_DELIMITER = ",";
    String path;
    List<List<String>> records = new ArrayList<>();


    public String getEmail() {
        return this.records.get(1).get(0);
    }

    public String getPassword() {
        return this.records.get(1).get(1);
    }

    public void setPath(String _path) {
        this.path = _path;
    }

    public String getPath() {
        return path;
    }

    public CSVFileOps(String _path) {
        setPath(_path);
    }

    public void readFile() {
        try (Scanner scanner = new Scanner(new File(getPath()))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}
