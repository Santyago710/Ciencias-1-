import random

def max_candy_value(n, k, dispensers):
    #Cantidad de dispensadores n
    #Cantidad de dulces k
    # Inicializar tabla dp con infinito negativo
    dp = [[-float('inf')] * (k + 1) for _ in range(n + 1)] 
    dp[0][0] = 0
    
    # Llenado de la tabla dp
    for i in range(1, n + 1):
        for j in range(k + 1):
            # Caso donde sacamos 0 caramelos del i-ésimo dispensador
            dp[i][j] = dp[i-1][j]
            sum_val = 0
            #tomar l caramelos del i-ésimo dispensador
            for l in range(1, min(13, j + 1)):
                sum_val += dispensers[i-1][l-1]
                dp[i][j] = max(dp[i][j], dp[i-1][j-l] + sum_val)
    
    return dp[n][k]

# Ejemplo 1
n1 = 4 
k1 = 7
dispensers = [
    [3, 6, 8, 2, 2, 5, 6, 1, 2, 3, 1, 4],
    [4, 1, 1, 1, 1, 70, 4, 1, 5, 3, 2, 3],
    [5, 3, 2, 6, 6, 2, 3, 1, 6, 2, 3, 2],
    [1, 4, 3, 8, 4, 9, 2, 1, 6, 5, 4, 1]
]

print(("solcuion optima ejemplo 1"),max_candy_value(n1, k1, dispensers))  

# Ejemplo 2 
n2 = 1
k2 = 6
dispensers2 = [
    [20, 30, 40, 15, 1, 14, 200, 2, 300, 2, 2, 2]
]

print(("solcuion optima ejemplo 2"),max_candy_value(n2, k2, dispensers2))  

#Si se desea pedir los datos    
""""
def generate_dispensers(n):
    # Genera n dispensadores con 12 dulces cada uno
    dispensers = []
    for _ in range(n):
        # Cada dispensador tiene 12 valores entre 1 y 100
        dispenser = [random.randint(1, 100) for _ in range(12)]
        dispensers.append(dispenser)
    return dispensers

def main():
    # input de n y k
    n = int(input("Ingresa la cantidad de Dispensadores "))
    k = int(input("Ingresa el numero de dulces que quieres escoger "))

    #
    dispensers = generate_dispensers(n)
    
    # Imprime la matriz de los dulces
    print("Generated dispensers:")
    for i, dispenser in enumerate(dispensers):
        print(f"Dispenser {i + 1}: {dispenser}")

    # Imprime el valor del mayor valor de los dulces
    result = max_candy_value(n, k, dispensers)
    print(f"Maximum candy value: {result}")

if __name__ == "__main__":
    main()
"""