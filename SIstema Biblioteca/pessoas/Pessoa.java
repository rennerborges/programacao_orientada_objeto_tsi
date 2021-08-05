package pessoas;

import locacao.Locacao;

import java.util.ArrayList;


public abstract class Pessoa {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private ArrayList<Locacao> locacoes;
    private ArrayList<Locacao> historicoLocacoes;
    private int limiteRenovacao;
    private int limiteLocacoes;

    public Pessoa(String nome, String telefone, String email, String cpf, int limiteRenovacao, int limiteLocacoes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.limiteRenovacao = limiteRenovacao;
        this.limiteLocacoes = limiteLocacoes;
        this.locacoes = new ArrayList<Locacao>();
        this.historicoLocacoes = new ArrayList<Locacao>();
    }

    public int getLimiteLocacoes(){
        return this.limiteLocacoes;
    }

    public int getLimiteRenovacoes(){
        return this.limiteRenovacao;
    }

    public void removeLocacao(Locacao locacao) {
        for (int i = 0; i < this.locacoes.size(); i++) {
            if (this.locacoes.get(i).equals(locacao)) {
                this.locacoes.remove(i);
            }
        }
    }

    public void addLocacao(Locacao locacao) {
        this.locacoes.add(locacao);
    }

    public ArrayList<String> getTituloLocadas() {
        ArrayList<String> titulos = new ArrayList<String>();

        for (int i = 0; i < this.locacoes.size(); i++) {
            titulos.add(this.locacoes.get(i).getPublicacao().getTitulo());
        }

        return titulos;
    }

    public ArrayList<Locacao> getLocacoes() {
        return this.locacoes;
    }

}
