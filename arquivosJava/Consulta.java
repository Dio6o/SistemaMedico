import java.time.LocalDate;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private String diagnostico;
    private LocalDate dataConsulta;

    public Consulta(Paciente paciente, Medico medico, String diagnostico) {
        this.paciente = paciente;
        this.medico = medico;
        this.diagnostico = diagnostico;
        this.dataConsulta = LocalDate.now();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        if (paciente != null) {
            this.paciente = paciente;
        }
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        if (medico != null) {
            this.medico = medico;
        }
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        if (diagnostico != null && !diagnostico.isBlank()) {
            this.diagnostico = diagnostico;
        }
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data da Consulta: ").append(dataConsulta).append("\n");
        sb.append("Paciente: ").append(paciente.getNome()).append("\n");
        sb.append("Médico: ").append(medico.getNome()).append("\n");
        sb.append("Diagnóstico: ").append(diagnostico).append("\n");
        sb.append("Prioridade: ").append(paciente.getPrioridade() != null ? paciente.getPrioridade().toUpperCase() : "Não definida").append("\n");
        return sb.toString();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Consulta{");
        sb.append("paciente=").append(getPaciente());
        sb.append(", medico=").append(getMedico());
        sb.append(", diagnostico='").append(getDiagnostico()).append('\'');
        sb.append(", dataConsulta=").append(getDataConsulta());
        sb.append('}');
        return sb.toString();
    }
}
