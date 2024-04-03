package org.edupage.ssosza;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HlavneOkno {

    private final JFrame okno;
    private IDatabazaObci databaza;
    private ObceTableModel model;

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
        JComboBox<String> okresyCombobox = new JComboBox<>(poleOkresov);
        northPanel.add(okresyCombobox);

        // Zobraz Button
        JButton buttonZobraz = new JButton("Zobraz obce");
        buttonZobraz.addActionListener(e -> {
            zobrazObce();
        });
        northPanel.add(buttonZobraz);
        panelOkno.add(northPanel, BorderLayout.NORTH);

        this.model.zobrazObce((String)okresyCombobox.getSelectedItem());
        panelOkno.add(new JTable(this.model), BorderLayout.CENTER);

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
