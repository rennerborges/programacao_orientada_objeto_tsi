package publicacoes;

import java.util.ArrayList;
import java.time.LocalDate;

import autor.Autor;

public class Livro extends Publicacao {
    private String nomeEdicao;
    private String nomeEditora;
    private int ISBN;

    public Livro(String nomeEdicao, String nomeEditora, int ISBN, String titulo, ArrayList<Publicacao> referencias,
            ArrayList<Autor> autores, LocalDate dataPublicacao, double valorMulta) {
        super(titulo, referencias, autores, dataPublicacao, valorMulta);
        this.nomeEdicao = nomeEdicao;
        this.nomeEditora = nomeEditora;
        this.ISBN = ISBN;
    }

}
