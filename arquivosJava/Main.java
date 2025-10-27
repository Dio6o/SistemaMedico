import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Atendente atendente = new Atendente("Atendente", "00000000000", "A001", "Recepção");
        Enfermeiro enfermeiro = new Enfermeiro("Enfermeiro", "00000000000", "E001", "Triagem");
        Medico medico = new Medico("Medico", "00000000000", "M001", "Clínico Geral");

        GerenciadorHospital ger = new GerenciadorHospital(atendente, enfermeiro, medico);

        ger.menu();

    }
}
