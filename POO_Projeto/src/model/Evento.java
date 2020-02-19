package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Evento {

    private Long id;
    private int ano;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String nome;
    private int quantidadeMinimaTrabalho;
    private int quantidadeMaximaTrabalho;
    private BigDecimal notaAtribuida;
    private int numeroDeAvaliadores;

    public Long getId() {
        return id;
    }
 public void setId(Long id) {
        this.id = id;
    }
    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeMinimaTrabalho() {
        return quantidadeMinimaTrabalho;
    }

    public void setQuantidadeMinimaTrabalho(int quantidadeMinimaTrabalho) {
        this.quantidadeMinimaTrabalho = quantidadeMinimaTrabalho;
    }

    public int getQuantidadeMaximaTrabalho() {
        return quantidadeMaximaTrabalho;
    }

    public void setQuantidadeMaximaTrabalho(int quantidadeMaximaTrabalho) {
        this.quantidadeMaximaTrabalho = quantidadeMaximaTrabalho;
    }

    public BigDecimal getNotaAtribuida() {
        return notaAtribuida;
    }

    public void setNotaAtribuida(BigDecimal notaAtribuida) {
        this.notaAtribuida = notaAtribuida;
    }

    public int getNumeroDeAvaliadores() {
        return numeroDeAvaliadores;
    }

    public void setNumeroDeAvaliadores(int numeroDeAvaliadores) {
        this.numeroDeAvaliadores = numeroDeAvaliadores;
    }

    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
