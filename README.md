# Chess Game

A complete object-oriented chess game implementation in Java, designed with clean code principles and SOLID design patterns.

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Design Patterns](#design-patterns)
- [Class Structure](#class-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Design Principles](#design-principles)
- [Author](#author)

## 🎯 Overview

This project implements a fully functional chess game with proper object-oriented design principles. The game follows standard chess rules including piece movement validation, pawn promotion, and game state management. The implementation emphasizes modularity, reusability, and flexibility through the use of established design patterns.

## ✨ Features

- **Complete Chess Implementation**: All standard chess pieces with proper movement rules
- **Pawn Promotion**: Automatic promotion to Queen when pawn reaches the end
- **Move Validation**: Comprehensive validation for all piece movements
- **Game State Management**: Tracks game progress and status
- **Clean Architecture**: Implements MVC pattern with clear separation of concerns
- **Extensible Design**: Easy to add new pieces or modify existing behavior

## 🏗️ Architecture

The project follows the **Model-View-Controller (MVC)** pattern:

### Model Layer
- **Pieces**: `King`, `Queen`, `Rook`, `Bishop`, `Knight`, `Pawn`
- **Board Components**: `ChessBoard`, `Square`
- **Game Elements**: `Player`

### Controller Layer
- **ChessGameController**: Utility class with static methods for game operations
- **GameState**: Enum for tracking game status

### View Layer
- **ChessGame**: Main facade class that orchestrates the game
- **BoardPrinter**: Handles board display functionality

## 🎨 Design Patterns

### 1. MVC Pattern
Separates game logic (Model), user interface (View), and game control (Controller) for better maintainability.

### 2. Facade Pattern
`ChessGame` class provides a simplified interface to the complex chess game subsystem.

### 3. Singleton Pattern
`ChessBoard` implements singleton pattern ensuring only one board exists per game.

### 4. Utility Pattern
`ChessGameController` serves as a stateless utility class with reusable static methods.

## 📦 Class Structure

### Abstract Classes
- **`Piece`**: Base class for all chess pieces
- **`MovablePiece`**: Extended by all movable pieces, defines `move()` and `canMove()` methods

### Interfaces
- **`PieceDiagonalMove`**: For pieces that move diagonally (Bishop, Queen)
- **`PieceNormalMove`**: For pieces that move horizontally/vertically (Rook, Queen, King, Pawn)
- **`Board`**: Defines board operations like `getSquare()` and `initBoard()`

### Concrete Piece Classes
Each piece implements its specific movement logic:
- **King**: Moves one square in any direction with check validation
- **Queen**: Combines Rook and Bishop movement patterns
- **Rook**: Moves horizontally and vertically
- **Bishop**: Moves diagonally
- **Knight**: Moves in L-shape pattern
- **Pawn**: Forward movement with diagonal capture and promotion

### Core Classes
- **`Square`**: Represents a board position with coordinates and piece
- **`ChessBoard`**: 8x8 grid of squares with piece initialization
- **`Player`**: Stores player information and team affiliation

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Installation
1. Clone the repository:
```bash
git clone https://github.com/msheikh5/Chess-Game.git
cd Chess-Game
```

2. Compile the Java files:
```bash
javac *.java
```

3. Run the game:
```bash
java ChessGame
```

## 🎮 Usage

The game provides a console-based interface where players can:

1. **Make Moves**: Enter moves in standard chess notation
2. **View Board**: The board is displayed after each move
3. **Validate Moves**: All moves are automatically validated according to chess rules
4. **Track Game State**: The game monitors check, checkmate, and other game states

### Move Input Format
The game uses coordinate-based input validation with regex patterns to ensure proper move formatting.

## 🎯 Design Principles

### SOLID Principles Applied

#### Single Responsibility Principle (SRP)
- Each class has one responsibility (e.g., `BoardPrinter` only handles board display)
- Pieces only handle their specific movement logic

#### Open/Closed Principle (OCP)
- Pieces are closed for modification but open for extension
- New piece types can be added by extending existing classes

#### Liskov Substitution Principle (LSP)
- Subclasses can replace their parent classes without breaking functionality
- All `MovablePiece` subclasses can be used interchangeably

#### Interface Segregation Principle (ISP)
- Separate interfaces for diagonal (`PieceDiagonalMove`) and normal (`PieceNormalMove`) movement
- Classes implement only the interfaces they need

#### Dependency Inversion Principle (DIP)
- High-level modules don't depend on low-level implementations
- Abstractions are used instead of concrete classes where possible

### Clean Code Practices

- **Meaningful Names**: Classes, methods, and variables have descriptive names
- **Small Functions**: Methods are kept small and focused on single tasks
- **Minimal Arguments**: Functions use few parameters where possible
- **No Code Duplication**: Reusable logic is extracted into utility methods

## 🔧 Code Quality Features

- **Move Validation**: Comprehensive validation for all piece movements
- **Path Checking**: Ensures pieces cannot jump over other pieces (except Knight)
- **Team Validation**: Prevents capturing own pieces
- **Special Rules**: Implements pawn promotion and other chess-specific rules

## 📁 Project Structure

```
Chess-Game/
├── src/
│   ├── pieces/
│   │   ├── Piece.java
│   │   ├── MovablePiece.java
│   │   ├── King.java
│   │   ├── Queen.java
│   │   ├── Rook.java
│   │   ├── Bishop.java
│   │   ├── Knight.java
│   │   └── Pawn.java
│   ├── board/
│   │   ├── Board.java
│   │   ├── ChessBoard.java
│   │   ├── Square.java
│   │   └── BoardPrinter.java
│   ├── interfaces/
│   │   ├── PieceDiagonalMove.java
│   │   └── PieceNormalMove.java
│   ├── controller/
│   │   ├── ChessGameController.java
│   │   └── GameState.java
│   ├── Player.java
│   └── ChessGame.java
└── README.md
```

## 👨‍💻 Author

**Mohammad Alsheikh**
- Email: Malialsheikh2001@gmail.com
- GitHub: [@msheikh5](https://github.com/msheikh5)

## 📄 License

This project is created as part of an educational assignment demonstrating object-oriented programming principles and design patterns.

---

*This chess game implementation showcases clean code principles, SOLID design patterns, and proper object-oriented architecture. It serves as an excellent example of how to structure a complex application with multiple interacting components.*
