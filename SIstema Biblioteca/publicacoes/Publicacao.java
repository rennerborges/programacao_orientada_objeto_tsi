package publicacoes;

import autor.Autor;

import java.util.ArrayList;
import java.util.Date;

public abstract class Publicacao {
    private Date dataPublicacao;
    private String titulo;
    private ArrayList<Publicacao> referencias;
    private ArrayList<Autor> autores;
    private Boolean disponivel;
    private double valorMulta;

    public Publicacao(String titulo, ArrayList<Publicacao> referencias, ArrayList<Autor> autores, Date dataPublicacao,
            double valorMulta) {

        // Verificar se existe valores no arraylists
        // Verificar se existe o livro na biblioteca;

        this.titulo = titulo;
        this.referencias = referencias;
        this.autores = autores;
        this.dataPublicacao = dataPublicacao;
        this.valorMulta = valorMulta;
        this.disponivel = true;
    }

    public void alterStatus() {
        this.disponivel = !this.disponivel;
    }

    public Boolean getDisponivel() {
        return this.disponivel;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public double getValorMulta() {
        return this.valorMulta;
    }

}
