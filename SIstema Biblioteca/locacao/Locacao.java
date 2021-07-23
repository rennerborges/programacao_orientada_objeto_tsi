package locacao;

import java.util.Date;
import java.util.ArrayList;

import biblioteca.Biblioteca;
import pessoas.Pessoa;
import publicacoes.Publicacao;

public class Locacao {
    private Date dataLocacao;
    private Date dataPrevistaDevolucao;
    private Date dataDevolucao;
    private double multa;
    private Publicacao publicacao;
    private Biblioteca biblioteca;
    private ArrayList<Renovacao> renovacoes;
    private String status;
    private Pessoa pessoa;

    public Locacao(Publicacao publicacao, Biblioteca biblioteca, Date dataPrevistaDevolucao, Pessoa pessoa) {

        if (!publicacao.getDisponivel()) {
            throw new Error("Essa publicação já está locada");
        }

        // Compararar se a dataPrevistaDevolucao é maior que a atual;

        this.publicacao = publicacao;
        this.biblioteca = biblioteca;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.pessoa = pessoa;
        this.dataLocacao = new Date();
        this.status = "ativa";

        this.publicacao.alterStatus();
    }

    public Boolean devolucao() {

        if (this.status == "devolvido") {
            throw new Error("Essa publicação já foi devolvida");
        }

        if (this.multa != 0) {
            System.out.println("Você possui uma multa no valor de R$:" + this.multa);
            return false;
        }
        // Verificar se foi entregue na data correta;
        // Caso não, chamar o metodo calculoMulta;

        this.status = "devolvido";
        this.publicacao.alterStatus();

        return true;
    }

    public Boolean renovar(int limite, Date newDateDevolucao) {

        if (this.status == "devolvido") {
            throw new Error("Essa publicação já foi devolvida");
        }

        if (renovacoes.size() > limite) {
            int renovacoesExtra = renovacoes.size() - limite;
            this.multa = this.publicacao.getValorMulta() * renovacoesExtra;
        }

        Renovacao renovacao = new Renovacao(newDateDevolucao);
        renovacoes.add(renovacao);
        this.dataDevolucao = newDateDevolucao;

        return true;
    }

    private void calculoMulta(int diasAtraso) {
        this.multa = diasAtraso * 5;
    }

    public Publicacao getPublicacao() {
        return this.publicacao;
    }

}
