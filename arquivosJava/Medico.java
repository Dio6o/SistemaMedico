public class Medico extends Pessoa{

    private String setor;
    private Integer idFuncionario;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        if (setor != null) {
            this.setor = setor;
        }
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncinario(Integer idFuncionario) {
        if ((idFuncionario != null) && (idFuncionario > 0)) {
            this.idFuncionario = idFuncionario;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atendente{");
        sb.append("setor='").append(getSetor()).append('\'');
        sb.append(", idFuncionario=").append(getIdFuncionario());
        sb.append(", nome='").append(getNome()).append('\'');
        sb.append(", cpf='").append(getCpf()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
