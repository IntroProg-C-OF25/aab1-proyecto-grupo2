
import java.util.Scanner;
import java.util.Random;

public class MejorEgresado {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        Random random = new Random();
        double promedio, mejoregresado = 7;
        int limite, cont;
        String mejorestudiante = "";
        System.out.print("Ingrese el numero de estudiantes: ");
        limite = tcl.nextInt();
        for (cont = 1; cont <= limite; cont++) {
            promedio = 7 + (10 - 7) * random.nextDouble();
            if (promedio > mejoregresado) {
                mejoregresado = promedio;
                mejorestudiante = "Estudiante " + cont;
            } else if (promedio == mejoregresado) {
                mejorestudiante += " y Estudiante" + cont;
            }
            System.out.println("Estudiante " + cont + " - Promedio: " + String.format("%.2f", promedio));
        }
        System.out.println("----------------------------------------------------");
        System.out.println("El/los mejor(es) egresado(s): \n" + mejorestudiante);
        System.out.println("Con un promedio de: \n" + String.format("%.2f", mejoregresado));
        System.out.println("----------------------------------------------------");
    }
}
