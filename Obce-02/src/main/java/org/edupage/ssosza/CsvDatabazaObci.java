package org.edupage.ssosza;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class CsvDatabazaObci implements IDatabazaObci {

    private final List<Obec> obce;
    private final Map<String, Range> okresToRange;

    // private Map<String, List<Obec>> okresToObec;

    public CsvDatabazaObci() throws IOException {
        this.obce = new ArrayList<>();
        this.okresToRange = new HashMap<>();

        InputStream input = CsvDatabazaObci.class.getResourceAsStream("/data-obce.csv");
        if (input == null) {
            throw new IOException("Missing data file!");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        CSVFormat parser = CSVFormat.DEFAULT.builder()
                .setDelimiter(';')
                .setSkipHeaderRecord(true)
                .build();
        Iterable<CSVRecord> zaznamy = parser.parse(in);
        Iterator<CSVRecord> iterator = zaznamy.iterator();
        int cisloRiadku = 1;
        CSVRecord hlavicka = iterator.next();
        while (iterator.hasNext()) {
            CSVRecord record = iterator.next();
            ++cisloRiadku;
            Obec obec;
            try {
                obec = parseObec(record, cisloRiadku);
                this.obce.add(obec);
            } catch (ObecCsvFormatException e) {
                System.err.println(e.getMessage());
            }
            parseObecOpt(record, cisloRiadku).ifPresentOrElse(
                    this.obce::add,
                    () -> System.out.println("Failed to parse obec")
            );
        }
    }

    private static Obec parseObec(CSVRecord record, int cisloRiadku) throws ObecCsvFormatException {
        String okres = record.get(0).substring(6);
        String nazov = record.get(1);
        List<Integer> populacie = new ArrayList<>();
        for (int i = 2; i < record.size(); i++) {
            String populaciaStr = record.get(i);
            try {
                int populacia = Integer.parseInt(populaciaStr);
                populacie.add(populacia);
            } catch (NumberFormatException e) {
                throw new ObecCsvFormatException(cisloRiadku, i + 1, populaciaStr);
            }
        }
        return new Obec(okres, nazov, populacie);
    }

    private static Optional<Obec> parseObecOpt(CSVRecord record, int cisloRiadku) {
        String okres = record.get(0).substring(6);
        String nazov = record.get(1);
        List<Integer> populacie = new ArrayList<>();
        for (int i = 2; i < record.size(); i++) {
            String populaciaStr = record.get(i);
            try {
                int populacia = Integer.parseInt(populaciaStr);
                populacie.add(populacia);
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        }
        return Optional.of(new Obec(okres, nazov, populacie));
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
        Set<String> okresy = new TreeSet<>();
        for (Obec obec : this.obce) {
            okresy.add(obec.getOkres());
        }
        return new ArrayList<>(okresy);
    }
}
