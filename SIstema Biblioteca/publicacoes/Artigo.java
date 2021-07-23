package publicacoes;

import java.util.ArrayList;
import java.util.Date;

import autor.Autor;

public class Artigo extends Publicacao {
    private String resumo;

    public Artigo(String resumo, String titulo, ArrayList<Publicacao> referencias, ArrayList<Autor> autores,
            Date dataPublicacao, double valorMulta) {
        super(titulo, referencias, autores, dataPublicacao, valorMulta);
        this.resumo = resumo;
    }

}
