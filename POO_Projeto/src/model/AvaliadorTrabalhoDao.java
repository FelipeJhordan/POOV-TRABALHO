package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.ConnectionFactory;

public class AvaliadorTrabalhoDao {

    private Connection connetion;

    public AvaliadorTrabalhoDao(Connection con) {
        this.connetion = con;
    }
public boolean salvar(AvaliadorTrabalho avaliadorTrabalho){
        if(avaliadorTrabalho.getId() == null){
           if( addAvaliadorTrabalho(avaliadorTrabalho)){
               return true;
           }
        }
        else{
            if(alterAvaliadorTrabalho(avaliadorTrabalho)){
                return true;
            }
        }
        return false;
    }
    public boolean addAvaliadorTrabalho(AvaliadorTrabalho avaliadorTrabalho) {
        try{
        String sql = "insert into avaliadorTrabalho(pessoa,trabalho) values(?,?)";
        
                PreparedStatement stmt = connetion.prepareStatement(sql);

                stmt.setLong(1, avaliadorTrabalho.getAvaliador());
                stmt.setLong(2, avaliadorTrabalho.getTrabalho());
                stmt.execute();
                stmt.close();
            
            JOptionPane.showMessageDialog(null, "Avaliador adicionado com sucesso");
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Erro de chave estrangeira");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<AvaliadorTrabalho> getLista() {
        try {
            List<AvaliadorTrabalho> avaliadorTrabalhos = new ArrayList<AvaliadorTrabalho>();
            PreparedStatement stmt = this.connetion.prepareStatement("select * from avaliadorTrabalho");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                AvaliadorTrabalho avaliadorTrabalho = new AvaliadorTrabalho();
                avaliadorTrabalho.setId(rs.getLong("id"));
                avaliadorTrabalho.setAvaliador(rs.getLong("pessoa"));
                avaliadorTrabalho.setTrabalho(rs.getLong("trabalho"));

                avaliadorTrabalhos.add(avaliadorTrabalho);

            }
            rs.close();
            stmt.close();
            return avaliadorTrabalhos;
        } catch (SQLException es) {
            throw new RuntimeException();
        }

    }

    public AvaliadorTrabalho searchAvaliadorTrabalho(long id) {
        List<AvaliadorTrabalho> arr = getLista();
        for (AvaliadorTrabalho avaliadorTrabalho : arr) {
            if (id == avaliadorTrabalho.getId()) {
                return avaliadorTrabalho;
            }

        }
        return null;
    }

    public boolean alterAvaliadorTrabalho(AvaliadorTrabalho avaliadorTrabalho) {
        String sql = "update avaliadorTrabalho set avaliador=?,trabalho=? where id=?";

        try {
            PreparedStatement stmt = connetion.prepareStatement(sql);
            stmt.setLong(1, avaliadorTrabalho.getAvaliador());
            stmt.setLong(2, avaliadorTrabalho.getTrabalho());;
            stmt.setLong(3, avaliadorTrabalho.getId());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Erro de chave estrangeira");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean removeAvaliadorTrabalho(long id) {
        try {
            PreparedStatement stmt = connetion.prepareStatement("delete from avaliadorTrabalho where id=?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
            return true;
        } catch(SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Pessoa vinculada em outra tabela ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
