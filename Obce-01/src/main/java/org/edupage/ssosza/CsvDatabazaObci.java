package org.edupage.ssosza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CsvDatabazaObci implements IDatabazaObci {

    private final List<Obec> obce;
    private final Map<String, List<Obec>> okresToObec;

    public CsvDatabazaObci() {
        this.obce = new ArrayList<>();
        this.okresToObec = new HashMap<>(); // TODO neskor

        InputStream input = CsvDatabazaObci.class.getResourceAsStream("/obce-data.csv");
        BufferedReader in = new BufferedReader(new InputStreamReader(input));

        // Parser na citanie CSV suboru
        CSVFormat parser = CSVFormat.DEFAULT.builder()
                .setDelimiter(';')
                .setTrim(true)
                .setSkipHeaderRecord(false)
                .build();

        try {

            Iterable<CSVRecord> zaznamy = parser.parse(in);

            Iterator<CSVRecord> iterator = zaznamy.iterator();
            CSVRecord hlavicka = iterator.next();
            while (iterator.hasNext()) {
                CSVRecord record = iterator.next();
                String okres = record.get(0).substring(6);
                String nazov = record.get(1);

                List<Integer> populacie = new ArrayList<>();
                for (int i = 2; i < record.size(); i++) {
                    String populaciaStr = record.get(i);
                    int populacia = Integer.parseInt(populaciaStr);
                    populacie.add(populacia);
                }

                Obec obec = new Obec(nazov, okres, populacie);
                this.obce.add(obec);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV file!");
        }
    }

    @Override
    public List<Obec> getObce() {
        return Collections.unmodifiableList(this.obce);
    }

    @Override
    public List<Obec> getObce(String okres) {
        List<Obec> okresneObce = new ArrayList<>();
        for (Obec obec : this.obce) {
            if (obec.getOkres().equals(okres)) {
                okresneObce.add(obec);
            }
        }
        return okresneObce;
    }

    @Override
    public List<String> getOkresy() {
//        List<String> okresy = new ArrayList<>();
//        for (Obec obec : this.obce) {
//            if (!okresy.contains(obec.getOkres())) {
//                okresy.add(obec.getOkres());
//            }
//        }
//        return okresy;

        Set<String> okresy = new TreeSet<>();
        for (Obec obec : this.obce) {
            okresy.add(obec.getOkres());
        }
        return new ArrayList<>(okresy);
    }
}
