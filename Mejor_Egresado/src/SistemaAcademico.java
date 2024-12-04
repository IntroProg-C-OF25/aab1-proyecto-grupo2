import java.util.Scanner;

public class SistemaAcademico {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numEstudiantes, cedula;
        double acd, ape, aa, promedio;
        int totalAprobados = 0, totalAprobadosRecuperacion = 0, totalReprobados = 0;
        String estado;
        
        //número de estudiantes
        System.out.print("Ingrese el numero de estudiantes en el curso: ");
        numEstudiantes = input.nextInt();
        
        //encabezado del reporte
        String reporte = String.format("%-20s %-20s %-10s %-10s %-10s\n", 
                                      "Estudiante", "Materia", "Promedio", "Estado", "Cedula");

        // Iteración sobre cada estudiante
        for (int i = 1; i <= numEstudiantes; i++) {
            input.nextLine(); // Consumir salto de línea pendiente
            System.out.print("\nIngrese el nombre del estudiante: ");
            String nombre = input.nextLine();

            System.out.print("Ingrese el apellido del estudiante: ");
            String apellido = input.nextLine();

            System.out.print("Ingrese la cedula del estudiante: ");
            cedula = input.nextInt();

            input.nextLine(); // Consumir salto de línea pendiente
            System.out.print("Ingrese la materia: ");
            String materia = input.nextLine();

            // Solicitar las notas de cada materia
            System.out.printf("Ingrese la calificacion de ACD (3.5/10): ");
            acd = input.nextDouble();
            while (acd < 0 || acd > 3.5) {
                System.out.println("Nota invalida. Ingrese un valor entre 0 y 3.5.");
                System.out.printf("Ingrese la calificacion de ACD (3.5/10): ");
                acd = input.nextDouble();
            }

            System.out.printf("Ingrese la calificacion de APE (3.5/10): ");
            ape = input.nextDouble();
            while (ape < 0 || ape > 3.5) {
                System.out.println("Nota invalida. Ingrese un valor entre 0 y 3.5.");
                System.out.printf("Ingrese la calificacion de APE (3.5/10): ");
                ape = input.nextDouble();
            }

            System.out.printf("Ingrese la calificacion de AA (3.0/10): ");
            aa = input.nextDouble();
            while (aa < 0 || aa > 3.0) {
                System.out.println("Nota invalida. Ingrese un valor entre 0 y 3.0.");
                System.out.printf("Ingrese la calificacion de AA (3.0/10): ");
                aa = input.nextDouble();
            }

            // Calcular promedio
            promedio = acd + ape + aa;
            
            // Verificar estado
            if (promedio >= 7.0) {
                estado = "Aprobado";
                totalAprobados++;
            } else {
                System.out.printf("\nEl estudiante %s %s no ha aprobado. Debe rendir un examen de recuperacion.\n", nombre, apellido);
                double recu = 0;
                System.out.printf("Ingrese la calificacion de recuperacion (3.5/10): ");
                recu = input.nextDouble();
                while (recu < 0 || recu > 3.5) {
                    System.out.println("Nota invalida. Ingrese un valor entre 0 y 3.5.");
                    System.out.printf("Ingrese la calificación de recuperacion (3.5/10): ");
                    recu = input.nextDouble();
                }

                // Promedio con recuperación
                promedio = promedio * 0.6 + recu;
                if (promedio >= 7.0) {
                    estado = "Aprobado (tras recuperacion)";
                    totalAprobadosRecuperacion++;
                } else {
                    estado = "Reprobado";
                    totalReprobados++;
                }
            }

            reporte += String.format("%-20s %-20s %-10.2f %-10s %-10d\n", 
                                    nombre + " " + apellido, materia, promedio, estado, cedula);
        }

        // eporte final
        System.out.println("\n=====================================================");
        System.out.println("Estadisticas generales del curso:");
        System.out.println("=====================================================");
        reporte += String.format("\nTotal de Aprobados: %d\n", totalAprobados);
        reporte += String.format("Total de Aprobados con recuperacion: %d\n", totalAprobadosRecuperacion);
        reporte += String.format("Total de Reprobados: %d\n", totalReprobados);

        // Imprimir todo el reporte
        System.out.println(reporte);
    }
}
/***
 * Ingrese el numero de estudiantes en el curso: 5

Ingrese el nombre del estudiante: Martin
Ingrese el apellido del estudiante: Martin
Ingrese la cedula del estudiante: 100001
Ingrese la materia: Fisica
Ingrese la calificacion de ACD (3.5/10): 3,3
Ingrese la calificacion de APE (3.5/10): 2,3
Ingrese la calificacion de AA (3.0/10): 1,5

Ingrese el nombre del estudiante: Alex
Ingrese el apellido del estudiante: Martin
Ingrese la cedula del estudiante: 100002
Ingrese la materia: Fisica
Ingrese la calificacion de ACD (3.5/10): 3
Ingrese la calificacion de APE (3.5/10): 2
Ingrese la calificacion de AA (3.0/10): 1

El estudiante Alex Martin no ha aprobado. Debe rendir un examen de recuperaci0n.
Ingrese la calificacion de recuperacion (3.5/10): 3

Ingrese el nombre del estudiante: Camila
Ingrese el apellido del estudiante: Rojas
Ingrese la cedula del estudiante: 100003
Ingrese la materia: Quimica
Ingrese la calificacion de ACD (3.5/10): 3,4
Ingrese la calificacion de APE (3.5/10): 2,3
Ingrese la calificacion de AA (3.0/10): 0,9

El estudiante Camila Rojas no ha aprobado. Debe rendir un examen de recuperacion.
Ingrese la calificacion de recuperacion (3.5/10): 3

Ingrese el nombre del estudiante: Rocio
Ingrese el apellido del estudiante: Alba
Ingrese la cedula del estudiante: 100004
Ingrese la materia: Quimica
Ingrese la calificacion de ACD (3.5/10): 3
Ingrese la calificacion de APE (3.5/10): 3
Ingrese la calificacion de AA (3.0/10): 2

Ingrese el nombre del estudiante: Daniel
Ingrese el apellido del estudiante: Pintado
Ingrese la cedula del estudiante: 100005
Ingrese la materia: Fisica
Ingrese la calificacion de ACD (3.5/10): 3
Ingrese la calificacion de APE (3.5/10): 2,3
Ingrese la calificacion de AA (3.0/10): 3

=====================================================
Estadisticas generales del curso:
=====================================================
Estudiante           Materia              Promedio   Estado     Cedula    
Martin Martin        Fisica               7,10       Aprobado   100001    
Alex Martin          Fisica               6,60       Reprobado  100002    
Camila Rojas         Quimica              6,96       Reprobado  100003    
Rocio Alba           Quimica              8,00       Aprobado   100004    
Daniel Pintado       Fisica               8,30       Aprobado   100005    

Total de Aprobados: 3
Total de Aprobados con recuperacion: 0
Total de Reprobados: 2

BUILD SUCCESSFUL (total time: 4 minutes 17 seconds)

 */
