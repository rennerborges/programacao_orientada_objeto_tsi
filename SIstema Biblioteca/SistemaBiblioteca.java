
import java.math.BigInteger;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

import autor.Autor;
import biblioteca.Biblioteca;
import locacao.Locacao;
import pessoas.*;
import publicacoes.*;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        PessoaComum renner = new PessoaComum("Renner Borges", "(64)9999-9999", "teste@gmail.com", "000.000.000-00");
        PessoaEspecial marcel = new PessoaEspecial("Marcel Melo", "(64)9999-9999", "teste@gmail.com", "000.000.000-00");

        ArrayList<Autor> autores = new ArrayList<Autor>();
        Autor miguelCervantes = new Autor("Miguel de Cervantes", "Doutor");
        autores.add(miguelCervantes);

        LocalDate dataDomQuixote = LocalDate.now();

        Livro domQuixote = new Livro("Livro do século", "Saraiva", 444545456, "Dom Quixote", dataDomQuixote, 20);

        Livro pequenoPrincipe = new Livro("Livro do século", "Saraiva", 545487, "PequenoPrincipe", dataDomQuixote, 5);

        Livro lady = new Livro("Livro do século", "Saraiva", 7867863, "lady", dataDomQuixote, 5);

        Livro lobos = new Livro("Livro do século", "Saraiva", 2342343, "lobos", dataDomQuixote, 5);

        Biblioteca biblioteca = new Biblioteca("Alexandria", "Morrinhos", "Goías", "Brasil", "Rua x");

        biblioteca.addPublicacao(domQuixote);
        // biblioteca.removePublicacao(domQuixote);

        Locacao renner1 = new Locacao(domQuixote, biblioteca, renner);
        Locacao renner2 = new Locacao(pequenoPrincipe, biblioteca, renner);
        Locacao renner3 = new Locacao(lady, biblioteca, renner);
        // Locacao renner4 = new Locacao(lobos, biblioteca, renner);

        renner1.renovar();
        renner1.renovar();
        renner1.renovar();
        renner1.renovar();

        renner2.devolucao();
        renner3.devolucao();
        

        // Locacao marcel1 = new Locacao(domQuixote, biblioteca, marcel);
        Locacao marcel2 = new Locacao(pequenoPrincipe, biblioteca, marcel);
        Locacao marcel3 = new Locacao(lady, biblioteca, marcel);
        Locacao marcel4 = new Locacao(lobos, biblioteca, marcel);

        System.out.println("Renner" + renner.getTituloLocadas());
        System.out.println("Marcel" + marcel.getTituloLocadas());



    }
}
