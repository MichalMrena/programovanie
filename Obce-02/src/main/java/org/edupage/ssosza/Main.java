package org.edupage.ssosza;

import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class Main {

    private static void testDatabaza() {
        CsvDatabazaObci databazaObci = new CsvDatabazaObci();
        List<Obec> obce = databazaObci.getObce();
        for (Obec obec : databazaObci.getObce("Bánovce nad Bebravou")) {
            System.out.println(obec);
        }

        List<String> okresy = databazaObci.getOkresy();

        Collator coll = Collator.getInstance(
                new Locale.Builder().setLanguage("sk").setRegion("SK").build()
        );
        coll.setStrength(Collator.PRIMARY);
        okresy.sort(coll);

        for (String okres : okresy) {
            System.out.println(okres);
        }
    }

    public static void main(String[] args) {

        IDatabazaObci databazaObci = new CsvDatabazaObci();
//        IDatabazaObci databazaObci = new TestovaciaDatabazaObci();
        HlavneOkno okno = new HlavneOkno(databazaObci);

        System.out.println(HlavneOkno.class.getCanonicalName());

    }
}