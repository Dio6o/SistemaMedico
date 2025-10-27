import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Atendimento {
    private LocalDate dataAtendimento;
    private Paciente paciente;
    private Enfermeiro enfermeiro;
    private CheckUp checkUp; // classificação gerada após a triagem
    private boolean triagemConcluida;

    public Atendimento() {}

    public Atendimento(Paciente paciente, Enfermeiro enfermeiro) {
        this.paciente = paciente;
        this.enfermeiro = enfermeiro;
        this.dataAtendimento = LocalDate.now();
        this.triagemConcluida = false;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public CheckUp getCheckUp() {
        return checkUp;
    }

    public boolean isTriagemConcluida() {
        return triagemConcluida;
    }

    public void realizarTriagem(Scanner input) {
        System.out.println("\n=== Iniciando Triagem ===");
        String prioridade = enfermeiro.realizarTriagem(input, paciente); // já define prioridade
        triagemConcluida = true;

        // Só classifica após a triagem
        if (triagemConcluida) {
            CheckUp.ClassificacaoFila classificacao;
            switch (prioridade.toLowerCase()) {
                case "vermelho" -> classificacao = CheckUp.ClassificacaoFila.EMERGENCIA;
                case "amarelo" -> classificacao = CheckUp.ClassificacaoFila.URGENTE;
                case "verde" -> classificacao = CheckUp.ClassificacaoFila.POUCO_URGENTE;
                default -> classificacao = CheckUp.ClassificacaoFila.NAO_URGENTE;
            }
            checkUp = new CheckUp(classificacao);
            System.out.printf("Classificação de fila atribuída: %s\n", classificacao);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atendimento{");
        sb.append("dataAtendimento=").append(getDataAtendimento());
        sb.append(", paciente=").append(getPaciente());
        sb.append(", enfermeiro=").append(getEnfermeiro());
        sb.append(", checkUp=").append(getCheckUp());
        sb.append(", triagemConcluida=").append(isTriagemConcluida());
        sb.append('}');
        return sb.toString();
    }
}
