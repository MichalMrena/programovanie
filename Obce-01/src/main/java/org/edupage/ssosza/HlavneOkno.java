package org.edupage.ssosza;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HlavneOkno {

    private final JFrame okno;
    private final IDatabazaObci databaza;
    private final ObceTableModel model;

    public HlavneOkno(IDatabazaObci databaza) {
        this.databaza = databaza;
        this.model = new ObceTableModel(this.databaza);

        this.okno = new JFrame("Databaza obci");
        Container panelOkna = this.okno.getContentPane();
        panelOkna.setLayout(new BorderLayout());

        // North Panel
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());

        // okres label
        northPanel.add(new JLabel("Okresy:"));

        // okres combobox
        List<String> okresy = this.databaza.getOkresy();
        String[] poleOkresov = okresy.toArray(new String[0]);
        JComboBox<String> okresyCombobox = new JComboBox<>(poleOkresov);
        northPanel.add(okresyCombobox);

        // zobraz obce button
        JButton zobrazObceButton = new JButton("Zobraz obce");
        zobrazObceButton.addActionListener(e -> {
            this.zobrazOkresy();
        });
        northPanel.add(zobrazObceButton);
        panelOkna.add(northPanel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel();
        this.model.zobrazObce((String) okresyCombobox.getSelectedItem());
        JTable table = new JTable(this.model);
        centerPanel.add(table);
        panelOkna.add(centerPanel, BorderLayout.CENTER);

        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.setPreferredSize(new Dimension(800, 600));
        this.okno.pack();
        this.okno.setVisible(true);
    }

    private void zobrazOkresy() {
        // precitaj aktualny vyber
        // zobraz obce z daneho okresu
        System.out.println("fungujem!!!!");
    }
}

