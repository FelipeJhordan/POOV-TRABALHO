package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModelAvaliadorTrabalho extends AbstractTableModel {

    private final String[] colunas = {"id", "Avaliador", "Trabalho"};
    private ArrayList<AvaliadorTrabalho> listaAvaliadorTrabalho;

    public TableModelAvaliadorTrabalho() {
        this.listaAvaliadorTrabalho = new ArrayList<AvaliadorTrabalho>();
    }
 public void edita(AvaliadorTrabalho AvaliadorTrabalho) {
        int position = 0;
        for (int i = 0; i < listaAvaliadorTrabalho.size(); i++) {
            AvaliadorTrabalho AvaliadorTrabalhoLista = listaAvaliadorTrabalho.get(i);
            if (AvaliadorTrabalhoLista.getId() == (AvaliadorTrabalho.getId())) {
                position = i;
                break;
            }
        }
        this.listaAvaliadorTrabalho.set(position, AvaliadorTrabalho);     
        fireTableDataChanged();
    }
    public void addTrabalho(AvaliadorTrabalho avaliador) {
        this.listaAvaliadorTrabalho.add(avaliador);
        fireTableDataChanged();
    }

    public void removeAvaliadorTrabalho(int rowIndex) {
        this.listaAvaliadorTrabalho.remove(rowIndex);
        fireTableDataChanged();
    }

    public AvaliadorTrabalho getTrabalho(int rowIndex) {
        return this.listaAvaliadorTrabalho.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return this.listaAvaliadorTrabalho.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return this.listaAvaliadorTrabalho.get(rowIndex).getId();
            case 1:
                return this.listaAvaliadorTrabalho.get(rowIndex).getAvaliador();
            case 2:
                return this.listaAvaliadorTrabalho.get(rowIndex).getTrabalho();

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}
