all: build_jar clean

build_jar:  PlayWar.class WarWithRecycling.class WarWithoutRecycling.class Card.class Deck.class Player.class WarUtils.class ; jar -vcfe0 War.jar WarGame.class *.class

PlayWar.class: PlayWar.java ; javac PlayWar.java

WarWithRecycling.class: WarWithRecycling.java ; javac WarWithRecycling.java

WarWithoutRecycling.class: WarWithoutRecycling.java ; javac WarWithoutRecycling.java

Card.class: Card.java ; javac Card.java

Deck.class: Deck.java ; javac Deck.java

Player.class: Player.java ; javac Player.java

WarUtils.class: WarUtils.java ; javac WarUtils.java

clean: ; rm *.class
