package pessoas;

import locacao.Locacao;
import publicacoes.Publicacao;

import java.util.ArrayList;
import java.util.Date;

import biblioteca.Biblioteca;

public abstract class Pessoa {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private ArrayList<Locacao> locacoes;
    private ArrayList<Locacao> historicoLocacoes;
    private int limiteRenovacao;

    public Pessoa(String nome, String telefone, String email, String cpf, int limiteRenovacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.limiteRenovacao = limiteRenovacao;
        this.locacoes = new ArrayList<Locacao>();
        this.historicoLocacoes = new ArrayList<Locacao>();
    }

    public Boolean devolverLivro(Publicacao Publicacao) {
        Locacao locacao = getLocacao(Publicacao);

        if (locacao == null) {
            throw new Error("Publicação não encontrada para devolução");
        }

        // Encontrar a locacao que tem essa publicacao

        if (!locacao.devolucao()) {
            return false;
        }

        // Verificar se esse usuário locou a publicacao

        this.locacoes.remove(locacao);

        return true;
    }

    public Boolean renovarLivro(Publicacao publicacao, Date dataDevolucao) {
        Locacao locacao = this.getLocacao(publicacao);

        if(locacao == null) {
            throw new Error("Publicação não encontrada para renovação");
        }

        return locacao.renovar(this.limiteRenovacao, dataDevolucao);
    }

    public Boolean locarLivro(Publicacao publicacao, Biblioteca biblioteca, Date dataDevolucao) {
        Locacao locacao = new Locacao(publicacao, biblioteca, dataDevolucao, this);
        this.locacoes.add(locacao);
        this.historicoLocacoes.add(locacao);
        return true;
    }

    public ArrayList<String> getTituloLocadas() {
        ArrayList<String> titulos = new ArrayList<String>();

        for (int i = 0; i < this.locacoes.size(); i++) {
            titulos.add(this.locacoes.get(i).getPublicacao().getTitulo());
        }

        return titulos;
    }

    protected ArrayList<Locacao> getLotacoes() {
        return this.locacoes;
    }

    private Locacao getLocacao(Publicacao searchPublicacao) {
        Locacao locacao;

        for (int i = 0; i < this.locacoes.size(); i++) {
            if (this.locacoes.get(i).getPublicacao().equals(searchPublicacao)) {
                locacao = this.locacoes.get(i);
                return locacao;
            }
        }

        return null;

    }

}
