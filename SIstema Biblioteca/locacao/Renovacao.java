package locacao;

import java.util.Date;

public class Renovacao {
    private Date dataRenovacao;
    private Date dataDevolucao;

    public Renovacao(Date dataDevolucao) {

        // Validar se as datas são validas;

        this.dataRenovacao = new Date();
        this.dataDevolucao = dataDevolucao;
    }
}
