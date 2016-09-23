# Parser para la gramática del ejercicio de clase
# Gramática equivalente:
# S -> bS' | Aa
# S' -> dAa | ε
# A -> cA | adA | ε

# Regresa True si la cadena está en el lenguaje y False en otro caso
def parse(cadena):
    lc = list(cadena)
    pila = []
    pila.append('eof') # Se mete el señalador de fin de la cadena 
    pila.append('S0') # Se mete el no-terminal incial
    i = 0 # Contador
    longitud = len(lc)
    while i < longitud:
        if lc[i] == 'a':
            if pila[-1] == 'S0':
                pila.pop()
                pila.append('a')
                pila.append('A0')
            elif pila[-1] == 'A0': # Caso con lookahead de 2
                    if i == (longitud-1): # lookahead eof
                        pila.pop()
                    elif lc[i+1] == 'd': # lookahead d
                        pila.pop()
                        pila.append('A0')
                        pila.append('d')
                        pila.append('a')
                    else:
                        return False
            elif pila[-1] == 'a':
                pila.pop()
                i += 1
            else:
                return False
        elif lc[i] == 'b':
            if pila[-1] == 'S0':
                pila.pop()
                pila.append('S1')
                pila.append('b')
            elif pila[-1] == 'b':
                pila.pop()
                i += 1
            else:
                return False
        elif lc[i] == 'c':
            if pila[-1] == 'S0':
                pila.pop()
                pila.append('a')
                pila.append('A0')
            elif pila[-1] == 'A0':
                pila.pop()
                pila.append('A0')
                pila.append('c')
            elif pila[-1] == 'c':
                pila.pop()
                i += 1
            else:
                return False
        elif lc[i] == 'd':
            if pila[-1] == 'S1':
                pila.pop()
                pila.append('a')
                pila.append('A0')
                pila.append('d')
            elif pila[-1] == 'd':
                pila.pop()
                i += 1
            else:
                return False
        else:
            return False
    while pila[-1] == 'S1':
        pila.pop() # Reducción con ε
    if pila[-1] == 'eof':
        return True
    else:
        return False                
                    
