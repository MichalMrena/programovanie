package org.edupage.ssosza;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ObceTableModel extends AbstractTableModel {

    private final IDatabazaObci databazaObci;
    private List<Obec> zobrazeneObce;

    public ObceTableModel(IDatabazaObci databazaObci) {
        this.databazaObci = databazaObci;
        this.zobrazeneObce = null;
    }

    public void zobrazObce(String okres) {
        this.zobrazeneObce = this.databazaObci.getObce(okres);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Obec";
            case 1 -> "Populacia";
            default -> throw new RuntimeException("Invalid column index");
        };
    }

    @Override
    public int getRowCount() {
        return this.zobrazeneObce.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Obec obec = this.zobrazeneObce.get(rowIndex);

        // TODO vlastna vynimka
        return switch (columnIndex) {
            case 0 -> obec.getNazov();
            case 1 -> obec.getPopulacia().get(0);
            default -> throw new RuntimeException("Invalid column index");
        };
    }
}
