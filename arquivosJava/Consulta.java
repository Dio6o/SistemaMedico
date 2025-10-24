public class Consulta {
    private Paciente paciente;
    private String temperatura;
    private String bpm;
    private String diagnostico;
    private String triagem;

    public Consulta() {}

    public Consulta(Paciente paciente, String temperatura, String bpm, String diagnostico, String triagem) {
        this.paciente = paciente;
        this.temperatura = temperatura;
        this.bpm = bpm;
        this.diagnostico = diagnostico;
        this.triagem = triagem;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTriagem() {
        return triagem;
    }

    public void setTriagem(String triagem) {
        this.triagem = triagem;
    }

    public String gerarRelatorio() {
        return "----------------------------\n" +
                "       PRONTUÁRIO MÉDICO      \n" +
                "----------------------------\n" +
                "Nome: " + paciente.getNome() + "\n" +
                "CPF: " + paciente.getCpf() + "\n" +
                "Tipo Sanguíneo: " + paciente.getTipoSangue() + "\n" +
                "Alergias: " + paciente.getAlergias() + "\n" +
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
        sb.append("paciente=").append(getPaciente());
        sb.append(", temperatura='").append(getTemperatura()).append('\'');
        sb.append(", bpm='").append(getBpm()).append('\'');
        sb.append(", diagnostico='").append(getDiagnostico()).append('\'');
        sb.append(", triagem='").append(getTriagem()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}



