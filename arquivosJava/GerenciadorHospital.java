import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorHospital {
    private Scanner input;
    private Atendente atendente;
    private Enfermeiro enfermeiro;
    private Medico medico;
    private FilaAtendimento fila;
    private List<Paciente> todosPacientes;

    public GerenciadorHospital(Scanner input, Atendente atendente, Enfermeiro enfermeiro, Medico medico) {
        setInput(input);
        setAtendente(atendente);
        setEnfermeiro(enfermeiro);
        setMedico(medico);
        setFila(new FilaAtendimento());
        setTodosPacientes(new ArrayList<>());
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
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

        todosPacientes.add(p1);
        todosPacientes.add(p2);
        todosPacientes.add(p3);
        todosPacientes.add(p4);
        todosPacientes.add(p5);

        fila.adicionarPaciente(p1);
        fila.adicionarPaciente(p2);
        fila.adicionarPaciente(p3);
        fila.adicionarPaciente(p4);
        fila.adicionarPaciente(p5);
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
        System.out.println("\n=== Todos os Pacientes do Sistema ===");
        for (Paciente p : todosPacientes) {
            String prio = p.getPrioridade() != null ? p.getPrioridade().toUpperCase() : "AGUARDANDO TRIAGEM";
            System.out.printf("- %s (CPF: %s) | Status: %s\n", p.getNome(), p.getCpf(), prio);
        }
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