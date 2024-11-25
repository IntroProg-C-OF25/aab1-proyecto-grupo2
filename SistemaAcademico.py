
def ingresar_estudiante():
    nombre = input("Ingrese el nombre del estudiante: ")
    apellido = input("Ingrese el apellido del estudiante: ")
    cedula = input("Ingrese la cédula del estudiante: ")
    materia = input("Ingrese la materia: ")
    return nombre, apellido, cedula, materia

def ingresar_notas():
    # Ingreso de notas con validación
    while True:
        acd = float(input("Ingrese la calificación de ACD (3.5/10): "))
        if 0 <= acd <= 3.5:
            break
        print("Nota inválida. Ingrese una nota entre 0 y 3.5.")
        
    while True:
        ape = float(input("Ingrese la calificación de APE (3.5/10): "))
        if 0 <= ape <= 3.5:
            break
        print("Nota inválida. Ingrese una nota entre 0 y 3.5.")
        
    while True:
        aa = float(input("Ingrese la calificación de AA (3/10): "))
        if 0 <= aa <= 3.0:
            break
        print("Nota inválida. Ingrese una nota entre 0 y 3.0.")

def verificar_aprobacion(promedio):
    if promedio >= 7.0:
        return "Aprobado"
    else:
        return "En recuperación"

def obtener_recuperacion(promedio):
    if promedio < 7.0:
        print("\nEl estudiante no ha aprobado y debe rendir un examen de recuperación.")
        while True:
            recu = float(input("Ingrese la nota de recuperación (máximo 3.5): "))
            if 0 <= recu <= 3.5:
                break
            print("Nota inválida. Ingrese un valor entre 0 y 3.5.")
        promedio = promedio * 0.6 + recu
        if promedio >= 7.0:
            return "Aprobado (tras recuperación)", promedio
        else:
            return "Reprobado", promedio
    return "Aprobado", promedio

def mostrar_estadisticas(estadisticas_por_materia):
    print("\n=====================================================")
    print("Estadísticas por materia:")
    print("=====================================================")
    
    for materia, estadisticas in estadisticas_por_materia.items():
        total = sum(estadisticas)
        print(f"\nMateria: {materia}")
        print(f"Total de estudiantes: {total}")
        print(f"Aprobados: {estadisticas[0]} ({(estadisticas[0] * 100.0) / total:.2f}%)")
        print(f"Aprobados con recuperación: {estadisticas[1]} ({(estadisticas[1] * 100.0) / total:.2f}%)")
        print(f"Reprobados: {estadisticas[2]} ({(estadisticas[2] * 100.0) / total:.2f}%)")
    print("=====================================================")

def main():
    num_estudiantes = int(input("Ingrese el número de estudiantes en el curso: "))
    estadisticas_por_materia = {}

    for _ in range(num_estudiantes):
        # Ingresar datos de identificación del estudiante
        nombre, apellido, cedula, materia = ingresar_estudiante()

        # Ingresar notas
        acd, ape, aa = ingresar_notas()

        # Calcular el promedio
        promedio = acd + ape + aa
        estado, promedio_final = obtener_recuperacion(promedio)

        # Actualizar las estadísticas por materia
        if materia not in estadisticas_por_materia:
            estadisticas_por_materia[materia] = [0, 0, 0]  # [Aprobados, Aprobados con recuperación, Reprobados]

        if estado == "Aprobado":
            estadisticas_por_materia[materia][0] += 1
        elif estado == "Aprobado (tras recuperación)":
            estadisticas_por_materia[materia][1] += 1
        else:
            estadisticas_por_materia[materia][2] += 1

        # Mostrar resultados
        print("\nResultados del estudiante:")
        print("=====================================================")
        print(f"Cédula: {cedula}")
        print(f"Nombre: {nombre} {apellido}")
        print(f"Materia: {materia}")
        print(f"Promedio: {promedio_final:.2f}")
        print(f"Estado: {estado}")
        print("=====================================================")

    # Mostrar las estadísticas al final
    mostrar_estadisticas(estadisticas_por_materia)

if __name__ == "__main__":
    main()
