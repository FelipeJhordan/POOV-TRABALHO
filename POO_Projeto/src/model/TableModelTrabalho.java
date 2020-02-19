

package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TableModelTrabalho extends AbstractTableModel{
    
    private final String[] colunas = {"id","Aluno Líder","Orientador","Coorientador","Título","Resumo","Equipamentos","Evento Trabalho"};
    private ArrayList<Trabalho> listaTrabalhos;

    public TableModelTrabalho() {
        this.listaTrabalhos = new ArrayList<Trabalho>();
    }
     public void edita(Trabalho trabalho) {
        int position = 0;
        for (int i = 0; i < listaTrabalhos.size(); i++) {
            Trabalho trabalhoLista = listaTrabalhos.get(i);
            if (trabalhoLista.getId() == (trabalho.getId())) {
                position = i;
                break;
            }
        }
        this.listaTrabalhos.set(position, trabalho);     
        fireTableDataChanged();
    }
    public void addTrabalho(Trabalho trabalho){
        this.listaTrabalhos.add(trabalho);
        fireTableDataChanged();
    }
    public void removeTrabalho(int rowIndex){
        this.listaTrabalhos.remove(rowIndex);
        fireTableDataChanged();
    }
    public Trabalho getTrabalho(int rowIndex){
       return this.listaTrabalhos.get(rowIndex);
    }
    @Override
    public int getRowCount() {
        return this.listaTrabalhos.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
       switch(columnIndex){
           case 0: return this.listaTrabalhos.get(rowIndex).getId();
           case 1: return this.listaTrabalhos.get(rowIndex).getAlunoLider();
           case 2: return this.listaTrabalhos.get(rowIndex).getOrientador();
           case 3: return this.listaTrabalhos.get(rowIndex).getCoorientador();
           case 4: return this.listaTrabalhos.get(rowIndex).getTitulo();
           case 5: return this.listaTrabalhos.get(rowIndex).getResumo();
           case 6: return this.listaTrabalhos.get(rowIndex).getEquipamentos();
           case 7: return this.listaTrabalhos.get(rowIndex).getEventoTrabalho();
           default: return null;
    }
    }

    @Override
   public String getColumnName(int columnIndex) {
       return this.colunas[columnIndex];
    }
    
    
}
