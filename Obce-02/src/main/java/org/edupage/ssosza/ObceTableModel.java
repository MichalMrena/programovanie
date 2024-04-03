package org.edupage.ssosza;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ObceTableModel extends AbstractTableModel {

    private IDatabazaObci databaza;
    private List<Obec> zobrazene;

    public ObceTableModel(IDatabazaObci databaza) {
        this.databaza = databaza;
        this.zobrazene = null;
    }

    public void zobrazObce(String okres) {
        this.zobrazene = this.databaza.getObce(okres);
    }

    @Override
    public int getRowCount() {
        return this.zobrazene.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Obec obec = this.zobrazene.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> obec.getNazov();
            case 1 -> obec.getPopulacia().get(0);
            default -> throw new RuntimeException("Invalid column count!");
        };
    }
}
