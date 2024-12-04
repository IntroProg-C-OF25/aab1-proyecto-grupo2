
import java.util.Scanner;
import java.util.Random;

public class MejorEgresado {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        Random random = new Random();
        double promedio, mejoregresado = 7; //promedio se genera aleatoriamente, el mejor egresado para saber cual es el promedio mas alto
        int limite, cont; //limite de estudiantes generados
        String mejorestudiante = ""; //para almacenar al mejor o los 2 mejores estudiantes
        System.out.print("Ingrese el numero de estudiantes: ");
        limite = tcl.nextInt();
        for (cont = 1; cont <= limite; cont++) {
            promedio = 7 + (10 - 7) * random.nextDouble(); //generar aleatoriamente promedios del 7 al 10
            if (promedio > mejoregresado) { // comparar el promedio mas alto
                mejoregresado = promedio; //almacenar el mejor promedio
                mejorestudiante = "Estudiante " + cont; //almacenar el contador del propietario del mejor promedio 
            } else if (promedio == mejoregresado) { // comparar si existe otro mejor egresado
                mejorestudiante += " y Estudiante" + cont; // almacenar el segundo mejor promedio y estudiante
            }
            System.out.println("Estudiante " + cont + " - Promedio: " + String.format("%.2f", promedio)); // imprimir los estudiantes y promedios
        }
        System.out.println("----------------------------------------------------");
        System.out.println("El/los mejor(es) egresado(s): \n" + mejorestudiante); // imprimir mejor egresado o mejores 2 egresados
        System.out.println("Con un promedio de: \n" + String.format("%.2f", mejoregresado)); //imprimir el mejor promedio
        System.out.println("----------------------------------------------------");
    }
}
/*
run:
Ingrese el numero de estudiantes: 100
Estudiante 1 - Promedio: 9.97
Estudiante 2 - Promedio: 9.45
Estudiante 3 - Promedio: 8.15
Estudiante 4 - Promedio: 7.58
Estudiante 5 - Promedio: 8.98
Estudiante 6 - Promedio: 8.05
Estudiante 7 - Promedio: 7.01
Estudiante 8 - Promedio: 9.83
Estudiante 9 - Promedio: 7.88
Estudiante 10 - Promedio: 7.26
Estudiante 11 - Promedio: 7.82
Estudiante 12 - Promedio: 8.89
Estudiante 13 - Promedio: 8.12
Estudiante 14 - Promedio: 8.87
Estudiante 15 - Promedio: 7.08
Estudiante 16 - Promedio: 9.17
Estudiante 17 - Promedio: 7.50
Estudiante 18 - Promedio: 8.75
Estudiante 19 - Promedio: 8.78
Estudiante 20 - Promedio: 9.46
Estudiante 21 - Promedio: 7.96
Estudiante 22 - Promedio: 8.91
Estudiante 23 - Promedio: 8.43
Estudiante 24 - Promedio: 9.08
Estudiante 25 - Promedio: 7.65
Estudiante 26 - Promedio: 9.22
Estudiante 27 - Promedio: 8.69
Estudiante 28 - Promedio: 8.73
Estudiante 29 - Promedio: 7.45
Estudiante 30 - Promedio: 7.69
Estudiante 31 - Promedio: 7.94
Estudiante 32 - Promedio: 9.42
Estudiante 33 - Promedio: 9.56
Estudiante 34 - Promedio: 8.09
Estudiante 35 - Promedio: 8.02
Estudiante 36 - Promedio: 9.94
Estudiante 37 - Promedio: 8.80
Estudiante 38 - Promedio: 7.98
Estudiante 39 - Promedio: 8.46
Estudiante 40 - Promedio: 9.57
Estudiante 41 - Promedio: 7.29
Estudiante 42 - Promedio: 9.12
Estudiante 43 - Promedio: 9.99
Estudiante 44 - Promedio: 8.22
Estudiante 45 - Promedio: 8.87
Estudiante 46 - Promedio: 9.54
Estudiante 47 - Promedio: 9.28
Estudiante 48 - Promedio: 8.22
Estudiante 49 - Promedio: 8.46
Estudiante 50 - Promedio: 8.94
Estudiante 51 - Promedio: 8.51
Estudiante 52 - Promedio: 7.88
Estudiante 53 - Promedio: 8.72
Estudiante 54 - Promedio: 9.30
Estudiante 55 - Promedio: 9.37
Estudiante 56 - Promedio: 7.18
Estudiante 57 - Promedio: 7.14
Estudiante 58 - Promedio: 8.49
Estudiante 59 - Promedio: 7.88
Estudiante 60 - Promedio: 7.93
Estudiante 61 - Promedio: 8.40
Estudiante 62 - Promedio: 9.72
Estudiante 63 - Promedio: 7.28
Estudiante 64 - Promedio: 9.26
Estudiante 65 - Promedio: 8.28
Estudiante 66 - Promedio: 7.88
Estudiante 67 - Promedio: 7.37
Estudiante 68 - Promedio: 9.38
Estudiante 69 - Promedio: 8.87
Estudiante 70 - Promedio: 8.37
Estudiante 71 - Promedio: 9.21
Estudiante 72 - Promedio: 7.34
Estudiante 73 - Promedio: 8.96
Estudiante 74 - Promedio: 8.80
Estudiante 75 - Promedio: 7.35
Estudiante 76 - Promedio: 8.75
Estudiante 77 - Promedio: 7.56
Estudiante 78 - Promedio: 8.26
Estudiante 79 - Promedio: 9.62
Estudiante 80 - Promedio: 7.37
Estudiante 81 - Promedio: 7.41
Estudiante 82 - Promedio: 7.54
Estudiante 83 - Promedio: 8.04
Estudiante 84 - Promedio: 8.93
Estudiante 85 - Promedio: 8.05
Estudiante 86 - Promedio: 8.16
Estudiante 87 - Promedio: 8.27
Estudiante 88 - Promedio: 8.78
Estudiante 89 - Promedio: 9.60
Estudiante 90 - Promedio: 7.18
Estudiante 91 - Promedio: 7.90
Estudiante 92 - Promedio: 7.27
Estudiante 93 - Promedio: 7.92
Estudiante 94 - Promedio: 8.07
Estudiante 95 - Promedio: 8.63
Estudiante 96 - Promedio: 7.64
Estudiante 97 - Promedio: 9.81
Estudiante 98 - Promedio: 9.54
Estudiante 99 - Promedio: 7.10
Estudiante 100 - Promedio: 8.46
----------------------------------------------------
El/los mejor(es) egresado(s): 
Estudiante 43
Con un promedio de: 
9.99
----------------------------------------------------
BUILD SUCCESSFUL (total time: 2 seconds)

*/