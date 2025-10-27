import java.util.ArrayList;
import java.util.List;

public class Prontuario {
    private List<Consulta> consultas = new ArrayList<>();

    public Prontuario() {}

    public void adicionarConsulta(Consulta consulta) {
        if (consulta != null) consultas.add(consulta);
    }

    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta registrada.");
            return;
        }
        for (int i = 0; i < consultas.size(); i++) {
            System.out.println("\n===== CONSULTA Nº " + (i + 1) + " =====");
            System.out.println(consultas.get(i).gerarRelatorio());
            System.out.println("------------------------------");
        }
    }

    public List<Consulta> getConsultas() { return consultas; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prontuario{");
        sb.append("consultas=").append(getConsultas());
        sb.append('}');
        return sb.toString();
    }
}
