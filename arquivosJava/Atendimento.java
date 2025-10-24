
public class Atendimento {

    public enum ClassificacaoAtendimento {
        EMERGENCIA,
        URGENTE,
        POUCO_URGENTE,
        NAO_URGENTE,
    }

    private String dataAtendimento;
    private ClassificacaoAtendimento classificacaoAtendimento;

    public Atendimento(String dataAtendimento, ClassificacaoAtendimento classificacaoAtendimento) {
        setDataAtendimento(dataAtendimento);
        setClassificacaoAtendimento(classificacaoAtendimento);
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public ClassificacaoAtendimento getClassificacaoAtendimento() {
        return classificacaoAtendimento;
    }

    public void setClassificacaoAtendimento(ClassificacaoAtendimento classificacaoAtendimento) {
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
