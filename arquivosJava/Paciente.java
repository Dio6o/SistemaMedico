import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {
    private String tipoSangue;
    private String alergias;
    private String prioridade; // definida pela triagem
    private List<Prontuario> prontuario = new ArrayList<>();

    public Paciente() {}

    public Paciente(String nome, String cpf, String tipoSangue, String alergias) {
        setNome(nome);
        setCpf(cpf);
        setTipoSangue(tipoSangue);
        setAlergias(alergias);
    }

    public String getTipoSangue() { return tipoSangue; }
    public void setTipoSangue(String tipoSangue) {
        if (tipoSangue != null) this.tipoSangue = tipoSangue;
    }

    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) {
        if (alergias != null) this.alergias = alergias;
    }

    public String getPrioridade() { return prioridade; }
    public void definirPrioridade(String prioridade) {
        if (prioridade != null && !prioridade.isBlank()) this.prioridade = prioridade.toLowerCase();
    }

    public List<Prontuario> getProntuario() { return prontuario; }
    public void adicionarProntuario(Prontuario p) {
        if (p != null) prontuario.add(p);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Paciente{");
        sb.append("tipoSangue='").append(getTipoSangue()).append('\'');
        sb.append(", alergias='").append(getAlergias()).append('\'');
        sb.append(", prioridade='").append(getPrioridade()).append('\'');
        sb.append(", prontuario=").append(getProntuario());
        sb.append(", nome='").append(getNome()).append('\'');
        sb.append(", cpf='").append(getCpf()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
