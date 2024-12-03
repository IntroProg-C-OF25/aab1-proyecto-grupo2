import random

def main():
    mejoregresado = 7.0  
    mejorestudiante = ""  
    
    limite = int(input("Ingrese el número de estudiantes: "))
    
    for cont in range(1, limite + 1):
        promedio = 7 + (10 - 7) * random.random()  

        if promedio > mejoregresado:
            mejoregresado = promedio
            mejorestudiante = f"Estudiante {cont}"  
        elif promedio == mejoregresado:
            mejorestudiante += f" y Estudiante {cont}" 

        print(f"Estudiante {cont} - Promedio: {promedio:.2f}")

    print(f"El/los mejor(es) egresado(s): {mejorestudiante}")
    print(f"Con un promedio de: {mejoregresado:.2f}")
    if __name__ == "__main__":
        main()