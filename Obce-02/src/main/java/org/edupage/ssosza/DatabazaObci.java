package org.edupage.ssosza;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DatabazaObci {

    public DatabazaObci() {

        InputStream input = DatabazaObci.class.getResourceAsStream("/data-obce.csv");
        if (input == null) {
            throw new RuntimeException("Missing data file!");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        CSVFormat parser = CSVFormat.DEFAULT.builder()
                .setDelimiter(';')
                .setSkipHeaderRecord(true)
                .build();
        try {

            Iterable<CSVRecord> zaznamy = parser.parse(in);
            for (CSVRecord record : zaznamy) {
                String okres = record.get(0).substring(6);
                String nazov = record.get(1);
                System.out.format("%s\t%s%n", okres, nazov);
            }


        } catch (IOException e) {
            throw new RuntimeException("Failed to read data file!");
        }
    }

}
