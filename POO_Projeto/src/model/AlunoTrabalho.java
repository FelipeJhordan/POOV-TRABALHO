package model;
public class AlunoTrabalho {
    private Long id;
    private long aluno;
    private long trabalho;

    public Long getId() {
        return id;
    }


     public void setId(Long id) {
        this.id = id;
    }

    public long getAluno() {
        return aluno;
    }

    public void setAluno(long aluno) {
        this.aluno = aluno;
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
