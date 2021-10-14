all: build_jar clean

build_jar:  src.PlayWar.class src.controller.WarWithRecycling.class src.controller.WarWithoutRecycling.class src.model.Card.class src.model.Deck.class src.model.Player.class src.controller.WarUtils.class ; jar -vcfe0 War.jar WarGame.class *.class

src.PlayWar.class: src.PlayWar.java ; javac src.PlayWar.java

src.controller.WarWithRecycling.class: src.controller.WarWithRecycling.java ; javac src.controller.WarWithRecycling.java

src.controller.WarWithoutRecycling.class: src.controller.WarWithoutRecycling.java ; javac src.controller.WarWithoutRecycling.java

src.model.Card.class: src.model.Card.java ; javac src.model.Card.java

src.model.Deck.class: src.model.Deck.java ; javac src.model.Deck.java

src.model.Player.class: src.model.Player.java ; javac src.model.Player.java

src.controller.WarUtils.class: src.controller.WarUtils.java ; javac src.controller.WarUtils.java

clean: ; rm *.class
