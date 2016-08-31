Primera parte
1. Un analizador léxico es un módulo destinado a leer caracteres del archivo de entrada, donde se encuentra la cadena a analizar, reconocer subcadenas que correspondan a símbolos del lenguaje y retornar los tokens correspondientes y sus atributos.

2. Toma un código fuente como entrada y lo divide en simbolos que son válidos. El analizador reporta errores cuando un simbolo no es válido. Al final  produce como salida una serie de tokens. 

3. Primero se construye el AFN por medio de la construcción de Thompson. Luego usamos el algoritmo de los subconjuntos para pasar de AFN a AFD. Por último, minimizamos nuestro AFD mediante el algoritmo de minimización (los algoritmos fueron vistos en clase).

Segunda parte

1. Hicimos el analizador por tablas porque pensabamos copiar el código que Elisa nos dio en clase.
En retrospectiva, no fue tan buena idea, ya que fue difícil de programar. Lo bueno es que es muy portable.
El reconocimiento es lineal porque guardamos los estados que van a fallar en una lista y evitamos hacer rollbacks grandes con eso.

2. Sólo tengo que modificar los estados, transiciones, número de estados y tipos de palabras.
Todas éstas son variables globales, por lo que es muy sencillo.

3.
Archivo: analizador.flex

Análisis del código:

EL programa genera una clase llamada Flexer que es la clase donde
se genera el DFA (autómata de estados finitos determinista) que nos
sirve para saber cuando una expresión se encuentra aceptado en el
lenguaje que el código analizador.flex acepte.

El código incluye una cantidad de consecuencias para estados de
errores y finales. Para mantener la linealidad de la búsqueda de
patrones, se genera un único DFA y nunca retrocede durante la
búsqueda de los tokens léxicos. El el peor de los casos y como Flex
siempre trata de dar "la mordida más grande" tendrá que retorceder
hasta el patrón apropiado más chico pero nunca hacia un estado
anterior.

4.- El tipo de implemetación que genera JFlex es guiado por tablas, ya que toma como entrada un archivo con expresiones regulares y se especifican las cadenas que serán aceptadas y como salída nos da un programa que recibe un archivo .txt, lo que hace es comparar las cadenas de ese archivo con lo que tiene guardado el programa, en el se guardan tablas que nos índica los simbolos que son válidos y ve que si correspondan con las expresiones regulares que fueron definidas.
Entonces JFlex genera en su programa tablas para guardar los simbolos, expresiones regulares y cadenas que son aceptadas.
