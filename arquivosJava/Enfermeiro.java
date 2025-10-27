import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Enfermeiro extends Pessoa {

    private String idFuncionario;
    private String setor;

    public Enfermeiro(String nome, String cpf, String idFuncionario, String setor) {
        super(nome, cpf);
        this.idFuncionario = idFuncionario;
        this.setor = setor;
    }

    public void realizarTriagem(Scanner input, List<Paciente> todosPacientes, FilaAtendimento fila) {

        List<Paciente> semPrioridade = new ArrayList<>();
        for (Paciente p : todosPacientes) {
            if (p.getPrioridade() == null) {
                semPrioridade.add(p);
            }
        }

        if (semPrioridade.isEmpty()) {
            System.out.println("\n(Enfermeiro " + getNome() + " checou: Não há pacientes novos aguardando triagem.)");
            return;
        }

        System.out.println("\n=== Pacientes Aguardando Triagem ===");
        for (int i = 0; i < semPrioridade.size(); i++) {
            System.out.printf("%d. %s (CPF: %s)\n", i + 1, semPrioridade.get(i).getNome(), semPrioridade.get(i).getCpf());
        }
        System.out.print("Enfermeiro, qual paciente triar? (Digite o número): ");
        int escolha;
        try {
            escolha = Integer.parseInt(input.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Seleção inválida.");
            return;
        }

        if (escolha < 0 || escolha >= semPrioridade.size()) {
            System.out.println("Número de paciente não existe.");
            return;
        }

        Paciente paciente = semPrioridade.get(escolha);
        fazerPerguntasTriagem(input, paciente);

        fila.adicionarPaciente(paciente);
    }

    private void fazerPerguntasTriagem(Scanner input, Paciente paciente) {
        System.out.println("\n--- Iniciando Triagem de " + paciente.getNome() + " ---");
        double total = 0;

        System.out.print("O paciente está sentindo enjoo? (Sim/Não): ");
        if (input.nextLine().equalsIgnoreCase("sim")) total += 3;

        System.out.print("Qual o nível de dor (0 a 10)? ");
        try { total += Integer.parseInt(input.nextLine()); } catch (Exception e) {}

        System.out.print("Temperatura corporal (°C): ");
        try {
            double temp = Double.parseDouble(input.nextLine());
            if (temp > 39) total += 5; else if (temp >= 38) total += 3; else if (temp >= 37.5) total += 1; else if (temp < 35) total += 4;
        } catch (Exception e) {}

        System.out.print("Batimentos por minuto (BPM): ");
        try {
            int bpm = Integer.parseInt(input.nextLine());
            if (bpm > 120) total += 5; else if (bpm > 100) total += 3; else if (bpm < 50) total += 3; else if (bpm < 30) total += 5;
        } catch (Exception e) {}

        String prioridade;
        if (total >= 20) prioridade = "vermelho";
        else if (total >= 15) prioridade = "amarelo";
        else if (total >= 10) prioridade = "verde";
        else prioridade = "azul";

        paciente.definirPrioridade(prioridade);
        System.out.printf("Prioridade definida para %s: %s\n", paciente.getNome(), prioridade.toUpperCase());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Enfermeiro{");
        sb.append("idFuncionario='").append(idFuncionario).append('\'');
        sb.append(", setor='").append(setor).append('\'');
        sb.append(", nome='").append(getNome()).append('\'');
        sb.append(", cpf='").append(getCpf()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}