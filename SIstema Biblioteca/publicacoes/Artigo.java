package publicacoes;

import java.util.ArrayList;
import java.time.LocalDate;


import autor.Autor;

public class Artigo extends Publicacao {
    private String resumo;

    public Artigo(String resumo, String titulo, LocalDate dataPublicacao, double valorMulta) {
        super(titulo, dataPublicacao, valorMulta);
        this.resumo = resumo;
    }

}
