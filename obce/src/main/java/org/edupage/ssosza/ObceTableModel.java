package org.edupage.ssosza;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ObceTableModel extends AbstractTableModel {

    private List<Obec> obce;

    public ObceTableModel(List<Obec> obce) {
        this.obce = obce;
    }

    public void setObce(List<Obec> obce) {
        this.obce = obce;
    }

    @Override
    public int getRowCount() {
        return this.obce.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Obec obec = this.obce.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> obec.getNazov();
            case 1 -> obec.getAktualnaPopulacia();
            default -> throw new IndexOutOfBoundsException("Invalid column index.");
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Obec";
            case 1 -> "Populacia";
            default -> throw new IndexOutOfBoundsException("Invalid column index.");
        };
    }
}
