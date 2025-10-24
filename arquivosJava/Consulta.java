public class Consulta {

    private String diagnostico;

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String prontuario(String nome, String CPF, String tipoSangue, String alergias,
                             String temperatura, String bpm, String diagnostico, String triagem) {
        return "----------------------------\n" +
                "       PRONTUÁRIO MÉDICO      \n" +
                "----------------------------\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + CPF + "\n" +
                "Tipo Sanguíneo: " + tipoSangue + "\n" +
                "Alergias: " + alergias + "\n" +
                "----------------------------\n" +
                "Prioridade:\n" + triagem + "\n" +
                "----------------------------\n" +
                "Sinais Vitais:\n" +
                " - Temperatura: " + temperatura + " °C\n" +
                " - BPM: " + bpm + "\n" +
                "----------------------------\n" +
                "Diagnóstico:\n" +
                diagnostico + "\n" +
                "----------------------------\n";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Consulta{");
        sb.append("diagnostico='").append(diagnostico).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
