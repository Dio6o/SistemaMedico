import java.util.Scanner;

public class Atendimento {
    Scanner input = new Scanner(System.in);

    private String dataAtendimento;

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public double triagem() {
        double total = 0;

        System.out.print("Você se sente enjoado?: Sim ou Não? " );
        String opcao = input.nextLine();
        if (opcao.equalsIgnoreCase("sim")) {
            total += 5;
        }

        System.out.print("Qual o nível da sua dor? de 0 a 10. ");
        int opcao2 = input.nextInt();
        total += opcao2;

        input.nextLine();

        return total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atendimento{");
        sb.append("dataAtendimento=").append(dataAtendimento);
        sb.append('}');
        return sb.toString();
    }

}
