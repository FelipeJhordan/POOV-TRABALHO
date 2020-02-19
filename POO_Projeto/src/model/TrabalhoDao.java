
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TrabalhoDao {
    private Connection connetion;

    public TrabalhoDao(Connection con) {
        this.connetion  = con;
    }
    public boolean salvar(Trabalho trabalho){
        if(trabalho.getId() == null){
           if( addTrabalho(trabalho)){
               return true;
           }
        }
        else{
            if(alterTrabalho(trabalho)){
                return true;
            }
        }
        return false;
    }
    public boolean addTrabalho(Trabalho trabalho){
        String sql = "insert into trabalho(alunoLider,orientador,coorientador,titulo,resumo,equipamentos,"
                + "eventoTrabalho) values(?,?,?,?,?,?,?)";
        try{
             
            PreparedStatement stmt = connetion.prepareStatement(sql);
            
            stmt.setLong(1, trabalho.getAlunoLider());
            stmt.setLong(2, trabalho.getOrientador());
            stmt.setLong(3, trabalho.getCoorientador());
            stmt.setString(4, trabalho.getTitulo());
            stmt.setString(5,trabalho.getResumo());
            stmt.setString(6, trabalho.getEquipamentos());
            stmt.setLong(7, trabalho.getEventoTrabalho());
            stmt.execute();
            stmt.close();
            return true;
             
        } catch(SQLIntegrityConstraintViolationException e){
                   JOptionPane.showMessageDialog(null,"Erro de chave estrangeira"); 
                    }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    
    public List<Trabalho> getLista(){
        try{
            List<Trabalho> trabalhos = new ArrayList<Trabalho>();
            PreparedStatement stmt = this.connetion.prepareStatement("select * from trabalho");
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                
                Trabalho trabalho = new Trabalho();
                trabalho.setId(rs.getLong("id"));
                trabalho.setAlunoLider(rs.getLong("alunoLider"));
                trabalho.setOrientador(rs.getLong("orientador"));
                trabalho.setCoorientador(rs.getLong("coorientador"));
                trabalho.setTitulo(rs.getString("titulo"));
                trabalho.setResumo(rs.getString("resumo"));
                trabalho.setEquipamentos(rs.getString("equipamentos"));
                trabalho.setEventoTrabalho(rs.getLong("eventoTrabalho"));
                trabalhos.add(trabalho);
                                            
            }
            rs.close();
            stmt.close();
            return trabalhos;
        }  catch(SQLException es) {
            throw new RuntimeException();
        }
        
    }
    
    public Trabalho searchTrabalho(long id){
        List<Trabalho> arr = getLista();
        for (Trabalho trabalho : arr) {
            if(id == trabalho.getId()){
                return trabalho;
            }
            
    }
        return null;
    }
        
    public boolean alterTrabalho(Trabalho trabalho){
        String sql = "update trabalho set alunoLider=?, orientador=?, coorientador=?, titulo=?,resumo=?"
                + ", equipamentos=?,eventoTrabalho=? where id=?";
        
        try{
            PreparedStatement stmt = connetion.prepareStatement(sql);
             
            stmt.setLong(1, trabalho.getAlunoLider());
            stmt.setLong(2, trabalho.getOrientador());
            stmt.setLong(3, trabalho.getCoorientador());
            stmt.setString(4, trabalho.getTitulo());
            stmt.setString(5,trabalho.getResumo());
            stmt.setString(6, trabalho.getEquipamentos());
            stmt.setLong(7, trabalho.getEventoTrabalho());
            stmt.setLong(8, trabalho.getId());
            stmt.execute();
            stmt.close();
            return true;
        }catch(SQLIntegrityConstraintViolationException e){
                   JOptionPane.showMessageDialog(null,"Erro de chave estrangeira"); 
                    }  catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
    public boolean removeTrabalho(long id){
            try{
                PreparedStatement stmt = connetion.prepareStatement("delete from trabalho where id=?");
                stmt.setLong(1,id);
                stmt.execute();
                stmt.close();
                return true;
            }  catch(SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Trabalho vinculada em outra tabela ");
        } catch(SQLException e){
                throw new RuntimeException(e);
            }
            return false;
        }
}
