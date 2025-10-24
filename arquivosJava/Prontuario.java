import java.util.ArrayList;
import java.util.List;

public class Prontuario {
    private List<Consulta> consultas = new ArrayList<>();

    public Prontuario() {}

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta registrada.");
            return;
        }

        for (int i = 0; i < consultas.size(); i++) {
            System.out.println("===== CONSULTA Nº " + (i + 1) + " =====");
            System.out.println(consultas.get(i).gerarRelatorio());
        }
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public int getTotalConsultas() {
        return consultas.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prontuario{");
        sb.append("consultas=").append(getConsultas());
        sb.append('}');
        return sb.toString();
    }
}
