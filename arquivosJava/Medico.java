import java.util.Scanner;

public class Medico extends Pessoa {
    private String idFuncionario;
    private String setor;

    public Medico(String nome, String cpf, String idFuncionario, String setor) {
        super(nome, cpf);
        this.idFuncionario = idFuncionario;
        this.setor = setor;
    }

    public void realizarConsulta(Scanner input, FilaAtendimento fila) {
        if (fila.estaVazia()) {
            System.out.println("\n(Dr. " + getNome() + " checou: Não há pacientes na fila.)");
            return;
        }

        Paciente paciente = fila.proximoPaciente();
        System.out.println("\n--- Consulta Iniciada ---");
        System.out.println("Chamando paciente: " + paciente.getNome() + " (Prioridade: " + paciente.getPrioridade().toUpperCase() + ")");

        String diagnostico = examinar(input, paciente);

        Consulta consulta = new Consulta(paciente, this, diagnostico);
        if (paciente.getProntuario().isEmpty()) {
            paciente.adicionarProntuario(new Prontuario());
        }
        paciente.getProntuario().get(0).adicionarConsulta(consulta);

        System.out.println("Consulta finalizada e registrada no prontuário de " + paciente.getNome() + ".");
    }

    private String examinar(Scanner input, Paciente paciente) {
        System.out.printf("Examinando paciente: %s\n", paciente.getNome());
        System.out.print("Diagnóstico do Dr. " + getNome() + ": ");
        return input.nextLine();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Medico{");
        sb.append("idFuncionario='").append(idFuncionario).append('\'');
        sb.append(", setor='").append(setor).append('\'');
        sb.append(", nome='").append(getNome()).append('\'');
        sb.append(", cpf='").append(getCpf()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}