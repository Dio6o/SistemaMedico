import java.util.Date;

public class Atendimento {

    private Date dataAtendimento;
    private Enum classificacaoAtendimento;

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Enum getClassificacaoAtendimento() {
        return classificacaoAtendimento;
    }

    public void setClassificacaoAtendimento(Enum classificacaoAtendimento) {
        this.classificacaoAtendimento = classificacaoAtendimento;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atendimento{");
        sb.append("dataAtendimento=").append(dataAtendimento);
        sb.append(", classificacaoAtendimento=").append(classificacaoAtendimento);
        sb.append('}');
        return sb.toString();
    }

}
