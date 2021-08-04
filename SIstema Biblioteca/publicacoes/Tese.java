package publicacoes;

import java.util.ArrayList;
import java.time.LocalDate;


import autor.Autor;

public class Tese extends Publicacao {

    private String resumo;
    private int numeroPaginas;
    private LocalDate dataDefesa;
    private String instituicao;

    public Tese(String resumo, String titulo, Autor autor,
    LocalDate dataPublicacao, double valorMulta, int numeroPaginas, LocalDate dataDefesa, String instituicao) {
        super(titulo, dataPublicacao, valorMulta);
        this.resumo = resumo;
        this.numeroPaginas = numeroPaginas;
        this.dataDefesa = dataDefesa;
        this.instituicao = instituicao;
    }

    public void addAutor(Autor autor){
        if(super.getAutores().size() == 0){
            super.addAutor(autor);
        }else{
            throw new Error("A tese só pode ter um autor");
        }
    }


}
