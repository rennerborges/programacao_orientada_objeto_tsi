package biblioteca;

import java.util.ArrayList;

import publicacoes.Publicacao;

public class Biblioteca {
    private String nome;
    private String cidade;
    private String estado;
    private String pais;
    private String endereco;
    private ArrayList<Publicacao> publicacoes;

    public Biblioteca(String nome, String cidade, String estado, String pais, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.endereco = endereco;
        this.publicacoes = new ArrayList<Publicacao>();
    }

    public void setPublicacao(Publicacao publicacao) {
        // Verificar se essa publicação já existe;

        publicacoes.add(publicacao);
    }

}
