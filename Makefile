all: build_jar clean

build_jar:  src/PlayWar.class src/WarWithRecycling.class src/WarWithoutRecycling.class src/Card.class src/Deck.class src/Player.class src/WarUtils.class 
	jar -vcfe0 War.jar src/PlayWar.class src/WarWithRecycling.class src/WarWithoutRecycling.class src/Card.class src/Deck.class src/Player.class src/WarUtils.class

src/PlayWar.class: src/PlayWar.java 
	javac src/PlayWar.java

src/WarWithRecycling.class: src/WarWithRecycling.java 
	javac src/WarWithRecycling.java

src/WarWithoutRecycling.class: src/WarWithoutRecycling.java 
	javac src/WarWithoutRecycling.java

src/Card.class: src/Card.java 
	javac src/Card.java

src/Deck.class: src/Deck.java 
	javac src/Deck.java

src/Player.class: src/Player.java 
	javac src/Player.java

src/WarUtils.class: src/WarUtils.java 
	javac src/WarUtils.java

clean: 
	$(RM) src/WarWithRecycling.class src/WarWithoutRecycling.class src/Card.class src/Deck.class src/Player.class src/WarUtils.class
