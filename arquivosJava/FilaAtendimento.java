import java.util.ArrayList;
import java.util.List;

public class FilaAtendimento {
    private List<Paciente> fila = new ArrayList<>();

    public void adicionarPaciente(Paciente paciente) {
        if (paciente == null || paciente.getPrioridade() == null) {
            System.out.println("Paciente não pode ser adicionado sem prioridade!");
            return;
        }
        int index = 0;
        for (; index < fila.size(); index++) {
            if (valorPrioridade(paciente.getPrioridade()) > valorPrioridade(fila.get(index).getPrioridade())) break;
        }
        fila.add(index, paciente);
        System.out.printf("Paciente %s adicionado à fila (prioridade: %s)\n", paciente.getNome(), paciente.getPrioridade());
    }

    public Paciente proximoPaciente() {
        if (fila.isEmpty()) return null;
        return fila.remove(0);
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public List<Paciente> getFila() {
        return fila;
    }

    public void listarFila() {
        if (fila.isEmpty()) {
            System.out.println("Nenhum paciente na fila.");
            return;
        }
        System.out.println("\n=== FILA DE ATENDIMENTO ===");
        for (int i = 0; i < fila.size(); i++) {
            Paciente p = fila.get(i);
            System.out.printf("%d. %s - Prioridade: %s\n", i + 1, p.getNome(), p.getPrioridade() != null ? p.getPrioridade().toUpperCase() : "ND");
        }
    }

    private int valorPrioridade(String prioridade) {
        if (prioridade == null) return 0;
        return switch (prioridade.toLowerCase()) {
            case "vermelho" -> 4;
            case "amarelo" -> 3;
            case "verde" -> 2;
            case "azul" -> 1;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FilaAtendimento{");
        sb.append("fila=").append(getFila());
        sb.append('}');
        return sb.toString();
    }
}
