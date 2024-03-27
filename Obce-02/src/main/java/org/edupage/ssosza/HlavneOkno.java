package org.edupage.ssosza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class HlavneOkno {

    private final JFrame okno;
    private IDatabazaObci databaza;

    public HlavneOkno(IDatabazaObci databaza) {
        this.databaza = databaza;

        this.okno = new JFrame("Databaza obci");
        Container panelOkno = this.okno.getContentPane();
        panelOkno.setLayout(new BorderLayout());

        // North Panel
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());

        // Okresy: Label
        northPanel.add(new JLabel("Okresy:"));

        // Okresy ComboBox
        List<String> okresy = this.databaza.getOkresy();
        String[] poleOkresov = okresy.toArray(new String[0]);
        northPanel.add(new JComboBox<>(poleOkresov));

        // Zobraz Button
        JButton buttonZobraz = new JButton("Zobraz obce");
        buttonZobraz.addActionListener(e -> {
            zobrazObce();
        });
        northPanel.add(buttonZobraz);
        panelOkno.add(northPanel, BorderLayout.NORTH);

        this.okno.setPreferredSize(new Dimension(800, 600));
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.pack();
        this.okno.setVisible(true);
    }

    private void zobrazObce() {
        // TODO ...
        System.out.println("fungujem, zobrazujem, ...");
    }
}
