public class Prontuario {

    protected Atendimento atendimento;
    protected CheckUp checkUp;
    protected Consulta consulta;

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public CheckUp getCheckUp() {
        return checkUp;
    }

    public void setCheckUp(CheckUp checkUp) {
        this.checkUp = checkUp;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prontuario{");
        sb.append("atendimento=").append(atendimento);
        sb.append(", checkUp=").append(checkUp);
        sb.append(", consulta=").append(consulta);
        sb.append('}');
        return sb.toString();
    }
    
}
