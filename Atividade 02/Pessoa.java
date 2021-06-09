import java.math.BigInteger;


public class Pessoa {
    private String nome;
    private String sobrenome;
    private BigInteger cpf;
    private int anoNascimento;
    private String maternidade;
    private String paternidade;

    public Pessoa(String nome, String sobrenome, BigInteger cpf, int anoNascimento){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.anoNascimento = anoNascimento;
    }

    public String getNomeCompleto(){
        return this.nome + " " + this.sobrenome;
    }

    public BigInteger getCpf(){
        return this.cpf;
    }

    public int getAnoNascimento(){
        return this.anoNascimento;
    }

}
