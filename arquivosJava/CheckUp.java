public class CheckUp {

    public enum ClassificacaoFila {
        EMERGENCIA,
        URGENTE,
        POUCO_URGENTE,
        NAO_URGENTE
    }

    private ClassificacaoFila classificacaoFila;

    public CheckUp(ClassificacaoFila classificacaoFila) {
        this.classificacaoFila = classificacaoFila;
    }

    public ClassificacaoFila getClassificacaoFila() {
        return classificacaoFila;
    }

    public void setClassificacaoFila(ClassificacaoFila classificacaoFila) {
        this.classificacaoFila = classificacaoFila;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckUp{");
        sb.append("classificacaoFila=").append(getClassificacaoFila());
        sb.append('}');
        return sb.toString();
    }
}
