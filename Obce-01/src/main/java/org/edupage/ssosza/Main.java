package org.edupage.ssosza;

import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class Main {

    private void databazaTest() {
        CsvDatabazaObci databazaObci = new CsvDatabazaObci();

        List<Obec> obce = databazaObci.getObce();
        for (Obec obec : obce) {
            System.out.println(obec);
        }

        System.out.println("---");

        List<String> okresy = databazaObci.getOkresy();
        Collator coll = Collator.getInstance(Locale.of("sk"));
        coll.setStrength(Collator.PRIMARY);
        okresy.sort(coll);
        for (String okres : okresy) {
            System.out.println(okres);
        }
    }

    public static void main(String[] args) {

        IDatabazaObci databaza = new CsvDatabazaObci();
//        IDatabazaObci databaza = new TestovaciaDatabazaObci();
        HlavneOkno okno = new HlavneOkno(databaza);
    }
}