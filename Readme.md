# Sorry! Board Game

A Java implementation of the classic Sorry! board game, built for the HY-252 Object-Oriented Programming course at the University of Crete (2023-2024).

## Overview

A fully playable 2-player Sorry! board game with a graphical interface built using Java Swing. The game follows the official Sorry! rules with minor variations as specified in the course requirements. The architecture follows the MVC (Model-View-Controller) pattern to cleanly separate game logic from the UI.

## Features

- Full implementation of all 11 card types (1, 2, 3, 4, 5, 7, 8, 10, 11, 12, Sorry)
- Graphical 16x16 board with Start, Home, Safety Zone, and Slide squares
- 2 players (Red and Yellow) with 2 pawns each
- Slide mechanics — pawns slide to the end and bump others back to Start
- Safety Zone protection — opponent cards cannot affect pawns inside
- Card 7 split — move 7 spaces across two pawns
- Card 11 swap — optionally swap a pawn with the opponent
- Fold button — pass the turn when no valid move is available
- Card deck reshuffles automatically when exhausted
- Info panel showing current turn and cards remaining

## Tech Stack

- Language: Java
- GUI: Java Swing (JLayeredPane, JLabel, JButton, JTextArea)
- Architecture: MVC (Model-View-Controller)
- Testing: JUnit
- Documentation: Javadoc

## Project Structure

```
sorry-board-game/
├── src/
│   ├── model/
│   │   ├── Card.java            # Abstract base class for all cards
│   │   ├── NumberCard.java
│   │   ├── SorryCard.java
│   │   ├── Square.java          # Abstract base class for board squares
│   │   ├── StartSquare.java
│   │   ├── HomeSquare.java
│   │   ├── SafetyZoneSquare.java
│   │   ├── SlideSquare.java
│   │   ├── SimpleSquare.java
│   │   ├── Pawn.java
│   │   ├── Player.java
│   │   └── Deck.java
│   ├── controller/
│   │   └── Controller.java      # Game logic and turn management
│   └── view/
│       └── View.java            # Swing GUI
└── test/
    └── ...                      # JUnit tests
```

## Setup & Run

### Prerequisites

- Java JDK 11+
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans)

### Steps

1. Clone the repository

   ```bash
   git clone https://github.com/emiraldol/sorry-board-game.git
   cd sorry-board-game
   ```

2. Open the project in your IDE

3. Run the main class to start the game

## How to Play

1. The game starts with a random player going first
2. Click "Receive Card" to draw a card from the deck
3. Click on one of your pawns to move it according to the card rules
4. If no valid move exists, click "Fold Button" to pass your turn
5. The first player to move both pawns to the Home position wins

## Course

HY-252 — Object-Oriented Programming  
Department of Computer Science, University of Crete — 2023-2024
