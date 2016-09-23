# Ejercicios teóricos:
> <b>1.¿Cuáles son las maneras de implementar un analizador sintáctico descendente?</b>
>> <b>R=</b>Codificado a mano, de descenso recursivo, y generados automáticamente. Los generados automáticamente pueden ser guiados por tablas o codificados directamente.

> <b>2.¿Qué características debe de cumplir una gramática libre de contexto para que pueda tener un reconocedor descendente recursivo sin caer en ciclos ni hacer backtrack?</b>
>> <b>R=</b>Ser "backtrack-free" o LL(1).

> <b>Respuesta 3 del ejercicio 2
>    3.¿Qué resultado da la evaluación de la expresión 3-2+8? Explica el motivo de los resultados </b>
>> <b>R=</b> De la gramática 1 el resultado es 9 y de la gramática 2 el resultado es -7.
>> Esto se debe a la manera en que se va generando el árbol de sintaxis abstracta, con la gramática 1 genera un subárbol con el menos y con la gramática 2 genera un subárbol con mas, por eso al momento de evaluar la expresión nos da un resultado distinto en cada una. 