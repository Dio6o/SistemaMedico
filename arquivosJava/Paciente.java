import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paciente extends Pessoa{
        Scanner input = new Scanner(System.in);

    private String tipoSangue;
    private String alergias;
    protected List<Prontuario> prontuario = new ArrayList<>();

    public String cadastrarPaciente(String nome, String cpf, String tipoSangue, String alergias) {
        System.out.println("=== Cadastro de Paciente ===");

        System.out.print("Digite o nome: ");
        nome = input.nextLine();

        System.out.print("Digite o CPF: ");
        cpf = input.nextLine();

        System.out.print("Digite o tipo sanguíneo: ");
        tipoSangue = input.nextLine();

        System.out.print("Digite alergias (se houver): ");
        alergias = input.nextLine();

        setNome(nome);
        setCpf(cpf);
        setTipoSangue(tipoSangue);
        setAlergias(alergias);

        String resultado = "Paciente cadastrado:\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Tipo Sanguíneo: " + tipoSangue + "\n" +
                "Alergias: " + alergias;

        return resultado;
    }

    public List<Prontuario> getProntuario() {
        return prontuario;
    }

    public void setProntuario(List<Prontuario> prontuario) {
        this.prontuario = prontuario;
    }

    public String getTipoSangue() {
        return tipoSangue;
    }

    public void setTipoSangue(String tipoSangue) {
        if (tipoSangue != null) {
            this.tipoSangue = tipoSangue;
        }
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        if (alergias != null) {
            this.alergias = alergias;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Paciente{");
        sb.append("input=").append(input);
        sb.append(", tipoSangue='").append(getTipoSangue()).append('\'');
        sb.append(", alergias='").append(getAlergias()).append('\'');
        sb.append(", prontuario=").append(getProntuario());
        sb.append(Paciente.super.toString());
        sb.append('}');
        return sb.toString();
    }
}
