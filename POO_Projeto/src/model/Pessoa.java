package model;
public class Pessoa {
    private Long id;
    private String nome;
    private long siape;
    private String email;
    private String login;
    private String senha;

    public Pessoa() {
    }

    public Pessoa(String nome, long siape, String email, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.siape = siape;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }
    
    public Long getId() {
        return id;
    }

     public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getSiape() {
        return siape;
    }

    public void setSiape(long siape) {
        this.siape = siape;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
