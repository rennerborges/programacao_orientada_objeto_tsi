package locacao;

import java.time.LocalDate;

public class Renovacao {
    private LocalDate dataRenovacao;
    private LocalDate dataDevolucao;

    public Renovacao(LocalDate dataDevolucao) {

        this.dataRenovacao = LocalDate.now();
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataDevolucao(){
        return this.dataDevolucao;
    }
}
