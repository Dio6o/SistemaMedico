import java.util.List;
import java.util.Scanner;

public class Atendente extends Pessoa {
    private String idFuncionario;
    private String setor;


    public Atendente(String nome, String cpf, String idFuncionario, String setor) {
        setNome(nome);
        setCpf(cpf);
        setIdFuncionario(idFuncionario);
        setSetor(setor);
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Paciente cadastrarPaciente(Scanner input) {
        System.out.println("\nCadastro de Paciente:");
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("CPF: ");
        String cpf = input.nextLine();
        System.out.print("Tipo sanguíneo: ");
        String tipoSangue = input.nextLine();
        System.out.print("Alergias: ");
        String alergias = input.nextLine();

        Paciente paciente = new Paciente(nome, cpf, tipoSangue, alergias);
        System.out.println("Paciente cadastrado: " + paciente.getNome());
        return paciente;
    }

    public void visualizarProntuario(Scanner input, List<Paciente> todosPacientes) {
        if (todosPacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado no sistema.");
            return;
        }

        System.out.println("\nVisualizar Prontuário:");
        System.out.println("Qual paciente você deseja consultar?");
        for (int i = 0; i < todosPacientes.size(); i++) {
            Paciente p = todosPacientes.get(i);
            System.out.printf("%d. %s (CPF: %s)\n", i + 1, p.getNome(), p.getCpf());
        }

        System.out.print("Escolha o número do paciente: ");
        int escolha;
        try {
            escolha = Integer.parseInt(input.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Seleção inválida. Digite apenas o número.");
            return;
        }

        if (escolha < 0 || escolha >= todosPacientes.size()) {
            System.out.println("Número de paciente não existe.");
            return;
        }

        Paciente paciente = todosPacientes.get(escolha);
        System.out.println("\nProntuário de " + paciente.getNome());

        if (paciente.getProntuario().isEmpty()) {
            System.out.println("Nenhum registro encontrado para este paciente.");
            return;
        }

        paciente.getProntuario().get(0).listarConsultas();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atendente{");
        sb.append("idFuncionario='").append(idFuncionario).append('\'');
        sb.append(", setor='").append(setor).append('\'');
        sb.append(", nome='").append(getNome()).append('\'');
        sb.append(", cpf='").append(getCpf()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}