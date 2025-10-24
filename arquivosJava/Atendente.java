import java.util.Scanner;

public class Atendente extends Pessoa {
    Scanner input = new Scanner(System.in);

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

    public double triagem() {
        double total = 0;

        System.out.print("Você se enjoado?: Sim ou Não? " );
        String opcao = input.nextLine();
        if (opcao.equalsIgnoreCase("sim")) {
            total += 5;
        }

        System.out.print("Qual o nível da dor? 0 a 10. ");
        int opcao2 = input.nextInt();
        total += opcao2;

        return total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atendente{");
        sb.append("setor='").append(getSetor()).append('\'');
        sb.append(", idFuncionario=").append(getIdFuncionario());
        sb.append(Atendente.super.toString());
        sb.append('}');
        return sb.toString();
    }
}
