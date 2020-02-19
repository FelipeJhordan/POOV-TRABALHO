

package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TableModelAluno extends AbstractTableModel{

    public TableModelAluno() {
        this.listaAlunos = new ArrayList<Aluno>();
    }
public void edita(Aluno aluno) {
        int position = 0;
        for (int i = 0; i < listaAlunos.size(); i++) {
            Aluno alunoLista = listaAlunos.get(i);
            if (alunoLista.getId() == (aluno.getId())) {
                position = i;
                break;
            }
        }
        this.listaAlunos.set(position, aluno);     
        fireTableDataChanged();
    }
    private ArrayList<Aluno> listaAlunos;
    private final String[] colunas = {"id", "RA", "Nome", "Curso", "Turma", "Email"};

    public void addAluno(Aluno aluno) {
        this.listaAlunos.add(aluno);
        fireTableDataChanged();
    }

    public void removerAluno(int rowIndex) {
        this.listaAlunos.remove(rowIndex);
        fireTableDataChanged();
    }

    public Aluno getAluno(int rowIndex) {
        return this.listaAlunos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return this.listaAlunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.listaAlunos.get(rowIndex).getId();
            case 1:
                return this.listaAlunos.get(rowIndex).getRa();
            case 2:
                return this.listaAlunos.get(rowIndex).getNome();
            case 3:
                return this.listaAlunos.get(rowIndex).getCurso();
            case 4:
                return this.listaAlunos.get(rowIndex).getTurma();
            case 5:
                return this.listaAlunos.get(rowIndex).getEmail();
            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int columnIndex) {
       return this.colunas[columnIndex];
    }
    
    
}
