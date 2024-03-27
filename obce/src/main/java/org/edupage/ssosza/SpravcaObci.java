package org.edupage.ssosza;

import java.io.*;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class SpravcaObci implements ISpravcaObci {

    private final List<Obec> obce;

    public SpravcaObci() throws IOException {
        this.obce = new ArrayList<>();
        Iterable<CSVRecord> records = this.tryOpenFile();
        Iterator<CSVRecord> iterator = records.iterator();

        CSVRecord header = iterator.next();
        int[] years = this.parseYears(header);

        while (iterator.hasNext()) {
            CSVRecord record = iterator.next();
            this.obce.add(this.parseRecord(years, record));
        }
    }

    @Override
    public List<String> getOkresy() {
        return extractOkresy(this.obce); // TODO tradeoff talk
    }

    @Override
    public List<Obec> getObce() {
        return this.obce;
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

    private Iterable<CSVRecord> tryOpenFile() throws IOException {
        InputStream input = SpravcaObci.class.getResourceAsStream("/obce-data.csv");
        if (input == null) {
            throw new IOException("Missing data file!");
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        CSVFormat parser = CSVFormat.DEFAULT.builder().setDelimiter(';').build();
        return parser.parse(in);
    }

    private Obec parseRecord(int[] years, CSVRecord record) {
        String okres = record.get(0).startsWith("Okres") ? record.get(0).substring(6) : record.get(0);
        String nazov = record.get(1);
        List<ZaznamOPopulacii> zaznamy = new ArrayList<>();
        for (int i = 2; i < record.size(); i++) {
            // TODO Task: vyhodenie vynimky s cislom riadku
            zaznamy.add(new ZaznamOPopulacii(years[i - 2], Integer.parseInt(record.get(i))));
        }
        return new Obec(nazov, okres, zaznamy);
    }

    private int[] parseYears(CSVRecord record) {
        int[] years = new int[record.size() - 2];
        for (int i = 2; i < record.size(); i++) {
            years[i - 2] = Integer.parseInt(record.get(i));
        }
        return years;
    }

    private static List<String> extractOkresy(List<Obec> obce) {
        Set<String> okresy = new HashSet<>();
        for (Obec obec : obce) {
            okresy.add(obec.getOkres());
        }
        return new ArrayList<>(okresy);
    }
}
