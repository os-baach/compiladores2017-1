test:
	byacc -J -dv Parser.y && jflex Flex.flex
	javac Parser.java && javac Flexer.java
	java Parser ${file}

clean:
	rm *.java
	rm y.output
	rm *.class
