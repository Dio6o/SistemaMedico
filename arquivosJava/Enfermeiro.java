import java.util.Scanner;

public class Enfermeiro extends Pessoa {

    private String idFuncionario;
    private String setor;


    public Enfermeiro() {}


    public Enfermeiro(String nome, String cpf, String idFuncionario, String setor) {
        super(nome, cpf);
        this.idFuncionario = idFuncionario;
        this.setor = setor;
    }


    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        if (idFuncionario != null && !idFuncionario.isBlank()) {
            this.idFuncionario = idFuncionario;
        } else {
            System.out.println("ID de funcionário inválido!");
        }
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        if (setor != null && !setor.isBlank()) {
            this.setor = setor;
        } else {
            this.setor = "Triagem";
        }
    }

    public String realizarTriagem(Scanner input, Paciente paciente) {
        double total = 0;

        System.out.println("\n=== Triagem do Paciente ===");
        System.out.printf("Paciente: %s\n", paciente.getNome());

        System.out.print("O paciente está sentindo enjoo? (Sim/Não): ");
        String resposta = input.nextLine();
        if (resposta.equalsIgnoreCase("sim")) total += 3;

        System.out.print("Qual o nível de dor (0 a 10)? ");
        int nivelDor = input.nextInt();
        total += nivelDor;

        System.out.print("Temperatura corporal (°C): ");
        double temperatura = input.nextDouble();

        System.out.print("Batimentos por minuto (BPM): ");
        int bpm = input.nextInt();
        input.nextLine();

        if (temperatura > 39) total += 5;
        else if (temperatura >= 38) total += 3;
        else if (temperatura >= 37.5) total += 1;
        else if (temperatura < 35) total += 4;

        if (bpm > 120) total += 5;
        else if (bpm > 100) total += 3;
        else if (bpm < 50) total += 3;
        else if (bpm < 30) total += 5;

        String prioridade;

        if (total >= 20) prioridade = "vermelho";
        else if (total >= 15) prioridade = "amarelo";
        else if (total >= 10) prioridade = "verde";
        else prioridade = "azul";

        paciente.definirPrioridade(prioridade);

        System.out.printf("\nPrioridade definida: %s\n", prioridade.toUpperCase());


        CheckUp.ClassificacaoFila classificacao;
        switch (prioridade.toLowerCase()) {
            case "vermelho" -> classificacao = CheckUp.ClassificacaoFila.EMERGENCIA;
            case "amarelo" -> classificacao = CheckUp.ClassificacaoFila.URGENTE;
            case "verde" -> classificacao = CheckUp.ClassificacaoFila.POUCO_URGENTE;
            default -> classificacao = CheckUp.ClassificacaoFila.NAO_URGENTE;
        }
        paciente.adicionarProntuario(new Prontuario());
        System.out.printf("Classificação de fila: %s\n", classificacao);
        System.out.println("----------------------------\n");

        return prioridade;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Enfermeiro{");
        sb.append("idFuncionario='").append(getIdFuncionario()).append('\'');
        sb.append(", setor='").append(getSetor()).append('\'');
        sb.append(", nome='").append(getNome()).append('\'');
        sb.append(", cpf='").append(getCpf()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

