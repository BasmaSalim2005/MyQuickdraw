package org.example.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

abstract class Game {
    var gameState: GameState = GameState.MENU
        set(value) {
            batch = value.text
            field = value
        }

    var batch by mutableStateOf(gameState.text) // batch that is dynamically updated in the terminal

    abstract fun getTimeToWait(): Long

    abstract fun processCommand(code: Int)
}
