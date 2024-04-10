package org.edupage.ssosza;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HlavneOkno {

    private final JFrame okno;
    private final IDatabazaObci databaza;
    private final ObceTableModel model;

    private final JComboBox<String> okresyCombobox;

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
        this.okresyCombobox = new JComboBox<>(poleOkresov);
        northPanel.add(this.okresyCombobox);

        // zobraz obce button
        JButton zobrazObceButton = new JButton("Zobraz obce");
        zobrazObceButton.addActionListener(e -> {
            this.zobrazObce();
        });
        northPanel.add(zobrazObceButton);
        panelOkna.add(northPanel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel();
        this.model.zobrazObce(this.getVybranyOkres());
        JTable table = new JTable(this.model);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(
                table,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        centerPanel.add(scrollPane);
        panelOkna.add(centerPanel, BorderLayout.CENTER);

        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.setPreferredSize(new Dimension(800, 600));
        this.okno.pack();
        this.okno.setVisible(true);
    }

    private String getVybranyOkres() {
        return (String)this.okresyCombobox.getSelectedItem();
    }

    private void zobrazObce() {
        String okres = this.getVybranyOkres();
        this.model.zobrazObce(okres);
        this.model.fireTableDataChanged();
    }
}

