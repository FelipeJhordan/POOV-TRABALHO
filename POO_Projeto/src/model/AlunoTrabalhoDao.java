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

public class AlunoTrabalhoDao {

    private Connection connetion;

    public AlunoTrabalhoDao(Connection con) {
        this.connetion = con;
    }
public boolean salvar(AlunoTrabalho alunoTrabalho){
        if(alunoTrabalho.getId() == null){
           if( addAlunoTrabalho(alunoTrabalho)){
               return true;
           }
        }
        else{
            if(alterAlunoTrabalho(alunoTrabalho)){
                return true;
            }
        }
        return false;
    }
    public boolean addAlunoTrabalho(AlunoTrabalho alunoTrabalho) {
        String sql = "insert into alunoTrabalho(aluno,trabalho) values(?,?)";
        try {
           
                PreparedStatement stmt = connetion.prepareStatement(sql);

                stmt.setLong(1, alunoTrabalho.getAluno());
                stmt.setLong(2, alunoTrabalho.getTrabalho());
                JOptionPane.showMessageDialog(null, "Aluno-Trabalho adicionada com sucesso");
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

    public List<AlunoTrabalho> getLista() {
        try {
            List<AlunoTrabalho> alunoTrabalhos = new ArrayList<AlunoTrabalho>();
            PreparedStatement stmt = this.connetion.prepareStatement("select * from alunoTrabalho");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                AlunoTrabalho alunoTrabalho = new AlunoTrabalho();
                alunoTrabalho.setId(rs.getLong("id"));
                alunoTrabalho.setAluno(rs.getLong("aluno"));
                alunoTrabalho.setTrabalho(rs.getLong("trabalho"));

                alunoTrabalhos.add(alunoTrabalho);

            }
            rs.close();
            stmt.close();
            return alunoTrabalhos;
        } catch (SQLException es) {
            throw new RuntimeException();
        }

    }

    public AlunoTrabalho searchAlunoTrabalho(long id) {
        List<AlunoTrabalho> arr = getLista();
        for (AlunoTrabalho alunoTrabalho : arr) {
            if (id == alunoTrabalho.getId()) {
                return alunoTrabalho;
            }

        }
        return null;
    }

    public boolean alterAlunoTrabalho(AlunoTrabalho alunoTrabalho) {
        String sql = "update alunoTrabalho set aluno=?,trabalho=? where id=?";

        try {
            PreparedStatement stmt = connetion.prepareStatement(sql);
            stmt.setLong(1, alunoTrabalho.getAluno());
            stmt.setLong(2, alunoTrabalho.getTrabalho());;
            stmt.setLong(3, alunoTrabalho.getId());
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

    public boolean removeAlunoTrabalho(long id) {
        try {
            PreparedStatement stmt = connetion.prepareStatement("delete from alunoTrabalho where id=?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Erro de chave estrangeira");}catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
