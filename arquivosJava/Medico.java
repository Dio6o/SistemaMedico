import java.util.Scanner;

public class Medico extends Pessoa{
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

    public String examinar(Paciente paciente, String diagnostico) {
        Scanner input = new Scanner(System.in);
        System.out.print("Diagnóstico: ");
        diagnostico = input.nextLine();
        return diagnostico;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Medico{");
        sb.append("setor='").append(getSetor()).append('\'');
        sb.append(", idFuncionario=").append(getIdFuncionario());
        sb.append(Medico.super.toString());
        sb.append('}');
        return sb.toString();
    }
}
