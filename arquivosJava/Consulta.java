public class Consulta {

    private String diagnostico;

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Consulta{");
        sb.append("diagnostico='").append(diagnostico).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
