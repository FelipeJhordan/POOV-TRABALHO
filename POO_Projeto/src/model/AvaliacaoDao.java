package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.ConvertDateSQL;

public class AvaliacaoDao {

    private Connection connetion;

    public AvaliacaoDao(Connection con) {
        this.connetion = con;
    }
    public boolean salvar(Avaliacao avaliacao){
        if(avaliacao.getId() == null){
           if( addAvaliacao(avaliacao)){
               return true;
           }
        }
        else{
            if(AlterAvaliacao(avaliacao)){
                return true;
            }
        }
        return false;
    }
    public boolean addAvaliacao(Avaliacao avaliacao) {
        String sql = "insert into avaliacao(avaliador,trabalho,notaCriterio1,notaCriterio2,notaCriterio3,notaCriterio4,"
                + "notaCriterio5,notaCriterio6,notaCriterio7,notaCriterio8,notaCriterio9,notaCriterio10,"
                + "notaCriterio11,notaCriterio12,notaCriterio13,notaCriterio14,data,periodo) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            
                PreparedStatement stmt = connetion.prepareStatement(sql);

                stmt.setLong(1, avaliacao.getAvaliador());
                stmt.setLong(2, avaliacao.getTrabalhoAvaliado());
                stmt.setBigDecimal(3, avaliacao.getNotaCriterio1());
                stmt.setBigDecimal(4, avaliacao.getNotaCriterio2());
                stmt.setBigDecimal(5, avaliacao.getNotaCriterio3());
                stmt.setBigDecimal(6, avaliacao.getNotaCriterio4());
                stmt.setBigDecimal(7, avaliacao.getNotaCriterio5());
                stmt.setBigDecimal(8, avaliacao.getNotaCriterio6());
                stmt.setBigDecimal(9, avaliacao.getNotaCriterio7());
                stmt.setBigDecimal(10, avaliacao.getNotaCriterio8());
                stmt.setBigDecimal(11, avaliacao.getNotaCriterio9());
                stmt.setBigDecimal(12, avaliacao.getNotaCriterio10());
                stmt.setBigDecimal(13, avaliacao.getNotaCriterio11());
                stmt.setBigDecimal(14, avaliacao.getNotaCriterio12());
                stmt.setBigDecimal(15, avaliacao.getNotaCriterio13());
                stmt.setBigDecimal(16, avaliacao.getNotaCriterio14());
                stmt.setDate(17, (Date) new ConvertDateSQL().localDateToDate(avaliacao.getDataAvaliacao()));
                stmt.setString(18, avaliacao.getPeriodo());
                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "Avaliacao adicionada com sucesso");
          return true;
            
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Erro de chave estrangeira");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Avaliacao> getLista() {
        try {
            List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
            PreparedStatement stmt = this.connetion.prepareStatement("select * from avaliacao");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setId(rs.getLong("id"));
                avaliacao.setAvaliador(rs.getLong("avaliador"));
                avaliacao.setTrabalhoAvaliado(rs.getLong("trabalho"));
                avaliacao.setNotaCriterio1(rs.getBigDecimal("notaCriterio1"));
                avaliacao.setNotaCriterio2(rs.getBigDecimal("notaCriterio2"));
                avaliacao.setNotaCriterio3(rs.getBigDecimal("notaCriterio3"));
                avaliacao.setNotaCriterio4(rs.getBigDecimal("notaCriterio4"));
                avaliacao.setNotaCriterio5(rs.getBigDecimal("notaCriterio5"));
                avaliacao.setNotaCriterio6(rs.getBigDecimal("notaCriterio6"));
                avaliacao.setNotaCriterio7(rs.getBigDecimal("notaCriterio7"));
                avaliacao.setNotaCriterio8(rs.getBigDecimal("notaCriterio8"));
                avaliacao.setNotaCriterio9(rs.getBigDecimal("notaCriterio9"));
                avaliacao.setNotaCriterio10(rs.getBigDecimal("notaCriterio10"));
                avaliacao.setNotaCriterio11(rs.getBigDecimal("notaCriterio11"));
                avaliacao.setNotaCriterio12(rs.getBigDecimal("notaCriterio12"));
                avaliacao.setNotaCriterio13(rs.getBigDecimal("notaCriterio13"));
                avaliacao.setNotaCriterio14(rs.getBigDecimal("notaCriterio14"));
                avaliacao.setDataAvaliacao(rs.getDate("data").toLocalDate());
                avaliacao.setPeriodo(rs.getString("periodo"));
                avaliacoes.add(avaliacao);

            }
            rs.close();
            stmt.close();
            return avaliacoes;
        } catch (SQLException es) {
            throw new RuntimeException();
        }

    }

    public Avaliacao searchAvaliacao(long id) {
        List<Avaliacao> arr = getLista();
        for (Avaliacao avaliacao : arr) {
            if (id == avaliacao.getId()) {
                return avaliacao;
            }

        }
        return null;
    }

    public boolean AlterAvaliacao(Avaliacao avaliacao) {
        String sql = "update avaliacao set avaliador=?,trabalho=?,notaCriterio1=?"
                + ",notaCriterio2=?,notaCriterio3=?,notaCriterio4=?,notaCriterio5=?,notaCriterio6=?"
                + ",notaCriterio7=?,notaCriterio8=?,notaCriterio9=?,notaCriterio10=?,notaCriterio11=?,"
                + "notaCriterio12=?,notaCriterio13=?,notaCriterio14=?,data=?,periodo=? where id=?";

        try {
            PreparedStatement stmt = connetion.prepareStatement(sql);
            stmt.setLong(1, avaliacao.getAvaliador());
            stmt.setLong(2, avaliacao.getTrabalhoAvaliado());
            stmt.setBigDecimal(3, avaliacao.getNotaCriterio1());
            stmt.setBigDecimal(4, avaliacao.getNotaCriterio2());
            stmt.setBigDecimal(5, avaliacao.getNotaCriterio3());
            stmt.setBigDecimal(6, avaliacao.getNotaCriterio4());
            stmt.setBigDecimal(7, avaliacao.getNotaCriterio5());
            stmt.setBigDecimal(8, avaliacao.getNotaCriterio6());
            stmt.setBigDecimal(9, avaliacao.getNotaCriterio7());
            stmt.setBigDecimal(10, avaliacao.getNotaCriterio8());
            stmt.setBigDecimal(11, avaliacao.getNotaCriterio9());
            stmt.setBigDecimal(12, avaliacao.getNotaCriterio10());
            stmt.setBigDecimal(13, avaliacao.getNotaCriterio11());
            stmt.setBigDecimal(14, avaliacao.getNotaCriterio12());
            stmt.setBigDecimal(15, avaliacao.getNotaCriterio13());
            stmt.setBigDecimal(16, avaliacao.getNotaCriterio14());
            stmt.setDate(17, (Date) new ConvertDateSQL().localDateToDate(avaliacao.getDataAvaliacao()));
            stmt.setString(18, avaliacao.getPeriodo());
            stmt.setLong(19, avaliacao.getId());
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

    public boolean removeAvaliacao(long id) {
        try {
            PreparedStatement stmt = connetion.prepareStatement("delete from avaliacao where id=?");
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
