import java.util.ArrayList;
import java.util.List;
import java.util.Date;

class Main {
    public static void main(String[] args) {

        List<Prontuario> prontuario = new ArrayList<>();
        Paciente paciente1 = new Paciente("Diogo", "123", "A-", "Nenhuma");
        paciente1.setProntuario(prontuario);
        Atendimento atendimento = new Atendimento("23/10/2025", Atendimento.ClassificacaoFila.URGENTE);

        System.out.println(paciente1);
    }
}