import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {

    private String tipoSangue;
    private String alergias;
    private String prioridade; // definido apenas pela enfermeira
    private List<Prontuario> prontuario = new ArrayList<>();

    public Paciente() {}

    public Paciente(String nome, String cpf, String tipoSangue, String alergias) {
        super(nome, cpf);
        this.tipoSangue = tipoSangue;
        this.alergias = alergias;
    }

    public String getTipoSangue() {
        return tipoSangue;
    }

    public void setTipoSangue(String tipoSangue) {
        if (tipoSangue != null && !tipoSangue.isBlank()) {
            this.tipoSangue = tipoSangue;
        } else {
            System.out.println("Tipo sanguíneo inválido!");
        }
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        if (alergias != null) {
            this.alergias = alergias;
        } else {
            this.alergias = "Nenhuma registrada";
        }
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void definirPrioridade(String prioridade) {
        if (prioridade != null && !prioridade.isBlank()) {
            this.prioridade = prioridade.toLowerCase();
        } else {
            System.out.println("Prioridade inválida!");
        }
    }

    public List<Prontuario> getProntuario() {
        return prontuario;
    }

    public void setProntuario(List<Prontuario> prontuario) {
        if (prontuario != null) {
            this.prontuario = prontuario;
        }
    }

    public void adicionarProntuario(Prontuario novoProntuario) {
        if (novoProntuario != null) {
            prontuario.add(novoProntuario);
        }
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
