left:
	byacc -J -dv GramI.y && jflex Flexer.flex
	javac Parser.java && javac Flexer.java
	java Parser ${file}

rigth:
	byacc -J -dv GramD.y && jflex Flexer.flex
	javac Parser.java && javac Flexer.java
	java Parser ${file}

clean:
	rm *.java
	rm y.output
	rm *.class
