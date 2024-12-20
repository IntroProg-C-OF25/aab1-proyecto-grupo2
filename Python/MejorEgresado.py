import random

def main():
    mejoregresado = 7.0  # Nota inicial para comparar
    mejorestudiante = ""  # Para almacenar el nombre o índice del mejor estudiante
    
    limite = int(input("Ingrese el número de estudiantes: "))
    cont = 1  # Contador inicial para el bucle
    
    while cont <= limite:  # Repetir hasta que se cubran todos los estudiantes
        promedio = 7 + (10 - 7) * random.random()  # Generar un promedio aleatorio entre 7 y 10

        if promedio > mejoregresado:
            mejoregresado = promedio
            mejorestudiante = f"Estudiante {cont}"  # Actualizar el mejor estudiante
        elif promedio == mejoregresado:
            mejorestudiante += f" y Estudiante {cont}"  # Manejar empate

        print(f"Estudiante {cont} - Promedio: {promedio:.2f}")
        cont += 1  # Incrementar el contador

    print("-------------------------------------------------")
    print(f"El/los mejor(es) egresado(s): {mejorestudiante}")
    print(f"Con un promedio de: {mejoregresado:.2f}")
    print("-------------------------------------------------")

# Ejecución principal
if __name__ == "__main__":
    main()
#Ingrese el número de estudiantes: 4
#Estudiante 1 - Promedio: 8.19
#Estudiante 2 - Promedio: 9.05
#Estudiante 3 - Promedio: 8.22
#Estudiante 4 - Promedio: 8.74
#-------------------------------------------------
#El/los mejor(es) egresado(s): Estudiante 2
#Con un promedio de: 9.05
