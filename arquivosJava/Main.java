import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Paciente> todosPacientes = new ArrayList<>(); // Lista completa
    private static final List<Paciente> fila = new ArrayList<>();           // Fila de atendimento
    private static final Enfermeiro enfermeiro = new Enfermeiro("Clara", "123456", "E001", "Triagem");
    private static final Medico medico = new Medico("João", "789012", "M001", "Clínico Geral");
    private static final Atendente atendente = new Atendente("Mariana", "456789", "A001", "Recepção");

    public static void main(String[] args) {
        inicializarPacientes();

        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE ATENDIMENTO MÉDICO ===");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Realizar Triagem");
            System.out.println("3. Realizar Consulta");
            System.out.println("4. Visualizar Prontuário");
            System.out.println("5. Listar Pacientes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarPaciente();
                case 2 -> realizarTriagem();
                case 3 -> realizarConsulta();
                case 4 -> visualizarProntuario();
                case 5 -> listarFila();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void inicializarPacientes() {
        Paciente p1 = new Paciente("Pedro Amaral", "111.111.111-11", "A+", "Nenhuma");
        p1.definirPrioridade("vermelho");
        Paciente p2 = new Paciente("Diogo Machado", "222.222.222-22", "B-", "Pólen");
        p2.definirPrioridade("amarelo");
        Paciente p3 = new Paciente("Kauan Scheidt", "333.333.333-33", "O+", "Nenhuma");
        p3.definirPrioridade("verde");
        Paciente p4 = new Paciente("Carlos Silva", "444.444.444-44", "AB+", "Amendoim");
        p4.definirPrioridade("azul");
        Paciente p5 = new Paciente("Rafael Sardinha", "555.555.555-55", "A-", "Nenhuma");
        p5.definirPrioridade("amarelo");

        todosPacientes.add(p1);
        todosPacientes.add(p2);
        todosPacientes.add(p3);
        todosPacientes.add(p4);
        todosPacientes.add(p5);

        fila.addAll(todosPacientes);
    }

    private static void cadastrarPaciente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Tipo sanguíneo: ");
        String tipoSangue = scanner.nextLine();
        System.out.print("Alergias: ");
        String alergias = scanner.nextLine();

        Paciente paciente = new Paciente(nome, cpf, tipoSangue, alergias);
        todosPacientes.add(paciente);
        fila.add(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void realizarTriagem() {
        if (fila.isEmpty()) {
            System.out.println("Nenhum paciente na fila para triagem.");
            return;
        }

        Paciente paciente = selecionarPacienteFila();
        if (paciente == null) return;

        enfermeiro.realizarTriagem(scanner, paciente);
        ordenarFilaPorPrioridade();
    }

    private static void realizarConsulta() {
        if (fila.isEmpty()) {
            System.out.println("Nenhum paciente na fila para consulta.");
            return;
        }

        Paciente paciente = selecionarPacienteFila();
        if (paciente == null) return;

        String diagnostico = medico.examinar(paciente);
        Consulta consulta = new Consulta(paciente, medico, diagnostico);

        if (paciente.getProntuario().isEmpty()) {
            paciente.adicionarProntuario(new Prontuario());
        }
        paciente.getProntuario().get(0).adicionarConsulta(consulta);

        System.out.println("Consulta adicionada ao prontuário de " + paciente.getNome());

        fila.remove(paciente);
        System.out.println("Paciente " + paciente.getNome() + " removido da fila.");
    }

    private static void visualizarProntuario() {
        if (todosPacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        listarTodosPacientes();
        System.out.print("Selecione o número do paciente: ");
        int indice = Integer.parseInt(scanner.nextLine()) - 1;

        if (indice < 0 || indice >= todosPacientes.size()) {
            System.out.println("Paciente inválido!");
            return;
        }

        Paciente paciente = todosPacientes.get(indice);
        System.out.println("\n=== PRONTUÁRIO DE " + paciente.getNome().toUpperCase() + " ===");

        if (paciente.getProntuario().isEmpty()) {
            System.out.println("Nenhum prontuário registrado.");
            return;
        }

        paciente.getProntuario().get(0).listarConsultas();
    }

    private static void listarFila() {
        if (fila.isEmpty()) {
            System.out.println("Fila de atendimento vazia.");
            return;
        }

        ordenarFilaPorPrioridade();

        System.out.println("\n=== FILA DE PACIENTES (POR PRIORIDADE) ===");
        for (int i = 0; i < fila.size(); i++) {
            Paciente p = fila.get(i);
            System.out.printf("%d. %s - Tipo Sanguíneo: %s - Alergias: %s - Prioridade: %s\n",
                    i + 1, p.getNome(), p.getTipoSangue(), p.getAlergias(),
                    p.getPrioridade() != null ? p.getPrioridade() : "Não definida");
        }
    }

    private static Paciente selecionarPacienteFila() {
        listarFila();
        System.out.print("Selecione o número do paciente: ");
        int indice = Integer.parseInt(scanner.nextLine()) - 1;

        if (indice < 0 || indice >= fila.size()) {
            System.out.println("Paciente inválido!");
            return null;
        }

        return fila.get(indice);
    }

    private static void listarTodosPacientes() {
        System.out.println("\n=== LISTA DE TODOS OS PACIENTES ===");
        for (int i = 0; i < todosPacientes.size(); i++) {
            Paciente p = todosPacientes.get(i);
            System.out.printf("%d. %s - Tipo Sanguíneo: %s - Alergias: %s - Prioridade: %s\n",
                    i + 1, p.getNome(), p.getTipoSangue(), p.getAlergias(),
                    p.getPrioridade() != null ? p.getPrioridade() : "Não definida");
        }
    }

    private static void ordenarFilaPorPrioridade() {
        fila.sort(Comparator.comparingInt(Main::valorPrioridade));
    }

    private static int valorPrioridade(Paciente paciente) {
        if (paciente.getPrioridade() == null) return 5;
        return switch (paciente.getPrioridade().toLowerCase()) {
            case "vermelho" -> 1;
            case "amarelo" -> 2;
            case "verde" -> 3;
            case "azul" -> 4;
            default -> 5;
        };
    }
}
