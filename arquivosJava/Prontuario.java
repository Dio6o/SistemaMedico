public class Prontuario {

    protected Consulta consulta;

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prontuario{");
        sb.append("consulta=").append(getConsulta());
        sb.append('}');
        return sb.toString();
    }
}

