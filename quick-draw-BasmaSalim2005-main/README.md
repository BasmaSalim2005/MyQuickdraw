# Quick Draw Reaction Game Implementation

In this assignment, you will implement the **Quick Draw** reaction game. The necessary resources are already provided in the `Resources.kt` file. The application uses the [Mosaic](https://github.com/JakeWharton/mosaic) and [JLine](https://github.com/jline/jline3) libraries to dynamically display content and handle keystrokes in the terminal. Make sure to run the application in the standard terminal of your operating system as dynamic display will not work when run in the IDE.

## Steps to Implement

### 1. Setup and Understand the Provided Files

- **[Resources.kt](src/main/kotlin/org/example/Resources.kt)**: Contains resources you might need.
- **[Main.kt](src/main/kotlin/org/example/Main.kt)**: Handles the main interaction of the application.
- **[GameImpl.kt](src/main/kotlin/org/example/game/GameImpl.kt)**: You will implement the missing components of this class.

### 2. Game Class

- The [GameImpl](src/main/kotlin/org/example/game/GameImpl.kt) class inherits from the [Game](src/main/kotlin/org/example/game/Game.kt) class.
- The [Game](src/main/kotlin/org/example/game/Game.kt) class already provides part of the implementation for your convenience.

### 3. Enums Provided

- **[Difficulty](src/main/kotlin/org/example/game/Difficulty.kt)**: Enum class with different difficulty levels to be used.
- **[GameState](src/main/kotlin/org/example/game/GameState.kt)**: Enum class that provides the state of the game.

## Implementation Details

- **GameImpl Class**: Implement the missing components in the [GameImpl](src/main/kotlin/org/example/game/GameImpl.kt) class. This class is crucial for the game logic.
- **GameState Management**: Use the [GameState](src/main/kotlin/org/example/game/GameState.kt) enum to update the value of the `gameState` field in the [Game](src/main/kotlin/org/example/game/Game.kt) class depending on the current game state.

## Libraries

- **Mosaic**: Used for dynamically displaying content in the terminal.
- **JLine**: Used for handling keystrokes in the terminal.

## Key Points

- Ensure the application runs in the standard terminal of your operating system.
- Use the provided enums and classes to manage game state and difficulty levels.
- Implement the core game logic in the [GameImpl](src/main/kotlin/org/example/game/GameImpl.kt) class.
- Make sure that all tests succeed and that the Detekt task succeeds as well


# Building and Running the Quick Draw Reaction Game

To run the application, first build the project into a jar file using the following command:


```sh
./gradlew jar
```

Then, from the root of the project, type:



```sh
java -jar build/libs/quick_draw-1.0-SNAPSHOT.jar
```