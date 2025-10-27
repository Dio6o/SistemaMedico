import java.util.Scanner;

public class Medico extends Pessoa {
    private String setor;
    private String idFuncionario;

    public Medico() {}

    public Medico(String nome, String cpf, String idFuncionario, String setor) {
        super(nome, cpf);
        this.idFuncionario = idFuncionario;
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        if (setor != null && !setor.isBlank()) {
            this.setor = setor;
        } else {
            this.setor = "Clínico Geral";
        }
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        if (idFuncionario != null && !idFuncionario.isBlank()) {
            this.idFuncionario = idFuncionario;
        } else {
            System.out.println("ID de funcionário inválido!");
        }
    }

    public String examinar(Paciente paciente) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n=== Consulta Médica ===");
        System.out.printf("Paciente: %s\n", paciente.getNome());
        System.out.print("Diagnóstico: ");
        String diagnostico = input.nextLine();
        return diagnostico;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Medico{");
        sb.append("setor='").append(getSetor()).append('\'');
        sb.append(", idFuncionario='").append(getIdFuncionario()).append('\'');
        sb.append(", nome='").append(getNome()).append('\'');
        sb.append(", cpf='").append(getCpf()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}