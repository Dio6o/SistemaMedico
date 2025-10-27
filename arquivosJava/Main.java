import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Atendente atendente = new Atendente("Atendente", "00000000000", "A001", "Recepção");
        Enfermeiro enfermeiro = new Enfermeiro("Enfermeiro", "00000000000", "E001", "Triagem");
        Medico medico = new Medico("Medico", "00000000000", "M001", "Clínico Geral");

        GerenciadorHospital ger = new GerenciadorHospital(input, atendente, enfermeiro, medico);
        ger.carregarPacientesPadrao();

        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE ATENDIMENTO ===");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Realizar triagem (pacientes pendentes)");
            System.out.println("3 - Realizar consulta (próximo da fila)");
            System.out.println("4 - Visualizar prontuário");
            System.out.println("5 - Listar fila");
            System.out.println("6 - Listar todos os pacientes");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> ger.cadastrarPaciente();
                case 2 -> ger.realizarTriagem();
                case 3 -> ger.realizarConsulta();
                case 4 -> ger.visualizarProntuario();
                case 5 -> ger.listarFila();
                case 6 -> ger.listarTodosPacientes();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        input.close();
    }
}
