import java.util.Scanner;

public class Enfermeiro extends Pessoa{
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

    public String triagem(double valor) {
        double total = valor;

        System.out.print("Qual a temperatura?: ");
        double temperatura = input.nextDouble();

        System.out.print("Qual quantida de BPM do paciente?: ");
        double batimentos = input.nextDouble();

        input.nextLine();

        if (temperatura > 39){
            total += 5;
        } else if (temperatura > 37.8){
            total += 3;
        } else if  (temperatura > 37.2){
            total += 1;
        }

        //TODO set the temperatures for  hypotermia

        if (batimentos > 120){
            total += 5;
        } if (batimentos > 100){
            total += 2;
        } if  (batimentos > 90){
            total += 0;
        } if (batimentos < 50){
            total += 2;
        } if  (batimentos < 30){
            total += 5;
        }

        if (total >= 20){
            return "vermelho";
        } else if (total >= 15){
            return "amarelo";
        } else if (total >= 10){
            return "verde";
        } else {
            return "azul";
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Enfermeiro{");
        sb.append("setor='").append(getSetor()).append('\'');
        sb.append(", idFuncionario=").append(getIdFuncionario());
        sb.append(Enfermeiro.super.toString());
        sb.append('}');
        return sb.toString();
    }
}
