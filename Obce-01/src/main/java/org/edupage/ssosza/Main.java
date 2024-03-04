package org.edupage.ssosza;

import javax.swing.*;
import java.awt.*;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class Main {

    private void databazaTest() {
        DatabazaObci databazaObci = new DatabazaObci();

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

        JFrame okno = new JFrame("Databaza obci");


        JButton tlactiko = new JButton("Do it!");
        tlactiko.setPreferredSize(new Dimension(100, 35));
        okno.getContentPane().setLayout(new BorderLayout());

        JLabel label = new JLabel("Okresy:");
        okno.getContentPane().add(label, BorderLayout.NORTH);

        okno.getContentPane().add(tlactiko, BorderLayout.NORTH);


        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.setPreferredSize(new Dimension(800, 600));
        okno.pack();
        okno.setVisible(true);
    }
}