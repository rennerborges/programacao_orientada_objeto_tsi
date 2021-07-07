import java.math.BigInteger;


public class PessoaJuridica extends Pessoa {

    private BigInteger cnpj;


    public PessoaJuridica(String nome, String sobrenome, BigInteger cnpj, int anoNascimento){
        super(nome, sobrenome, anoNascimento);
        this.cnpj = cnpj;
    }

    public BigInteger getCnpj(){
        return this.cnpj;
    }

}
