from collections import defaultdict
# Scanner para la ER ab | (ab)* c

# Declaración de variables globales
global CATEGORIAS
global TRANSICIONES
global TYPE
global ESTADOS

ESTADOS = 7

# Primero pondremos las tablas a usar
CATEGORIAS = {'a': 'a', 'b': 'b', 'c':'c'}
CATEGORIAS = defaultdict(lambda: 'other', CATEGORIAS)

TRANSICIONES = {('s0', 'a'): 's1', ('s0', 'c'): 's5', ('s1', 'b'): 's2', ('s2', 'a'): 's3', ('s2', 'c'): 's5', ('s3', 'b'): 's4', ('s4', 'a'): 's3', ('s4', 'c'): 's5' }
TRANSICIONES = defaultdict(lambda: 'se', TRANSICIONES)

# Tipos de cadenas
TYPE = {'s2': "'ab'", 's5': "'(ab)*c'"}
TYPE = defaultdict(lambda: 'invalid', TYPE)

global stack
global inputpos
global failed
inputpos = 0
failed = {}

# Obtiene la siguiente palabra valida(?)
# entrada - la entrada a analizar
# cadena - la cadena total a analizar
def siguiente_palabra(entrada, cadena):
    global stack
    global inputpos
    global failed
    inicial = inputpos if inputpos != 0 else 0 
    entrada += ' '
    # Vaciamos el stack
    stack = []            
    estado = 's0' # Estado en el que estamos
    lexema = '' # Palabra leída hasta el momento
    iterador = 0 # Iterador de caracteres en la cadena
    # -1 representa error:
    stack.append(('bad', -1)) # Supongo que este paso es por si falla todo
    while estado is not 'se':
        sig = entrada[iterador] # Siguiente caracter a leer
        iterador += 1
        inputpos += 1
        lexema += sig
        if failed[(estado, inputpos)]:
            break
        if TYPE[estado] != 'invalid':
            stack = []
        stack.append((estado, inputpos))
        categoria = CATEGORIAS[sig] # Categoria del ultimo caracter leido
        estado = TRANSICIONES[(estado, categoria)]
    siguiente = entrada[iterador:]
    while estado != 'bad' and TYPE[estado] == 'invalid':
        failed[(estado, inputpos)] = True
        tupla = stack.pop()
        estado = tupla[0]
        inputpos = tupla[1]
        lexema = cadena[inicial:inputpos-1]
        siguiente = cadena[inputpos-1:]
        inputpos -= 1
    if TYPE[estado] != 'invalid':
        print('Prefijo reconocido: ' + lexema)
        print('Tipo del lexema: ' + TYPE[estado])
        if siguiente.isspace() or siguiente == '':
            return ''
        print('resta: ' + siguiente)
        return siguiente
    else:
        print('Palabra no reconocida')
        return ''
        
def reconoce(palabra):
    # Inicialización
    global inputpos
    global failed
    inputpos = 0
    copia = palabra[:]
    for i in range(ESTADOS): 
        for j in range(len(palabra) + 1):
            failed[('s' + str(i), j)] = False # Ningún estado ha fallado
    failed = defaultdict(lambda: False, failed)
    # Lectura de palabras
    while len(palabra) > 0:
        palabra = siguiente_palabra(palabra, copia)

# "Main"
reconoce(input("Escriba la palabra a analizar\n"))
