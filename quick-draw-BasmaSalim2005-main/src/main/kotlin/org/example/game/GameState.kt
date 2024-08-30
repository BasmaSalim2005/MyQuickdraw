package org.example.game

import org.example.Resources

enum class GameState(val text: String) {
    MENU(Resources.MENU),
    WAIT(Resources.WAIT),
    FIRE(Resources.FIRE),
    LOSE_TOO_SLOW(Resources.LOSE_TOO_SLOW),
    LOSE_TOO_FAST(Resources.LOSE_TOO_FAST),
    WIN(Resources.WIN)
}
