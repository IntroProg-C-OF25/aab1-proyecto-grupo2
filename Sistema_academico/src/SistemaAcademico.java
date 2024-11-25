//Uso de la librerias Mao, HashMap para almacenar las estadisticas por materia 
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaAcademico {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numEstudiantes,cedula,total;
        double acd, ape, aa;
        // Estudiantes por paralelo 
        System.out.print("Ingrese el numero de estudiantes en el curso: ");
        numEstudiantes = input.nextInt();    
        // Mapa para almacenar las estadísticas por materia
        Map<String, int[]> estadisticasPorMateria = new HashMap<>();

        

        for (int i = 1; i <= numEstudiantes; i++) {
            //Ingreso de datos de identificacion
            input.nextLine(); 
            System.out.print("\nIngrese el nombre del estudiante: ");
            String nombre = input.nextLine();

            System.out.print("Ingrese el apellido del estudiante: ");
            String apellido = input.nextLine();

            System.out.print("Ingrese la cédula del estudiante: ");
            cedula = input.nextInt();

            input.nextLine(); 
            System.out.print("Ingrese la materia: ");
            String materia = input.nextLine();

            // Ingreso de notas
            do {
                System.out.print("Ingrese la calificacion de ACD (3.5/10): ");
                acd = input.nextDouble();
                if (acd < 0 || acd > 3.5) {
                    System.out.println("Nota invalida. Ingrese una nota entre 0 y 3.5.");
                }
            } while (acd < 0 || acd > 3.5);

            do {
                System.out.print("Ingrese la calificacian de APE (3.5/10): ");
                ape = input.nextDouble();
                if (ape < 0 || ape > 3.5) {
                    System.out.println("Nota invalida. Ingrese una nota entre 0 y 3.5.");
                }
            } while (ape < 0 || ape > 3.5);

            do {
                System.out.print("Ingrese la calificacian de AA (3/10): ");
                aa = input.nextDouble();
                if (aa < 0 || aa > 3.0) {
                    System.out.println("Nota invalida. Ingrese una nota entre 0 y 3.0.");
                }
            } while (aa < 0 || aa > 3.0);

            // Calcular el promedio 
            double promedio = acd + ape + aa;
            String estado;

            //Verificacion de estado
            if (promedio >= 7.0) {
                estado = "Aprobado";
            } else {
                System.out.println("\nEl estudiante no ha aprobado y debe rendir un examen de recuperacion.");
                System.out.printf("Ingrese la nota de recuperación para %s %s (máximo 3.5): ", nombre, apellido);
                double recu;
                do {
                    recu = input.nextDouble();
                    if (recu < 0 || recu > 3.5) {
                        System.out.print("Nota inválida. Ingrese un valor entre 0 y 3.5: ");
                    }
                } while (recu < 0 || recu > 3.5);
                // Recalcular promedio
                promedio = promedio * 0.6 + recu; 
                estado = (promedio >= 7.0) ? "Aprobado (tras recuperacion)" : "Reprobado";
            }

            // Actualizar las estadísticas por materia
            int[] estadisticas = estadisticasPorMateria.getOrDefault(materia, new int[3]);
            if (estado.startsWith("Aprobado")) {
                estadisticas[0]++; 
            } else if (estado.startsWith("Aprobado (tras recuperación)")) {
                estadisticas[1]++; 
            } else {
                estadisticas[2]++; 
            }
            estadisticasPorMateria.put(materia, estadisticas);   

            //Carpinteria de salida
            System.out.println("\nResultados del curso:");
            System.out.println("=====================================================");
            System.out.printf("%-10s %-25s %-15s %-10s %-10s\n", "Cédula", "Nombre", "Materia", "Promedio", "Estado");
            System.out.println("=====================================================");
            System.out.printf("%-10d %-25s %-15s %-10.2f %-10s\n", cedula, nombre + " " + apellido, materia, promedio, estado);
        }

        // Estadisticas
        System.out.println("\n=====================================================");
        System.out.println("Estadísticas por materia:");
        System.out.println("=====================================================");
        
        for (Map.Entry<String, int[]> entry : estadisticasPorMateria.entrySet()) {
            String materia = entry.getKey();
            int[] estadisticas = entry.getValue();
            total = estadisticas[0] + estadisticas[1] + estadisticas[2];

            System.out.println("\nMateria: " + materia);
            System.out.printf("Total de estudiantes: %d\n", total);
            System.out.printf("Aprobados: %d (%.2f%%)\n", estadisticas[0], (estadisticas[0] * 100.0) / total);
            System.out.printf("Aprobados con recuperación: %d (%.2f%%)\n", estadisticas[1], (estadisticas[1] * 100.0) / total);
            System.out.printf("Reprobados: %d (%.2f%%)\n", estadisticas[2], (estadisticas[2] * 100.0) / total);
        }
        System.out.println("=====================================================");

    }
}
