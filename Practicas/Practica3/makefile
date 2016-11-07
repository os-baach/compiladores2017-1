test:
	byacc -J -dv Parser.y && jflex Flexer.flex
	javac *.java
	java Parser Prueba.txt

clean:
	rm *~
	rm *.class
	rm #*
	rm *.output
