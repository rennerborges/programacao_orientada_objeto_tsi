package publicacoes;

import autor.Autor;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Publicacao {
    private LocalDate dataPublicacao;
    private String titulo;
    private ArrayList<Publicacao> referencias;
    private ArrayList<Autor> autores;
    private Boolean disponivel;
    private double valorMulta;

    public Publicacao(String titulo, LocalDate dataPublicacao, double valorMulta) {

        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.valorMulta = valorMulta;
        this.disponivel = true;
        this.autores = new ArrayList<Autor>();
        this.referencias = new ArrayList<Publicacao>();
    }

    public void addReferencia(Publicacao publicacao){
        this.referencias.add(publicacao);
    }

    public void removePublicacao(Publicacao publicacao){
        for (int i = 0; i < this.referencias.size(); i++) {
            if (this.referencias.get(i).equals(publicacao)) {
                this.referencias.remove(i);
            }
        }
    }

    public ArrayList<Publicacao> getPublicoes(){
        return this.referencias;
    }

    public void addAutor(Autor autor){
        this.autores.add(autor);
    }

    public void removeAutor(Autor autor){
        for (int i = 0; i < this.autores.size(); i++) {
            if (this.autores.get(i).equals(autor)) {
                this.autores.remove(i);
            }
        }
    }

    public ArrayList<Autor> getAutores(){
        return this.autores;
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
