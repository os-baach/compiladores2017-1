# Este programa es un script que sirve como prueba
# para el proyecto uno de la clase de compiladores.
# Area de un circulo:
print("INICIA EL SCRIPT")
pi = 3.1415926535
radio = 10
if radio > 9:
    area = (pi)*(radio**2)
    print("El area es: ")
    print(area)
else:
    print("El radio es muy chico")
    area = 0
# Factorial de 10
n = 10
acumulador = 1
primeraIteracion = True
while n > 0:
    if primeraIteracion == True:
        print("El factorial de ")
        print(n)
        print(" es: ")
        primeraIteracion = False
    acumulador = acumulador*n
    n = n-1
    if n == 0:
        print(acumulador)
# Fibonacci de 10
n = 10
acumulador1 = 0
acumulador2 = 1
primeraIteracion = True
if n == 0:
    print("Fibonacci de 0 es 0")
else:
    while n > 0:
        if primeraIteracion == True:
            print("Fibonacci de ")
            print(n)
            print(" es: ")
            primeraIteracion = False
        temp = acumulador1
        acumulador1 = temp + acumulador2
        acumulador2 = temp
        n = n-1
        if n == 0:
            print(acumulador1)
#Tabla de verdad de la implicacion
renglones = 4
print("Los valores en la implicacion logica son:")
while renglones > 0:
    if renglones == 1:
        p = False
        q = False
    elif renglones == 3:
        q = False
        p = True
    elif renglones == 2:
        q = True
        p = False
    else:
        p = True
        q = True
    renglones -= 1
    result = (not p) or q
    print(result)
print("FIN DEL SCRIPT")
