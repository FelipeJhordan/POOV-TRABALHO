package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelEvento extends AbstractTableModel {

  private ArrayList<Evento> listaEventos;
    private final String[] colunas = {"id", "ano", "dataInicio", "dataTermino", "dataTermino", "nome", "quantidade mínima", "quantidade máxima","nota atribuida","numero de avaliadores"};

    public TableModelEvento() {
        this.listaEventos = new ArrayList<Evento>();
    }
 
     public void edita(Evento evento) {
        int position = 0;
        for (int i = 0; i < listaEventos.size(); i++) {
            Evento eventoLista = listaEventos.get(i);
            if (eventoLista.getId() == (evento.getId())) {
                position = i;
                break;
            }
        }
        this.listaEventos.set(position, evento);     
        fireTableDataChanged();
    }
    public void addEvento(Evento evento) {
        this.listaEventos.add(evento);
        fireTableDataChanged();
    }

    public void removerEvento(int rowIndex) {
        this.listaEventos.remove(rowIndex);
        fireTableDataChanged();
    }

    public Evento getEvento(int rowIndex) {
        return this.listaEventos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return this.listaEventos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.listaEventos.get(rowIndex).getId();
            case 1:
                return this.listaEventos.get(rowIndex).getAno();
            case 2:
                return this.listaEventos.get(rowIndex).getDataInicio();
            case 3:
                return this.listaEventos.get(rowIndex).getDataTermino();
            case 4:
                return this.listaEventos.get(rowIndex).getNome();
            case 5:
                return this.listaEventos.get(rowIndex).getQuantidadeMinimaTrabalho();
            case 6:
                return this.listaEventos.get(rowIndex).getQuantidadeMaximaTrabalho();
            case 7:
                return this.listaEventos.get(rowIndex).getNotaAtribuida();
            case 8:
                return this.listaEventos.get(rowIndex).getNumeroDeAvaliadores();
            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int columnIndex) {
       return this.colunas[columnIndex];
    }
    
    
}
