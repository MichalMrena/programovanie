package org.edupage.ssosza;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.*;

public class HlavneOkno {

    private final JFrame okno;
    private JComboBox<String> okresSelect;
    private final ISpravcaObci spravcaObci;
    private final ObceTableModel tableModel;

    public HlavneOkno(ISpravcaObci spravcaObci) {
        this.spravcaObci = spravcaObci;
        this.tableModel = new ObceTableModel(List.of(
                new Obec("asd", "xxx", List.of(
                        new ZaznamOPopulacii(2021, 1012),
                        new ZaznamOPopulacii(2022, 1034)
                )),
                new Obec("zsq", "xxx", List.of(
                        new ZaznamOPopulacii(2021, 3233),
                        new ZaznamOPopulacii(2022, 2965)
                ))
                )
        );

        JPanel northPanel = this.vytvorNorthPanel();
        JPanel centerPanel = this.vytvorCenterPanel();

        this.zobrazObce();

        this.okno = new JFrame("Obce");
        this.okno.getContentPane().setLayout(new BorderLayout());
        this.okno.getContentPane().add(northPanel, BorderLayout.NORTH);
        this.okno.getContentPane().add(centerPanel, BorderLayout.CENTER);
        this.okno.setPreferredSize(new Dimension(600, 400));
        this.okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }

    private JPanel vytvorNorthPanel() {
        JPanel panel = new JPanel();
        List<String> okresy = this.spravcaObci.getOkresy();
        String[] poleOkresov = okresy.toArray(new String[0]);
        JLabel label = new JLabel("Okres:");
        this.okresSelect = new JComboBox<>(poleOkresov);
        JButton button = new JButton("Zobraz");
        button.addActionListener(e -> this.zobrazObce());
        panel.add(label);
        panel.add(this.okresSelect);
        panel.add(button);
        return panel;
    }

    private JPanel vytvorCenterPanel() {
        JPanel panel = new JPanel();
        JTable table = new JTable(this.tableModel);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scrollPane);
        return panel;
    }

    private void zobrazObce() {
        String okres = (String)this.okresSelect.getSelectedItem();
        List<Obec> obce = this.spravcaObci.getObce(okres);
        this.tableModel.setObce(obce);
    }
}
