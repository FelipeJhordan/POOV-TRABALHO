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

public class AlunoDao {

    private Connection connetion;

    public AlunoDao(Connection con) {
        this.connetion = con;
    }
    public boolean salvar(Aluno aluno){
        if(aluno.getId() == null){
           if( addAluno(aluno)){
               return true;
           }
        }
        else{
            if(alterAluno(aluno)){
                return true;
            }
        }
        return false;
    }
    public boolean addAluno(Aluno aluno) {
        String sql = "insert into aluno(ra,nome,curso,turma,email) values(?,?,?,?,?)";
        try {
            
                PreparedStatement stmt = connetion.prepareStatement(sql);

                stmt.setLong(1, aluno.getRa());
                stmt.setString(2, aluno.getNome());
                stmt.setString(3, aluno.getCurso());
                stmt.setString(4, aluno.getTurma());
                stmt.setString(5, aluno.getEmail());

                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "Pessoa adicionada com sucesso");
           return true;
            
        } catch (SQLIntegrityConstraintViolationException f) {
            JOptionPane.showMessageDialog(null, "Pessoa ou siape já cadastrado ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Aluno> getLista() {
        try {
            List<Aluno> alunos = new ArrayList<Aluno>();
            PreparedStatement stmt = this.connetion.prepareStatement("select * from aluno");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Aluno aluno = new Aluno();
                aluno.setId(rs.getLong("id"));
                aluno.setRa(rs.getLong("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setTurma(rs.getString("turma"));
                aluno.setEmail(rs.getString("email"));
                alunos.add(aluno);

            }
            rs.close();
            stmt.close();
            return alunos;
        } catch (SQLException es) {
            throw new RuntimeException();
        }

    }

    public Aluno searchAluno(long id) {
        List<Aluno> arr = getLista();
        for (Aluno aluno : arr) {
            if (id == aluno.getId()) {
                return aluno;
            }

        }
        return null;
    }

    public boolean alterAluno(Aluno aluno) {
        String sql = "update aluno set ra=?, nome=?, curso=?, turma=?, email=? where id=?";

        try {
            PreparedStatement stmt = connetion.prepareStatement(sql);
            stmt.setLong(1, aluno.getRa());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getCurso());
            stmt.setString(4, aluno.getTurma());
            stmt.setString(5, aluno.getEmail());
            stmt.setLong(6, aluno.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Aluno Alterado com sucesso");
            return true;
        } catch (SQLIntegrityConstraintViolationException f) {
            JOptionPane.showMessageDialog(null, "Digite um novo RA");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean removeAluno(long id) {
        try {
            PreparedStatement stmt = connetion.prepareStatement("delete from aluno where id=?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
            return true;
        }catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Erro de chave estrangeira");} catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
