package model;

public class Trabalho {

    private Long id;
    private long alunoLider;
    private long orientador;
    private long coorientador;
    private String titulo;
    private String resumo;
    private String equipamentos;
    private long eventoTrabalho;

    public Long getId() {
        return id;
    }

 public void setId(Long id) {
        this.id = id;
    }

    public long getAlunoLider() {
        return alunoLider;
    }

    public void setAlunoLider(long alunoLider) {
        this.alunoLider = alunoLider;
    }

    public long getOrientador() {
        return orientador;
    }

    public void setOrientador(long orientador) {
        this.orientador = orientador;
    }

    public long getCoorientador() {
        return coorientador;
    }

    public void setCoorientador(long coorientador) {
        this.coorientador = coorientador;
    }
       

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(String equipamentos) {
        this.equipamentos = equipamentos;
    }

    public long getEventoTrabalho() {
        return eventoTrabalho;
    }

    public void setEventoTrabalho(long eventoTrabalho) {
        this.eventoTrabalho = eventoTrabalho;
    }



    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
