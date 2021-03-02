all: run

clean:
	rm -f out/Main.jar out/Negative.jar

out/Main.jar: out/parcs.jar src/Main.java src/Negative.java
	@javac -cp out/parcs.jar src/Main.java src/Negative.java
	@jar cf out/Main.jar -C src Main.class -C src Negative.class
	@rm -f src/Main.class src/Negative.class

out/Negative.jar: out/parcs.jar src/Negative.java
	@javac -cp out/parcs.jar src/Negative.java
	@jar cf out/Negative.jar -C src Negative.class
	@rm -f src/Negative.class

build: out/Main.jar out/Negative.jar

run: out/Main.jar out/Negative.jar
	@cd out && java -cp 'parcs.jar:Main.jar' Main