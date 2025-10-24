public class CheckUp {


    public enum classificacaoFila {
        EMERGENCIA,
        URGENTE,
        POUCO_URGENTE,
        NAO_URGENTE,
    }
    
    private classificacaoFila classificacaoLista;

    public CheckUp(classificacaoFila classificacaoLista) {
        setClassificacaoLista(classificacaoLista);
    }
    
    public classificacaoFila getClassificacaoAtendimento() {
        return classificacaoLista;
    }

    public void setClassificacaoLista(classificacaoFila classificacaoLista) {
        this.classificacaoLista = classificacaoLista;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckUp{");
        sb.append("classificacaoLista=").append(classificacaoLista);
        sb.append(", classificacaoAtendimento=").append(getClassificacaoAtendimento());
        sb.append('}');
        return sb.toString();
    }
}
