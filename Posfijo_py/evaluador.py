from pila import Pila

class Evaluador:
    @staticmethod
    def es_operador(caracter):
        return caracter in {'+', '-', '*', '/', '^'}
    
    @staticmethod
    def prioridad_en_expresion(operador):
        if operador == '^':
            return 4
        if operador in {'*', '/'}:
            return 2
        if operador in {'+', '-'}:
            return 1
        if operador == '(':
            return 0
        return 0
    
    @staticmethod
    def prioridad_en_pila(operador):
        if operador == '^':
            return 3
        if operador in {'*', '/'}:
            return 1
        if operador in {'+', '-'}:
            return 2
        if operador == '(':
            return 0
        return 0
    
    @staticmethod
    def convertir_a_postfija(infija):
        pila = Pila(100)
        posfija = ""
        
        for letra in infija:
            if letra == ' ':
                continue
            if Evaluador.es_operador(letra):
                if letra == '(':
                    pila.push(letra)
                elif letra == ')':
                    while not pila.is_empty() and pila.top() != '(':
                        posfija += pila.pop()
                    if not pila.is_empty() and pila.top() == '(':
                        pila.pop()  # Remove '('
                else:
                    while (not pila.is_empty() and Evaluador.prioridad_en_pila(pila.top()) >= Evaluador.prioridad_en_expresion(letra)):
                        posfija += pila.pop()
                    pila.push(letra)
            else:
                posfija += letra
        
        while not pila.is_empty():
            posfija += pila.pop()
        
        return posfija
    
    @staticmethod
    def evaluar_infija(expresion):
        def aplicar_operacion(op, b, a):
            if op == '+':
                return a + b
            elif op == '-':
                return a - b
            elif op == '*':
                return a * b
            elif op == '/':
                return a / b
            elif op == '^':
                return a ** b
            raise ValueError("Operador no soportado")

        def precedencia(op):
            if op == '+' or op == '-':
                return 1
            if op == '*' or op == '/':
                return 2
            if op == '^':
                return 3
            return 0

        def es_numero(c):
            return c.isdigit()

        def operar_operadores(operadores, operandos):
            op = operadores.pop()
            b = operandos.pop()
            a = operandos.pop()
            resultado = aplicar_operacion(op, b, a)
            operandos.append(resultado)

        operadores = []
        operandos = []
        i = 0

        while i < len(expresion):
            c = expresion[i]

            if c.isspace():
                i += 1
                continue
            
            if es_numero(c):
                num = 0
                while i < len(expresion) and es_numero(expresion[i]):
                    num = num * 10 + int(expresion[i])
                    i += 1
                operandos.append(num)
                continue
            
            if c == '(':
                operadores.append(c)
            
            elif c == ')':
                while operadores and operadores[-1] != '(':
                    operar_operadores(operadores, operandos)
                operadores.pop()  # Quitar '('

            elif c in {'+', '-', '*', '/', '^'}:
                while (operadores and operadores[-1] in {'+', '-', '*', '/', '^'} and
                    precedencia(c) <= precedencia(operadores[-1])):
                    operar_operadores(operadores, operandos)
                operadores.append(c)
            
            i += 1

        while operadores:
            operar_operadores(operadores, operandos)

        return operandos[0]