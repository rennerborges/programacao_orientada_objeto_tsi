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

    public Boolean devolucao() {

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

        // Verificar se foi entregue na data correta;
        // Caso não, chamar o metodo calculoMulta;
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
        return true;
    }

    public Boolean renovar(int limite) {

        if (this.status == "devolvido") {
            throw new Error("Essa publicação já foi devolvida");
        }

        LocalDate novaDataDevolucao = LocalDate.now().plus(Period.ofDays(10));

        if (renovacoes.size() >= limite) {
            int renovacoesExtra = renovacoes.size() - (limite -1);
            this.multa = this.publicacao.getValorMulta() * renovacoesExtra;
            System.out.println("Essa é a renovação " +  (renovacoes.size() +1) + ", seu limite era de " + limite + " a multa total da locação é de R$:" + this.multa);
        }

        Renovacao renovacao = new Renovacao(novaDataDevolucao);
        renovacoes.add(renovacao);

        return true;
    }

    private void calculoMulta(int diasAtraso) {
        this.multa += diasAtraso * this.publicacao.getValorMulta();
    }

    public Publicacao getPublicacao() {
        return this.publicacao;
    }

}
