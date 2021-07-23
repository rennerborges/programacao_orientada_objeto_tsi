package autor;

public class Autor {
    private String nome;
    private String titulacao;

    public Autor(String nome, String titulacao){
        this.nome = nome;
        this.titulacao = titulacao;
    }

    public String getNome(){
        return this.nome;
    }

    public String getTitulacao(){
        return this.titulacao;
    }
}
