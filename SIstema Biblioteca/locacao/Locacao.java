package locacao;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import biblioteca.Biblioteca;
import pessoas.Pessoa;
import publicacoes.Publicacao;

public class Locacao {
    private LocalDate dataLocacao;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private double multa;
    private Publicacao publicacao;
    private Biblioteca biblioteca;
    private ArrayList<Renovacao> renovacoes;
    private String status;
    private Pessoa pessoa;

    public Locacao(Publicacao publicacao, Biblioteca biblioteca, Pessoa pessoa) {

        if (!publicacao.getDisponivel()) {
            throw new Error("Essa publicação já está locada");
        }

        if (pessoa.getLimiteLocacoes() > 0 && pessoa.getLocacoes().size() > pessoa.getLimiteLocacoes() - 1) {
            throw new Error("Você já locou o máximo de livros, devolva-os antes de locar o próximo");
        }

        pessoa.addLocacao(this);

        this.publicacao = publicacao;
        this.biblioteca = biblioteca;
        this.dataPrevistaDevolucao = LocalDate.now().plus(Period.ofDays(10));
        this.pessoa = pessoa;
        this.dataLocacao = LocalDate.now();
        this.status = "ativa";
        this.renovacoes = new ArrayList<Renovacao>();
        this.multa = 0;
        this.publicacao.alterStatus();
    }

    public void devolucao() {

        if (this.status == "devolvido") {
            throw new Error("Essa publicação já foi devolvida");
        }

        LocalDate dataDevolucao;

        if(this.renovacoes.size() > 0){
            int index = this.renovacoes.size()-1;
            dataDevolucao = this.renovacoes.get(index).getDataDevolucao();
        }else{
            dataDevolucao = this.dataPrevistaDevolucao;
        }

        Period period = Period.between(LocalDate.now(), dataDevolucao);
        int diferenca = Math.abs(period.getDays());

        if(diferenca < 0){
            calculoMulta(Math.abs(diferenca));
        }

        if (this.multa != 0) {
            System.out.println("Você possui uma multa no valor de R$:" + this.multa);
        }

        this.status = "devolvido";
        this.publicacao.alterStatus();

        System.out.println("Devolução feita com sucesso!");
        this.pessoa.removeLocacao(this);
    }

    public Boolean renovar() {

        if (this.status == "devolvido") {
            throw new Error("Essa publicação já foi devolvida");
        }

        LocalDate novaDataDevolucao = LocalDate.now().plus(Period.ofDays(10));

        if (this.renovacoes.size() >= this.pessoa.getLimiteRenovacoes()) {
            int renovacoesExtra = this.renovacoes.size() - (this.pessoa.getLimiteRenovacoes() -1);
            this.multa = this.publicacao.getValorMulta() * renovacoesExtra;
            System.out.println("Essa é a renovação " +  (renovacoes.size() +1) + ", seu limite era de " + this.pessoa.getLimiteRenovacoes() + " a multa total da locação é de R$:" + this.multa);
        }

        Renovacao renovacao = new Renovacao(novaDataDevolucao);
        this.renovacoes.add(renovacao);

        return true;
    }

    private void calculoMulta(int diasAtraso) {
        this.multa += diasAtraso * this.publicacao.getValorMulta();
    }

    public Publicacao getPublicacao() {
        return this.publicacao;
    }

}
