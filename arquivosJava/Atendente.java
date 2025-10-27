import java.util.Scanner;

public class Atendente extends Pessoa {

    private String idFuncionario;
    private String setor;

    public Atendente() {}

    public Atendente(String nome, String cpf, String idFuncionario, String setor) {
        super(nome, cpf);
        this.idFuncionario = idFuncionario;
        this.setor = setor;
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        if (setor != null && !setor.isBlank()) {
            this.setor = setor;
        } else {
            this.setor = "Recepção";
        }
    }

    public Paciente cadastrarPaciente(Scanner input) {
        System.out.println("=== Cadastro de Paciente ===");

        System.out.print("Nome do paciente: ");
        String nome = input.nextLine();

        System.out.print("CPF: ");
        String cpf = input.nextLine();

        System.out.print("Tipo sanguíneo: ");
        String tipoSangue = input.nextLine();

        System.out.print("Alergias: ");
        String alergias = input.nextLine();

        Paciente paciente = new Paciente(nome, cpf, tipoSangue, alergias);

        System.out.println("Paciente cadastrado com sucesso!\n");
        return paciente;
    }

    public void encaminharParaTriagem(Paciente paciente) {
        System.out.printf("Encaminhando paciente %s para triagem...\n", paciente.getNome());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atendente{");
        sb.append("idFuncionario='").append(getIdFuncionario()).append('\'');
        sb.append(", setor='").append(getSetor()).append('\'');
        sb.append(", nome='").append(getNome()).append('\'');
        sb.append(", cpf='").append(getCpf()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

