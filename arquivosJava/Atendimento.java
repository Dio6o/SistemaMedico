
public class Atendimento {


    private String dataAtendimento;

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atendimento{");
        sb.append("dataAtendimento=").append(dataAtendimento);
        sb.append('}');
        return sb.toString();
    }

}
