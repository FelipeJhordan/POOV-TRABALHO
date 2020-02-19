package model;
public class AvaliadorTrabalho {
    private Long id;
    private long avaliador;
    private long trabalho;

    public Long getId() {
        return id;
    }


    
     public void setId(Long id) {
        this.id = id;
    }

    public long getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(long avaliador) {
        this.avaliador = avaliador;
    }

    public long getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(long trabalho) {
        this.trabalho = trabalho;
    }
    

    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
