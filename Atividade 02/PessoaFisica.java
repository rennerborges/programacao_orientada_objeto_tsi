import java.math.BigInteger;


public class PessoaFisica extends Pessoa {

    private BigInteger cpf;


    public PessoaFisica(String nome, String sobrenome, BigInteger cpf, int anoNascimento){
        super(nome, sobrenome, anoNascimento);
        this.cpf = cpf;
    }

    public BigInteger getCpf(){
        return this.cpf;
    }

}
