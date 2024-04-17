package org.edupage.ssosza;

import javax.swing.*;
import java.io.IOException;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class Main {

    private static void testDatabaza() {
//        CsvDatabazaObci databazaObci = new CsvDatabazaObci();
//        List<Obec> obce = databazaObci.getObce();
//        for (Obec obec : databazaObci.getObce("Bánovce nad Bebravou")) {
//            System.out.println(obec);
//        }
//
//        List<String> okresy = databazaObci.getOkresy();
//
//        Collator coll = Collator.getInstance(
//                new Locale.Builder().setLanguage("sk").setRegion("SK").build()
//        );
//        coll.setStrength(Collator.PRIMARY);
//        okresy.sort(coll);
//
//        for (String okres : okresy) {
//            System.out.println(okres);
//        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        IDatabazaObci databazaObci = null;
        try {
            databazaObci = new CsvDatabazaObci();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE

            );
            JOptionPane.showMessageDialog(
                    null,
                    "Using dummy data.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE

            );
            databazaObci = new TestovaciaDatabazaObci();
        }
        HlavneOkno okno = new HlavneOkno(databazaObci);
    }
}