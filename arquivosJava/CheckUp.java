public class CheckUp {


    public enum classificacaoFila {
        EMERGENCIA,
        URGENTE,
        POUCO_URGENTE,
        NAO_URGENTE,
    }
    
    private classificacaoFila classificacaoFila;

    public CheckUp(classificacaoFila classificacaoFila) {
        setClassificacaoLista(classificacaoFila);
    }
    
    public classificacaoFila getClassificacaoFila() {
        return classificacaoFila;
    }

    public void setClassificacaoLista(classificacaoFila classificacaoFila) {
        this.classificacaoFila = classificacaoFila;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckUp{");
        sb.append("classificacaoFila=").append(classificacaoFila);
        sb.append(", classificacaoFila=").append(getClassificacaoFila());
        sb.append('}');
        return sb.toString();
    }
}
