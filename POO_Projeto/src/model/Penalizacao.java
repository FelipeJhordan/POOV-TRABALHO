package model;
public class Penalizacao {
    private long id;
    private String razao;
    private Aluno alunoPenalizado;
    private Evento evento;

    public long getId() {
        return id;
    }

     public void setId(long id) {
        this.id = id;
    }
    

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public Aluno getAlunoPenalizado() {
        return alunoPenalizado;
    }

    public void setAlunoPenalizado(Aluno alunoPenalizado) {
        this.alunoPenalizado = alunoPenalizado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
