package org.example.game

import org.example.Resources

@Suppress("MagicNumber")
enum class Difficulty(val milliseconds: Long) {
    EASY(Resources.EASY_TIME),
    MEDIUM(Resources.MEDIUM_TIME),
    HARD(Resources.HARD_TIME),
    HARDER(Resources.HARDER_TIME)
}
