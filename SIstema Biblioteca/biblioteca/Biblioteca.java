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

    public void addPublicacao(Publicacao publicacao) {

        if(this.getPublicacao(publicacao) != null){
            throw new IllegalArgumentException("Publicação já existente nessa biblioteca");
        }

        publicacoes.add(publicacao);
    }

    public Publicacao getPublicacao(Publicacao searchPublicacao) {
        Publicacao publicacao;

        for (int i = 0; i < this.publicacoes.size(); i++) {
            if (this.publicacoes.get(i).equals(searchPublicacao)) {
                publicacao = this.publicacoes.get(i);
                return publicacao;
            }
        }

        return null;

    }

    public Boolean removePublicacao(Publicacao searchPublicacao) {
        for (int i = 0; i < this.publicacoes.size(); i++) {
            if (this.publicacoes.get(i).equals(searchPublicacao)) {
                this.publicacoes.remove(i);
                return true;
            }
        }
        return false;

    }

}
