
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import autor.Autor;
import biblioteca.Biblioteca;
import pessoas.*;
import publicacoes.*;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        PessoaComum renner = new PessoaComum("Renner Borges", "(64)9999-9999", "teste@gmail.com", "000.000.000-00");
        PessoaEspecial marcel = new PessoaEspecial("Marcel Melo", "(64)9999-9999", "teste@gmail.com", "000.000.000-00");

        ArrayList<Autor> autores = new ArrayList<Autor>();
        Autor miguelCervantes = new Autor("Miguel de Cervantes", "Doutor");
        autores.add(miguelCervantes);

        ArrayList<Publicacao> referenciasDomQuixote = new ArrayList<Publicacao>();
        Date dataDomQuixote = new Date();

        Livro domQuixote = new Livro("Livro do século", "Saraiva", 444545456, "Dom Quixote", referenciasDomQuixote,
                autores, dataDomQuixote, 10);

        Livro pequenoPrincipe = new Livro("Livro do século", "Saraiva", 545487, "PequenoPrincipe",
                referenciasDomQuixote, autores, dataDomQuixote, 5);

        Livro lady = new Livro("Livro do século", "Saraiva", 7867863, "lady", referenciasDomQuixote, autores,
                dataDomQuixote, 5);

        Livro lobos = new Livro("Livro do século", "Saraiva", 2342343, "lobos", referenciasDomQuixote, autores,
                dataDomQuixote, 5);

        Biblioteca biblioteca = new Biblioteca("Alexandria", "Morrinhos", "Goías", "Brasil", "Rua x");

        renner.locarLivro(domQuixote, biblioteca, dataDomQuixote);
        renner.locarLivro(pequenoPrincipe, biblioteca, dataDomQuixote);
        renner.locarLivro(lady, biblioteca, dataDomQuixote);
        // Esse verifica o máximo de locações simultaneas
        // renner.locarLivro(lobos, biblioteca, dataDomQuixote);

        renner.devolverLivro(domQuixote);
        renner.locarLivro(lobos, biblioteca, dataDomQuixote);
        System.out.println(renner.getTituloLocadas());
    }
}
