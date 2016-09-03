1. La funcionalidad de contextos de JFlex es una herramienta que sirve para aceptar ciertas expresiones regulares sólo cuando estén seguidas de otras expresiones regulares.
Por ejemplo, si quisieramos aceptar a pero sólo seguida de b, entonces usamos la funcionalidad de contextos. Esta herramienta se llama en inglés 'arbitrary look-ahead' o 'trailing context'.
2. En lugar de poner %standalone al principio del documento, pones %debug.
En este modo, se imprime información extra por cada token o lexema.

