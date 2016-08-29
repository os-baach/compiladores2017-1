from collections import defaultdict
# Scanner para la ER ab | (ab)* c

# Declaración de variables globales
global CATEGORIAS
global TRANSICIONES
global TYPE
global INPUTPOS
global FAILED
global STACK
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
def siguiente_palabra(entrada):
    global stack
    global inputpos
    global failed
    inputpos = 0
    for i in range(ESTADOS): 
        for j in range(len(entrada) + 1):
            failed[('s' + str(i), j)] = False # Ningún estado ha fallado
    failed = defaultdict(lambda: True, failed)
    entrada += ' '
    stack = []            
    estado = 's0' # Estado en el que estamos
    lexema = '' # Palabra leída hasta el momento
    # Vaciamos el stack
    # -1 representa error:
    stack.append(('bad', -1)) # Supongo que este paso es por si falla todo
    while estado is not 'se':
        sig = entrada[inputpos] # Siguiente caracter a leer
        inputpos += 1
        lexema += sig
        if failed[(estado, inputpos)]:
            break
        if TYPE[estado] != 'invalid':
            stack = []
        stack.append((estado, inputpos))
        categoria = CATEGORIAS[sig] # Categoria del ultimo caracter leido
        estado = TRANSICIONES[(estado, categoria)]
    siguiente = entrada[inputpos:]
    while estado != 'bad' and TYPE[estado] == 'invalid':
        failed[(estado, inputpos)] = True
        tupla = stack.pop()
        estado = tupla[0]
        inputpos = tupla[1]
        inputpos -= 1 # Según yo esto simula Rollback
        lexema = lexema[:inputpos]
        siguiente = entrada[inputpos:]
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
    while len(palabra) > 0:
        palabra = siguiente_palabra(palabra)
        
reconoce(input("Escriba la palabra a analizar\n"))
