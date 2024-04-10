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
        this.okresyCombobox = new JComboBox<>(poleOkresov);
        northPanel.add(this.okresyCombobox);

        // Zobraz Button
        JButton buttonZobraz = new JButton("Zobraz obce");
        buttonZobraz.addActionListener(e -> {
            zobrazObce();
        });
        northPanel.add(buttonZobraz);
        panelOkno.add(northPanel, BorderLayout.NORTH);

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
        panelOkno.add(centerPanel, BorderLayout.CENTER);

        this.okno.setPreferredSize(new Dimension(800, 600));
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.pack();
        this.okno.setVisible(true);
    }

    private void zobrazObce() {
        this.model.zobrazObce(this.getVybranyOkres());
        this.model.fireTableDataChanged();
    }

    private String getVybranyOkres() {
        return (String) this.okresyCombobox.getSelectedItem();
    }
}
