import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorHospital {
    private Scanner input =  new Scanner(System.in);
    private Atendente atendente;
    private Enfermeiro enfermeiro;
    private Medico medico;
    private FilaAtendimento fila;
    private List<Paciente> todosPacientes;

    public GerenciadorHospital(Atendente atendente, Enfermeiro enfermeiro, Medico medico) {
        setAtendente(atendente);
        setEnfermeiro(enfermeiro);
        setMedico(medico);
        setFila(new FilaAtendimento());
        setTodosPacientes(new ArrayList<>());
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public FilaAtendimento getFila() {
        return fila;
    }

    public void setFila(FilaAtendimento fila) {
        this.fila = fila;
    }

    public List<Paciente> getTodosPacientes() {
        return todosPacientes;
    }

    public void setTodosPacientes(List<Paciente> todosPacientes) {
        this.todosPacientes = todosPacientes;
    }

    public void carregarPacientesPadrao() {

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
        Paciente p6 = new Paciente("Luan Braun", "999.555.555-55", "O-", "Dipirona");
        p6.definirPrioridade("vermelho");
        Paciente p7 = new Paciente("Luan Jairo", "000.155.999-21", "AB-", "Ovos");
        p7.definirPrioridade("verde");
        Paciente p8 = new Paciente("Luan Da Silva", "123.101.499-21", "AB-", "Ovos");
        p8.definirPrioridade("verde");
        Paciente p9 = new Paciente("Andry Da Rosa", "147.258.369-60", "A+", "Amendoim");
        p9.definirPrioridade("vermelho");
        Paciente p10 = new Paciente("Igor Conaco", "258.369.147-70", "O-", "Nenhuma");
        p10.definirPrioridade("azul");
        Paciente p11 = new Paciente("Eric Drabizinsk", "369.147.258-80", "B+", "Soja");
        p11.definirPrioridade("vermelho");
        Paciente p12 = new Paciente("Kauan Pereira", "111.222.333-44", "A-", "Lactose");
        p12.definirPrioridade("verde");
        Paciente p13 = new Paciente("Larissa Maia", "222.333.444-55", "O+", "Nenhuma");
        p13.definirPrioridade("vermelho");
        Paciente p14 = new Paciente("Bernardo de Andrade", "333.444.555-66", "AB+", "Poeira");
        p14.definirPrioridade("verde");
        Paciente p15 = new Paciente("Nicole Soraia", "444.555.666-77", "A+", "Amendoim");
        p15.definirPrioridade("amarelo");
        Paciente p16 = new Paciente("Guga Capistrano", "555.666.777-88", "O-", "Nenhuma");
        p16.definirPrioridade("verde");
        Paciente p17 = new Paciente("Gabriel Alves", "666.777.888-99", "B-", "Frutos do mar");
        p17.definirPrioridade("amarelo");
        Paciente p18 = new Paciente("Lucas de Souza", "777.888.999-00", "A-", "Nenhuma");
        p18.definirPrioridade("azul");
        Paciente p19 = new Paciente("João Francisco", "888.999.000-11", "O+", "Ovos");
        p19.definirPrioridade("verde");
        Paciente p20 = new Paciente("Max Alves", "999.000.111-22", "AB-", "Nenhuma");
        p20.definirPrioridade("vermelho");

        todosPacientes.add(p1);
        todosPacientes.add(p2);
        todosPacientes.add(p3);
        todosPacientes.add(p4);
        todosPacientes.add(p5);
        todosPacientes.add(p6);
        todosPacientes.add(p7);
        todosPacientes.add(p8);
        todosPacientes.add(p9);
        todosPacientes.add(p10);
        todosPacientes.add(p11);
        todosPacientes.add(p12);
        todosPacientes.add(p13);
        todosPacientes.add(p14);
        todosPacientes.add(p15);
        todosPacientes.add(p16);
        todosPacientes.add(p17);
        todosPacientes.add(p18);
        todosPacientes.add(p19);
        todosPacientes.add(p20);

        fila.adicionarPaciente(p1);
        fila.adicionarPaciente(p2);
        fila.adicionarPaciente(p3);
        fila.adicionarPaciente(p4);
        fila.adicionarPaciente(p5);
        fila.adicionarPaciente(p6);
        fila.adicionarPaciente(p7);
        fila.adicionarPaciente(p8);
        fila.adicionarPaciente(p9);
        fila.adicionarPaciente(p10);
        fila.adicionarPaciente(p11);
        fila.adicionarPaciente(p12);
        fila.adicionarPaciente(p13);
        fila.adicionarPaciente(p14);
        fila.adicionarPaciente(p15);
        fila.adicionarPaciente(p16);
        fila.adicionarPaciente(p17);
        fila.adicionarPaciente(p18);
        fila.adicionarPaciente(p19);
        fila.adicionarPaciente(p20);

    }


    public void cadastrarPaciente() {
        Paciente novo = atendente.cadastrarPaciente(input);
        todosPacientes.add(novo);
    }

    public void realizarTriagem() {

        enfermeiro.realizarTriagem(input, todosPacientes, fila);
    }

    public void realizarConsulta() {
        medico.realizarConsulta(input, fila);
    }

    public void visualizarProntuario() {
        atendente.visualizarProntuario(input, todosPacientes);
    }

    public void listarFila() {
        fila.listarFila();
    }

    public void listarTodosPacientes() {
        System.out.println("\nPacientes no sistema:");
        for (Paciente p : todosPacientes) {
            String prio = p.getPrioridade() != null ? p.getPrioridade().toUpperCase() : "AGUARDANDO TRIAGEM";
            System.out.printf("- %s (CPF: %s) | Status: %s\n", p.getNome(), p.getCpf(), prio);
        }
    }

    public void menu() {

        carregarPacientesPadrao();
        int opcao;

        do {

            System.out.println("\nAtendimento: ");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Realizar triagem (pacientes pendentes)");
            System.out.println("3 - Realizar consulta (por ordem de prioridade)");
            System.out.println("4 - Visualizar prontuário");
            System.out.println("6 - Lista de todos os Pacientes");
            System.out.println("5 - Ver fila");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 0:
                    System.out.println("Programa finalizado!");
                    break;
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    realizarTriagem();
                    break;
                case 3:
                    realizarConsulta();
                    break;
                case 4:
                    visualizarProntuario();
                    break;
                case 5:
                    listarFila();
                    break;
                case 6:
                    listarTodosPacientes();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GerenciadorHospital{");
        sb.append("input=").append(input);
        sb.append(", atendente=").append(atendente);
        sb.append(", enfermeiro=").append(enfermeiro);
        sb.append(", medico=").append(medico);
        sb.append(", fila=").append(fila);
        sb.append(", todosPacientes=").append(todosPacientes);
        sb.append('}');
        return sb.toString();
    }
}