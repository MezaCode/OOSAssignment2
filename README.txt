# *War*

**War** is a Java program that allows two players to play the card game War. This program allows the players to play two variations of War: War (with recycled cards) and War (without recycled cards). Created by Gideon Reyes, Mazen Shaban, Pedro Jusino, and Colleen Mati

Time spent: **24** hours spent in total

Created by Gideon Reyes, Mazan Shaban, Pedro Jusino and Colleen Mati

## Game Instructions
https://bicyclecards.com/how-to-play/war/

## Class Implementation
The War program uses the following OOP principles:
- **Creator**: The src.PlayWar class is responsible for creating instances of src.controller.WarType, depending on what the user input is.
- **Polymorphism**: src.controller.WarWithRecycling and src.controller.WarWithoutRecycling are different implementations of the src.controller.WarType class, they extend src.controller.WarType. This will allow future use of different implementations of War if it is desired.
- **Low Coupling**: src.controller.WarWithRecycling and src.controller.WarWithoutRecycling class maintain high cohesion by redirecting all of the utility methods (printScore, checkForGameOver, etc.) to the src.controller.WarUtils class. This allows the War implementations to keep a focused responsibility.
- **High Cohesion**: This was implemented when we organized all of the utility methods for checking certain actions of War in one class (i.e. src.controller.WarUtils).


## Class Diagram
<img src="WarUML.jpg">

## User Stories
- [x] Players can choose what variation of War to play by inputting 1 or 2 
- [x] If variation 1 is selected, the program prompts user to enter number of rounds wanting to be played
- [x] For each round, the program indicates the cards played by each player as well as which player won the round and their scores
  - [x] For variation 1, the program keeps players' scores based on the number of cards in their hands
  - [x] For variation 2, the program keeps players' scores based on the number of cards in their points piles
- [x] At the end of the game, the program prints the winner. If the game ends in a tie, the program results in a tie

## License

    Copyright [2021] [Gideon Reyes, Mazen Shaban, Pedro Jusino, Colleen Mati]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
