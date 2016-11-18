test:
	byacc -J -dv Parser.y && jflex Flex.flex
	javac *.java
	java Parser Prueba.txt

clean:
	rm Parser.java
	rm ParserTokens.java
	rm ParserVal.java
	rm Flexer.java
	rm *.output
	rm *.class
	rm *~
