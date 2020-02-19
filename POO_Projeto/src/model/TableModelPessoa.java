package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModelPessoa extends AbstractTableModel {

    public TableModelPessoa() {
        this.listaPessoas = new ArrayList<Pessoa>();
    }
    public void edita(Pessoa pessoa) {
        int position = 0;
        for (int i = 0; i < listaPessoas.size(); i++) {
            Pessoa pessoaLista = listaPessoas.get(i);
            if (pessoaLista.getId() == (pessoa.getId())) {
                position = i;
                break;
            }
        }
        this.listaPessoas.set(position, pessoa);     
        fireTableDataChanged();
    }
    private ArrayList<Pessoa> listaPessoas;
    private final String[] colunas = {"id", "Siape", "Nome", "Email", "Login", "Senha"};

    public void addPessoa(Pessoa pessoa) {
        this.listaPessoas.add(pessoa);
        fireTableDataChanged();
    }

    public void removerPessoa(int rowIndex) {
        this.listaPessoas.remove(rowIndex);
        fireTableDataChanged();
    }

    public Pessoa getPessoa(int rowIndex) {
        return this.listaPessoas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return this.listaPessoas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.listaPessoas.get(rowIndex).getId();
            case 1:
                return this.listaPessoas.get(rowIndex).getSiape();
            case 2:
                return this.listaPessoas.get(rowIndex).getNome();
            case 3:
                return this.listaPessoas.get(rowIndex).getEmail();
            case 4:
                return this.listaPessoas.get(rowIndex).getLogin();
            case 5:
                return this.listaPessoas.get(rowIndex).getSenha();
            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int columnIndex) {
       return this.colunas[columnIndex];
    }
    
}
