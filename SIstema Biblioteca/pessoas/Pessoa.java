package pessoas;

import locacao.Locacao;
import publicacoes.Publicacao;

import java.util.ArrayList;

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
        // Encontrar a locacao que tem essa publicacao
        Locacao locacao = getLocacao(Publicacao);

        // Verificar se esse usuário locou a publicacao
        if (locacao == null) {
            throw new Error("Publicação não encontrada para devolução");
        }

        if (!locacao.devolucao()) {
            return false;
        }

        this.locacoes.remove(locacao);

        return true;
    }

    public Boolean renovarLivro(Publicacao publicacao) {
        Locacao locacao = this.getLocacao(publicacao);

        if(locacao == null) {
            throw new Error("Publicação não encontrada para renovação");
        }

        return locacao.renovar(this.limiteRenovacao);
    }

    public Boolean locarLivro(Publicacao publicacao, Biblioteca biblioteca) {
        Locacao locacao = new Locacao(publicacao, biblioteca, this);
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
