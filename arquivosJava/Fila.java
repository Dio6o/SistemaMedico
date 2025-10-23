public class Fila {

    private int posicao;

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fila{");
        sb.append("posicao=").append(posicao);
        sb.append('}');
        return sb.toString();
    }

}
