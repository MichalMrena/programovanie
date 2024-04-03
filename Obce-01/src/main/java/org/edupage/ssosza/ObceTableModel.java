package org.edupage.ssosza;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ObceTableModel extends AbstractTableModel {

    private IDatabazaObci databazaObci;
    private List<Obec> zobrazeneObce;

    public ObceTableModel(IDatabazaObci databazaObci) {
        this.databazaObci = databazaObci;
        this.zobrazeneObce = null;
    }

    public void zobrazObce(String okres) {
        this.zobrazeneObce = this.databazaObci.getObce(okres);
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

        switch (columnIndex) {
            case 0:
                return obec.getNazov();

            case 1:
                return obec.getPopulacia().get(0);

            default:
                // TODO vlastna vynimka
                throw new RuntimeException("Invalid column number");
        }
    }
}
