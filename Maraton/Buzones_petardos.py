print("Ingrese el numero de casos de prueba  asometer los buzones ")

# k numero de cajas de correo
# m numero de petardos
# n numero de casos de prueba 

while True:
    try:
        n = int(input("Ingrese el número de casos de prueba (entre 1 y 10): "))  # Convierte la entrada a un entero
        if 1 <= n <= 10:
            print("Usted ha elegido", n, "caso(s) de prueba")
            break  # Salir del bucle si el número es válido
        else:
            print("Por favor escoja un número entre 1 y 10")
    except ValueError:
        print("Entrada no válida. Por favor, ingrese un número entero.")

# matriz     
m1 = []