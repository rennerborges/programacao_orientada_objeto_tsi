package pessoas;

import java.util.Date;

import biblioteca.Biblioteca;
import publicacoes.Publicacao;

public class PessoaComum extends Pessoa {
    private int limiteEmprestimo;

    public PessoaComum(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf, 3);
        this.limiteEmprestimo = 3;
    }

    public Boolean locarLivro(Publicacao publicacao, Biblioteca biblioteca, Date dataDevolucao) {
        System.out.println(super.getLotacoes().size());
        if (super.getLotacoes().size() <= this.limiteEmprestimo - 1) {
            return super.locarLivro(publicacao, biblioteca, dataDevolucao);
        } else {
            throw new Error("Você já locou o máximo de livros, devolva-os antes de locar o próximo");
        }
    }

}
