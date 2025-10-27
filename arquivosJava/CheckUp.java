public class CheckUp {


    public enum ClassificacaoFila {
        EMERGENCIA,
        URGENTE,
        POUCO_URGENTE,
        NAO_URGENTE,
    }
    
    private ClassificacaoFila classificacaoFila;

    public CheckUp(ClassificacaoFila classificacaoFila) {
        setClassificacaoLista(classificacaoFila);
    }
    
    public ClassificacaoFila getClassificacaoFila() {
        return classificacaoFila;
    }

    public void setClassificacaoLista(ClassificacaoFila classificacaoFila) {
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
