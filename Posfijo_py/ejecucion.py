from evaluador import Evaluador

def main():
    evaluador = Evaluador()
    expresion = None

    while True:
        print("__________________________________________")
        print("__________________ MENU __________________")
        print("    1. Ingresar expresion                 ")         
        print("    2. Mostrar expresion en forma infija  ")
        print("    3. Mostrar expresion en forma postfija ")
        print("    4. Calcular resultado                  ")
        print("    5. Vaciar                             ")
        print("    6. Salir                              ")
        print("__________________________________________")
        opcion = int(input("    DIGITE UNA OPCION                     "))
        print("__________________________________________")

        if opcion == 1:
            expresion = input("Ingrese Expresion: ").strip()
            print("EXPRESION GUARDADA!")
        
        elif opcion == 2:
            if expresion:
                print("La expresion en su forma infija es:")
                print(expresion)
            else:
                print("No has ingresado ninguna expresion!!")
        
        elif opcion == 3:
            if expresion:
                postfija = evaluador.convertir_a_postfija(expresion)
                print("La expresion postfija es:")
                print(postfija)
            else:
                print("No has ingresado ninguna expresion!!")
        
        elif opcion == 4:
            if expresion:
                try:
                    resultado = evaluador.evaluar_infija(expresion)
                    print("El resultado de la expresion es:     ")
                    print(resultado)
                except Exception as e:
                    print(f"Error al evaluar la expresión: {e}")
            else:
                print("No has ingresado ninguna expresion!!")
        
        elif opcion == 5:
            expresion = None
            print("DATOS EN CERO!")
        
        elif opcion == 6:
            break
        
        else:
            print("Opción no válida. Intente de nuevo.")

if __name__ == "__main__":
    main()