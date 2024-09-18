class Pila:
    def __init__(self, max):
        self.max = max
        self.tope = 0
        self.vector_pila = [None] * max
    
    def is_empty(self):
        return self.tope == 0
    
    def is_full(self):
        return self.tope == self.max
    
    def push(self, dato):
        if self.is_full():
            raise Exception("Pila llena")
        self.vector_pila[self.tope] = dato
        self.tope += 1
    
    def pop(self):
        if self.is_empty():
            raise Exception("Pila vacía")
        self.tope -= 1
        return self.vector_pila[self.tope]
    
    def top(self):
        if self.is_empty():
            raise Exception("Pila vacía")
        return self.vector_pila[self.tope - 1]
