public abstract class Pessoa {
    private String nome;
    private String sobrenome;
    private int anoNascimento;
    private String maternidade;
    private String paternidade;

    public Pessoa(String nome, String sobrenome, int anoNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.anoNascimento = anoNascimento;
    }

    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }

    public int getAnoNascimento() {
        return this.anoNascimento;
    }

}
