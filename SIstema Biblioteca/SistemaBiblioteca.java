
import java.math.BigInteger;
import java.util.ArrayList;
import java.time.LocalDate;
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

        LocalDate dataDomQuixote = LocalDate.now();

        Livro domQuixote = new Livro("Livro do século", "Saraiva", 444545456, "Dom Quixote", dataDomQuixote, 20);

        Livro pequenoPrincipe = new Livro("Livro do século", "Saraiva", 545487, "PequenoPrincipe", dataDomQuixote, 5);

        Livro lady = new Livro("Livro do século", "Saraiva", 7867863, "lady", dataDomQuixote, 5);

        Livro lobos = new Livro("Livro do século", "Saraiva", 2342343, "lobos", dataDomQuixote, 5);

        Biblioteca biblioteca = new Biblioteca("Alexandria", "Morrinhos", "Goías", "Brasil", "Rua x");

        biblioteca.addPublicacao(domQuixote);
        biblioteca.removePublicacao(domQuixote);

        renner.locarLivro(domQuixote, biblioteca);
        // Verificar se é possivel fazer duas locações para o mesmo livro
        // marcel.locarLivro(domQuixote, biblioteca);
        renner.locarLivro(pequenoPrincipe, biblioteca);
        renner.locarLivro(lady, biblioteca);
        // Esse verifica o máximo de locações simultaneas
        // renner.locarLivro(lobos, biblioteca);

        // renner.devolverLivro(domQuixote);
        // renner.locarLivro(lobos, biblioteca);
        System.out.println(renner.getTituloLocadas());

        renner.renovarLivro(domQuixote);
        renner.renovarLivro(domQuixote);
        renner.renovarLivro(domQuixote);
        renner.renovarLivro(domQuixote);
        renner.renovarLivro(domQuixote);
        renner.renovarLivro(domQuixote);

        renner.devolverLivro(domQuixote);
        // renner.devolverLivro(domQuixote);
    }
}
