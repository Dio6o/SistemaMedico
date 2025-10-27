import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa{

    private String tipoSangue;
    private String Alergias;
    protected List<Prontuario> prontuario = new ArrayList<>();

    public Paciente(String nome, String cpf, String tipoSangue, String Alergias) {
        setNome(nome);
        setCpf(cpf);
        setTipoSangue(tipoSangue);
        setAlergias(Alergias);
    }

    public List<Prontuario> getProntuario() {
        return prontuario;
    }

    public void setProntuario(List<Prontuario> prontuario) {
        this.prontuario = prontuario;
    }

    public String getTipoSangue() {
        return tipoSangue;
    }

    public void setTipoSangue(String tipoSangue) {
        if (tipoSangue != null) {
            this.tipoSangue = tipoSangue;
        }
    }

    public String getAlergias() {
        return Alergias;
    }

    public void setAlergias(String alergias) {
        if (alergias != null) {
            Alergias = alergias;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Paciente{");
        sb.append(Paciente.super.toString());
        sb.append("tipoSangue='").append(getTipoSangue()).append('\'');
        sb.append(", Alergias='").append(getAlergias()).append('\'');
        sb.append(", Prontuario='").append(getProntuario()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
