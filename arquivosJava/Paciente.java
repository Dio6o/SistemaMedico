public class Paciente extends Pessoa{

    private String tipoSangue;
    private String Alergias;

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
        sb.append("tipoSangue='").append(getTipoSangue()).append('\'');
        sb.append(", Alergias='").append(getAlergias()).append('\'');
        sb.append(", alergias='").append(getAlergias()).append('\'');
        sb.append(Paciente.super.toString());
        sb.append('}');
        return sb.toString();
    }
}
