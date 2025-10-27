import java.util.ArrayList;
import java.util.List;

public class Fila {

    private int posicao;
    private ArrayList<Paciente> fila = new ArrayList<>();

    public ArrayList<Paciente> getFila() {
        return fila;
    }

    private void setFila(ArrayList<Paciente> fila) {
        this.fila = fila;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public void addToLine(Paciente paciente) {

        if (paciente.getPrioridade() != null) {
            if (fila.isEmpty()) {
                fila.addFirst(paciente);

            } else {
                // 4 cases to deal with when adding a pacient to the line:
                // 1) the line doesn't have the priority of the current pacient
                // 2) the line has the priority of the current pacient

                String priority = paciente.getPrioridade();
                int last;

                if (lineContainsPriority(priority)) {
                    last = lastIndexOf(priority);
                    fila.add(last + 1, paciente); // Adds the pacient based on the priority

                } else {
                    switch (priority) {
                        case "vermelho" -> fila.addFirst(paciente);
                        case "amarelo" -> {
                            last = lastIndexOf("vermelho");
                            fila.add(last + 1, paciente);
                        }
                        case "verde" -> {
                            if (lineContainsPriority("amarelo")) {
                                last = lastIndexOf("amarelo");
                                fila.add(last + 1, paciente);

                            } else if (lineContainsPriority("vermelho")) {
                                last = lastIndexOf("vermelho");
                                fila.add(last + 1, paciente);

                            } else {
                                fila.addFirst(paciente);
                            }
                        }
                        case "azul" -> fila.addLast(paciente);
                    }
                }
            }

        } else {
            System.out.println("Paciente não pode ser adicionado sem uma prioridade!");

        }

    }

    private boolean lineContainsPriority(String priority) {
        // Returns true if the line contains the specified priority, else, returns false
        for (Paciente paciente : fila) {
            if (paciente.getPrioridade().equals(priority)) {
                return true;
            }
        }
        return false;
    }

    private int lastIndexOf(String priority) {
        // Returns the index of the last occurrence of the specified priority
        int index = -1;
        for (int i = 0; i < fila.size(); i++) {
            if (fila.get(i).getPrioridade().equals(priority)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fila{");
        sb.append("posicao=").append(posicao);
        sb.append(", fila=").append(fila);
        sb.append('}');
        return sb.toString();
    }


}
