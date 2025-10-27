import java.util.LinkedList;

public class Fila {

    private LinkedList<Paciente> fila = new LinkedList<>();

    public LinkedList<Paciente> getFila() {
        return fila;
    }

    public void setFila(LinkedList<Paciente> fila) {
        this.fila = fila;
    }

    public void addToLine(Paciente paciente) {
        if (paciente.getPrioridade() == null) {
            System.out.println("Paciente não pode ser adicionado sem prioridade!");
            return;
        }

        String prioridade = paciente.getPrioridade();

        if (fila.isEmpty()) {
            fila.add(paciente);
            return;
        }

        switch (prioridade) {
            case "vermelho" -> fila.addFirst(paciente);
            case "amarelo" -> {
                int lastRed = lastIndexOf("vermelho");
                fila.add(lastRed + 1, paciente);
            }
            case "verde" -> {
                int lastYellow = lastIndexOf("amarelo");
                int lastRed = lastIndexOf("vermelho");
                int pos = Math.max(lastYellow, lastRed);
                if (pos >= 0) fila.add(pos + 1, paciente);
                else fila.addFirst(paciente);
            }
            case "azul" -> fila.addLast(paciente);
            default -> System.out.println("Prioridade inválida!");
        }
    }

    private int lastIndexOf(String prioridade) {
        int index = -1;
        for (int i = 0; i < fila.size(); i++) {
            if (fila.get(i).getPrioridade().equalsIgnoreCase(prioridade)) {
                index = i;
            }
        }
        return index;
    }

    public Paciente chamarProximo() {
        if (!fila.isEmpty()) {
            return fila.removeFirst();
        } else {
            System.out.println("Fila vazia!");
            return null;
        }
    }

    public void mostrarFila() {
        if (fila.isEmpty()) {
            System.out.println("Nenhum paciente na fila.");
            return;
        }

        System.out.println("\n=== FILA DE ATENDIMENTO ===");
        for (int i = 0; i < fila.size(); i++) {
            Paciente p = fila.get(i);
            System.out.printf("%dº - %s (Prioridade: %s)\n", i + 1, p.getNome(), p.getPrioridade());
        }
        System.out.println("----------------------------");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fila{");
        sb.append("fila=").append(getFila());
        sb.append('}');
        return sb.toString();
    }
}
