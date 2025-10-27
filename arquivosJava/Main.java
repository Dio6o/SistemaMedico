import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {

        List<Prontuario> prontuario1 = new ArrayList<>();
        List<Paciente> f = new ArrayList<>();
        Paciente paciente1 = new Paciente("Diogo", "123", "A-", "Nenhuma");
        Paciente paciente2 = new Paciente("Kauan", "124", "O-", "Amendoim");
        Paciente paciente3 = new Paciente("GALO", "1299", "B-", "Mulher");
        Paciente paciente4 = new Paciente("Mineiro", "69", "AB-", "Dst");
        Paciente paciente5 = new Paciente("Alemao", "777", "A+", "Ateu");

        Fila fila  = new Fila();
        Enfermeiro enfermeiro = new Enfermeiro();
        Atendimento atendimento = new Atendimento();
        Consulta consulta = new Consulta();


        //paciente1.setPrioridade(enfermeiro.triagem(atendimento.triagem()));
        //paciente2.setPrioridade(enfermeiro.triagem(atendente.triagem()));

        paciente1.setPrioridade("vermelho");
        paciente2.setPrioridade("amarelo");
        paciente3.setPrioridade("azul");
        paciente4.setPrioridade("verde");
        paciente5.setPrioridade("verde");

        fila.addToLine(paciente2);
        fila.addToLine(paciente3);
        fila.addToLine(paciente4);
        fila.addToLine(paciente1);
        fila.addToLine(paciente5);

        System.out.println(fila);

        consulta.consultar(fila);

        System.out.println(fila);

    }
}