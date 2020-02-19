
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

public class EventoDao {
    private Connection connetion;

    public EventoDao(Connection con) {
        this.connetion  = con;
    }
    public boolean salvar(Evento evento){
        if(evento.getId() == null){
           if( addEvento(evento)){
               return true;
           }
        }
        else{
            if(alterEvento(evento)){
                return true;
            }
        }
        return false;
    }
    public boolean addEvento(Evento evento){
        
        
        
        String sql = "insert into evento(ano,dataInicio,dataTermino,nome,quantidadeMinimaTrabalho,quantidadeMaximaTrabalho,notaAtribuida,numeroDeAvaliadores) values(?,?,?,?,?,?,?,?)";
        try{
            
                PreparedStatement stmt = connetion.prepareStatement(sql);
                stmt.setInt(1, evento.getAno());
                stmt.setDate(2,(Date) new ConvertDateSQL().localDateToDate(evento.getDataInicio()));
                 stmt.setDate(3,(Date) new ConvertDateSQL().localDateToDate(evento.getDataTermino()));
                stmt.setString(4, evento.getNome());
                 stmt.setInt(5, evento.getQuantidadeMinimaTrabalho());
            stmt.setInt(6, evento.getQuantidadeMaximaTrabalho());
            stmt.setBigDecimal(7, evento.getNotaAtribuida());
            stmt.setInt(8, evento.getNumeroDeAvaliadores());
            stmt.execute();
            stmt.close();
       
            return true;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Evento> getLista(){
        try{
            List<Evento> eventos = new ArrayList<Evento>();
            PreparedStatement stmt = this.connetion.prepareStatement("select * from evento");
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                
                Evento evento = new Evento();
                evento.setId(rs.getLong("id"));
                evento.setAno(rs.getInt("ano"));
                evento.setDataInicio(rs.getDate("dataInicio").toLocalDate());
                evento.setDataTermino(rs.getDate("dataTermino").toLocalDate());
                evento.setNome(rs.getString("nome"));
                evento.setNotaAtribuida(rs.getBigDecimal("notaAtribuida"));
                evento.setQuantidadeMinimaTrabalho(rs.getInt("quantidadeMinimaTrabalho"));
                evento.setQuantidadeMaximaTrabalho(rs.getInt("quantidadeMaximaTrabalho"));
                evento.setNumeroDeAvaliadores(rs.getInt("numeroDeAvaliadores"));
                eventos.add(evento);
                
            }
            rs.close();
            stmt.close();
            return eventos;
        }  catch(SQLException es) {
            throw new RuntimeException();
        }
        
    }
    
    public Evento searchEvento(long id){
        List<Evento> arr = getLista();
        for (Evento evento : arr) {
            if(id == evento.getId()){
                return evento;
            }
            
    }
        return null;
    }
        
    public boolean alterEvento(Evento evento){
        String sql = "update evento set ano=?, dataInicio=?, dataTermino=?, nome=?, QuantidadeMinimaTrabalho=?,"
                + "QuantidadeMaximaTrabalho=?,notaAtribuida=?,numeroDeAvaliadores=? where id=?";
        
        try{
            PreparedStatement stmt = connetion.prepareStatement(sql);
            stmt.setInt(1, evento.getAno());
            stmt.setDate(2,(Date) new ConvertDateSQL().localDateToDate(evento.getDataInicio()));
            stmt.setDate(3,(Date) new ConvertDateSQL().localDateToDate(evento.getDataTermino()));
            stmt.setString(4, evento.getNome());
            stmt.setInt(5, evento.getQuantidadeMinimaTrabalho());
            stmt.setInt(6, evento.getQuantidadeMaximaTrabalho());
            stmt.setBigDecimal(7, evento.getNotaAtribuida());
            stmt.setInt(8, evento.getNumeroDeAvaliadores());
            stmt.setLong(9, evento.getId());
            stmt.execute();
            stmt.close();
                                        JOptionPane.showMessageDialog(null,"Evento Alterado com sucesso");
                                        return true;
        }  catch (SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    public boolean removeEvento(long id){
            try{
                PreparedStatement stmt = connetion.prepareStatement("delete from evento where id=?");
                stmt.setLong(1,id);
                stmt.execute();
                stmt.close();
                return true;
            } catch(SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Evento vinculado em outra tabela ");
        }  catch(SQLException e){
                throw new RuntimeException(e);
            }
            return false;
        }
}
