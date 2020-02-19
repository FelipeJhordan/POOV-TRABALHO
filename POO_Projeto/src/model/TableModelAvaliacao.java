package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModelAvaliacao extends AbstractTableModel {

    public TableModelAvaliacao() {
        this.listaAvaliacaos = new ArrayList<Avaliacao>();
    }
 public void edita(Avaliacao avaliacao) {
        int position = 0;
        for (int i = 0; i < listaAvaliacaos.size(); i++) {
            Avaliacao avaliacaoLista = listaAvaliacaos.get(i);
            if (avaliacaoLista.getId() == (avaliacao.getId())) {
                position = i;
                break;
            }
        }
        this.listaAvaliacaos.set(position, avaliacao);     
        fireTableDataChanged();
    }
    private ArrayList<Avaliacao> listaAvaliacaos;
    private final String[] colunas = {"id", "avaliador", "trabalho", "nota 1", "nota 2", "nota 3",
         "nota 4", "nota 5", "nota 6", "nota 7", "nota 8", "nota 9", "nota 10", "nota 11",
         "nota 12", "nota 13", "nota 14", "data", "periodo"};

    public void addAvaliacao(Avaliacao avaliacao) {
        this.listaAvaliacaos.add(avaliacao);
        fireTableDataChanged();
    }

    public void removerAvaliacao(int rowIndex) {
        this.listaAvaliacaos.remove(rowIndex);
        fireTableDataChanged();
    }

    public Avaliacao getAvaliacao(int rowIndex) {
        return this.listaAvaliacaos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return this.listaAvaliacaos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.listaAvaliacaos.get(rowIndex).getId();
            case 1:
                return this.listaAvaliacaos.get(rowIndex).getAvaliador();
            case 2:
                return this.listaAvaliacaos.get(rowIndex).getTrabalhoAvaliado();
            case 3:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio1();
            case 4:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio2();
            case 5:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio3();
            case 6:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio4();
            case 7:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio5();
            case 8:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio6();
            case 9:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio7();
            case 10:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio8();
            case 11:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio9();
            case 12:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio10();
            case 13:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio11();
            case 14:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio12();
            case 15:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio13();
            case 16:
                return this.listaAvaliacaos.get(rowIndex).getNotaCriterio14();
            case 17:
                return this.listaAvaliacaos.get(rowIndex).getPeriodo();
            case 18:
                return this.listaAvaliacaos.get(rowIndex).getDataAvaliacao();

            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }

}
