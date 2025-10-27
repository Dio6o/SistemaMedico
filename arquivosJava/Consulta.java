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
        sb.append("paciente=").append(paciente);
        sb.append(", medico=").append(medico);
        sb.append(", diagnostico='").append(diagnostico).append('\'');
        sb.append(", dataConsulta=").append(dataConsulta);
        sb.append('}');
        return sb.toString();
    }
}
