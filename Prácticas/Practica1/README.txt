1. Un analizador léxico es un módulo destinado a leer caracteres del archivo de entrada, donde se encuentra la cadena a analizar, reconocer subcadenas que correspondan a símbolos del lenguaje y retornar los tokens correspondientes y sus atributos.

2. Toma un código fuente como entrada y lo divide en simbolos que son válidos. El analizador reporta errores cuando un simbolo no es válido. Al final  produce como salida una serie de tokens. 

3. Primero se construye el AFN por medio de la construcción de Thompson. Luego usamos el algoritmo de los subconjuntos para pasar de AFN a AFD. Por último, minimizamos nuestro AFD mediante el algoritmo de minimización (los algoritmos fueron vistos en clase).
