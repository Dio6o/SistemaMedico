import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner input = new Scanner(System.in);
    private List<Paciente> fila = new ArrayList<>();
    private List<Paciente> pacientesCadastrados = new ArrayList<>();
    private Enfermeiro enfermeiro = new Enfermeiro("Clara", "123456789", "E001", "Triagem");
    private Medico medico = new Medico("Dr. Silva", "987654321", "M001", "Clínico Geral");
    private Atendente atendente = new Atendente("Ana", "11122233344", "A001", "Recepção");

    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.iniciar();
    }

    private void iniciar() {
        // Adicionando pacientes já com prioridades
        inicializarFila();

        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE ATENDIMENTO MÉDICO ===");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Realizar Triagem");
            System.out.println("3. Realizar Consulta");
            System.out.println("4. Visualizar Prontuário");
            System.out.println("5. Listar Pacientes na Fila");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1 -> cadastrarPaciente();
                case 2 -> realizarTriagem();
                case 3 -> realizarConsulta();
                case 4 -> visualizarProntuario();
                case 5 -> listarFila();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
    }

    private void inicializarFila() {
        Paciente p1 = new Paciente("Pedro Amaral", "11111111111", "O+", "Nenhuma");
        p1.definirPrioridade("vermelho");
        Paciente p2 = new Paciente("Diogo Machado", "22222222222", "A-", "Asma");
        p2.definirPrioridade("amarelo");
        Paciente p3 = new Paciente("Kauan Scheidt", "33333333333", "B+", "Nenhuma");
        p3.definirPrioridade("verde");
        Paciente p4 = new Paciente("Carlos Silva", "44444444444", "AB+", "Alergia a penicilina");
        p4.definirPrioridade("azul");
        Paciente p5 = new Paciente("Rafael Sardinha", "55555555555", "O-", "Nenhuma");
        p5.definirPrioridade("amarelo");

        fila.add(p1);
        fila.add(p2);
        fila.add(p3);
        fila.add(p4);
        fila.add(p5);

        pacientesCadastrados.addAll(fila);
    }

    private void cadastrarPaciente() {
        System.out.println("\n=== CADASTRO DE PACIENTE ===");
        Paciente paciente = atendente.cadastrarPaciente(input);
        pacientesCadastrados.add(paciente);
        fila.add(paciente);
    }

    private void realizarTriagem() {
        if (fila.isEmpty()) {
            System.out.println("Não há pacientes na fila.");
            return;
        }

        Paciente paciente = selecionarPacienteFila();
        if (paciente == null) return;

        paciente.definirPrioridade(enfermeiro.realizarTriagem(input, paciente));
        organizarFilaPorPrioridade();
    }

    private void realizarConsulta() {
        if (fila.isEmpty()) {
            System.out.println("Não há pacientes na fila.");
            return;
        }

        Paciente paciente = selecionarPacienteFila();
        if (paciente == null) return;

        System.out.println("\n=== CONSULTA ===");
        String diagnostico = medico.examinar(paciente);

        Consulta consulta = new Consulta(paciente, medico, diagnostico);
        // Adiciona ao prontuário do paciente
        if (paciente.getProntuario().isEmpty()) {
            paciente.adicionarProntuario(new Prontuario());
        }
        paciente.getProntuario().get(0).adicionarConsulta(consulta);

        // Remove da fila
        fila.remove(paciente);
        System.out.println("Consulta concluída e paciente removido da fila.");
    }

    private void visualizarProntuario() {
        Paciente paciente = selecionarPacienteCadastrado();
        if (paciente == null) return;

        System.out.println("\n=== PRONTUÁRIO DE " + paciente.getNome().toUpperCase() + " ===");
        if (!paciente.getProntuario().isEmpty()) {
            paciente.getProntuario().get(0).listarConsultas();
        } else {
            System.out.println("Nenhuma consulta registrada.");
        }
    }

    private void listarFila() {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }

        System.out.println("\n=== PACIENTES NA FILA ===");
        for (int i = 0; i < fila.size(); i++) {
            Paciente p = fila.get(i);
            System.out.printf("%d. %s - Prioridade: %s\n", i + 1, p.getNome(), p.getPrioridade());
        }
    }

    private Paciente selecionarPacienteFila() {
        listarFila();
        System.out.print("Selecione o número do paciente: ");
        int indice = Integer.parseInt(input.nextLine()) - 1;
        if (indice < 0 || indice >= fila.size()) {
            System.out.println("Paciente inválido!");
            return null;
        }
        return fila.get(indice);
    }

    private Paciente selecionarPacienteCadastrado() {
        if (pacientesCadastrados.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return null;
        }

        for (int i = 0; i < pacientesCadastrados.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, pacientesCadastrados.get(i).getNome());
        }

        System.out.print("Selecione o número do paciente: ");
        int indice = Integer.parseInt(input.nextLine()) - 1;
        if (indice < 0 || indice >= pacientesCadastrados.size()) {
            System.out.println("Paciente inválido!");
            return null;
        }

        return pacientesCadastrados.get(indice);
    }

    private void organizarFilaPorPrioridade() {
        fila.sort((p1, p2) -> {
            List<String> ordem = List.of("vermelho", "amarelo", "verde", "azul");
            int i1 = ordem.indexOf(p1.getPrioridade());
            int i2 = ordem.indexOf(p2.getPrioridade());
            return Integer.compare(i1, i2);
        });
    }
}
