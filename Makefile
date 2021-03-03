all: run

clean:
	rm -f out/Main.jar out/Abbreviations.jar

out/Main.jar: out/parcs.jar src/Main.java src/Abbreviations.java
	@javac -cp out/parcs.jar src/Main.java src/Abbreviations.java
	@jar cf out/Main.jar -C src Main.class -C src Abbreviations.class
	@rm -f src/Main.class src/Abbreviations.class

out/Abbreviations.jar: out/parcs.jar src/Abbreviations.java
	@javac -cp out/parcs.jar src/Abbreviations.java
	@jar cf out/Abbreviations.jar -C src Abbreviations.class
	@rm -f src/Abbreviations.class

build: out/Main.jar out/Abbreviations.jar

run: out/Main.jar out/Abbreviations.jar
	@cd out && java -cp 'parcs.jar:Main.jar' Main