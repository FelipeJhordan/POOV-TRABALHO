package model;
public class Criterio {
   private long id;
   private String descricao;

    public long getId() {
        return id;
    }

     public void setId(long id) {
        this.id = id;
    }
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}
