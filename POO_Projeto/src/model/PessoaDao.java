package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.CriptoPessoa;

public class PessoaDao {

    private Connection connetion;

    public PessoaDao(Connection con) {
        this.connetion = con;
    }
    public boolean salvar(Pessoa pessoa){
        if(pessoa.getId() == null){
           if( addPessoa(pessoa)){
               return true;
           }
        }
        else{
            if(alterPessoa(pessoa)){
                return true;
            }
        }
        return false;
    }
    public boolean addPessoa(Pessoa pessoa) {
        String sql = "insert into pessoa(siape,nome,email,login,senha) values(?,?,?,?,?)";
        try {
                PreparedStatement stmt = connetion.prepareStatement(sql);
                stmt.setLong(1, pessoa.getSiape());
                stmt.setString(2, pessoa.getNome());
                stmt.setString(3, pessoa.getEmail());
                stmt.setString(4, pessoa.getLogin());
                stmt.setString(5, (new CriptoPessoa().criptografa(pessoa.getSenha())));

                stmt.execute();
                stmt.close();
                return true;
        } catch (SQLIntegrityConstraintViolationException f) {
            JOptionPane.showMessageDialog(null, "Pessoa ou siape já cadastrado ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Pessoa> getLista() {
        try {
            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            PreparedStatement stmt = this.connetion.prepareStatement("select * from pessoa");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getLong("id"));
                pessoa.setSiape(rs.getLong("siape"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setLogin(rs.getString("login"));
                pessoa.setSenha(rs.getString("senha"));
                pessoas.add(pessoa);

            }
            rs.close();
            stmt.close();
            return pessoas;
        } catch (SQLException es) {
            throw new RuntimeException();
        }

    }

    public Pessoa searchPessoa(long id) {
        List<Pessoa> arr = getLista();
        for (Pessoa pessoa : arr) {
            if (id == pessoa.getId()) {
                return pessoa;
            }

        }
        return null;
    }

    public Pessoa searchPessoaByLogin(String login) {
        List<Pessoa> arrPessoa = getLista();
        for (Pessoa pessoa : arrPessoa) {
            if (login.equals(pessoa.getLogin())) {
                return pessoa;
            }
        }
        return null;
    }

    public boolean alterPessoa(Pessoa pessoa) {
        String sql = "update pessoa set siape=?, nome=?, email=?, login=?, senha=? where id=?";

        try {
            PreparedStatement stmt = connetion.prepareStatement(sql);
            stmt.setLong(1, pessoa.getSiape());
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getLogin());
            stmt.setString(5, new CriptoPessoa().criptografa(pessoa.getSenha()));
            stmt.setLong(6, pessoa.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso");
            return true;
        } catch (SQLIntegrityConstraintViolationException f) {
            JOptionPane.showMessageDialog(null, "Pessoa ou siape já cadastrado ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean removePessoa(long id) {
        try {
            PreparedStatement stmt = connetion.prepareStatement("delete from pessoa where id=?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
            return true;
        }catch(SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Pessoa vinculada em outra tabela ");
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
