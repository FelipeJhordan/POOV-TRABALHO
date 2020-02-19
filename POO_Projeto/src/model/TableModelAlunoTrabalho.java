

package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TableModelAlunoTrabalho extends AbstractTableModel{



    private final String[] colunas = {"id", "Aluno", "Trabalho"};
    private ArrayList<AlunoTrabalho> listaAlunoTrabalho;

    public TableModelAlunoTrabalho() {
        this.listaAlunoTrabalho = new ArrayList<AlunoTrabalho>();
    }
 public void edita(AlunoTrabalho AlunoTrabalho) {
        int position = 0;
        for (int i = 0; i < listaAlunoTrabalho.size(); i++) {
            AlunoTrabalho AlunoTrabalhoLista = listaAlunoTrabalho.get(i);
            if (AlunoTrabalhoLista.getId() == (AlunoTrabalho.getId())) {
                position = i;
                break;
            }
        }
        this.listaAlunoTrabalho.set(position, AlunoTrabalho);     
        fireTableDataChanged();
    }
    public void addTrabalho(AlunoTrabalho alunoTrabalho) {
        this.listaAlunoTrabalho.add(alunoTrabalho);
        fireTableDataChanged();
    }

    public void removeTrabalho(int rowIndex) {
        this.listaAlunoTrabalho.remove(rowIndex);
        fireTableDataChanged();
    }

    public AlunoTrabalho getTrabalho(int rowIndex) {
        return this.listaAlunoTrabalho.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return this.listaAlunoTrabalho.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return this.listaAlunoTrabalho.get(rowIndex).getId();
            case 1:
                return this.listaAlunoTrabalho.get(rowIndex).getAluno();
            case 2:
                return this.listaAlunoTrabalho.get(rowIndex).getTrabalho();

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
}


