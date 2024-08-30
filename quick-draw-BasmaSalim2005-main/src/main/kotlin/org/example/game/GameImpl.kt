package org.example.game

import java.lang.System
import org.example.Resources

class GameImpl : Game() {
    private var selectedDifficulty: Difficulty? = null
    private var waitingStart: Long = 0
    private var fireT: Long = 0
    private var waitingTime: Long = 0

    override fun getTimeToWait(): Long {
        return (Resources.WAIT_MIN..Resources.WAIT_MAX).random()
    }

    override fun processCommand(code: Int) {
        when (gameState) {
            GameState.MENU -> MenuInput(code)
            GameState.WAIT -> WaitingState(code)
            GameState.FIRE -> FireState(code)
            GameState.WIN, GameState.LOSE_TOO_SLOW, GameState.LOSE_TOO_FAST -> toEndGame(code)
        }
    }

    private fun MenuInput(code: Int) {
        when (code) {
            Resources.CODE_1 -> Start(Difficulty.EASY)
            Resources.CODE_2 -> Start(Difficulty.MEDIUM)
            Resources.CODE_3 -> Start(Difficulty.HARD)
            Resources.CODE_4 -> Start(Difficulty.HARDER)
            Resources.ESC_CODE -> End()
        }
    }
    
    fun updateState(currentTime: Long) {
//        println(gameState)
        if (gameState == GameState.WAIT && currentTime - waitingStart >= waitingTime) {
            gameState = GameState.FIRE
            batch = Resources.FIRE
            fireT = currentTime
        }
//        println(gameState)
        
    }

    private fun WaitingState(code: Int) {
        if (code == Resources.SPACE_CODE) {
            gameState = GameState.LOSE_TOO_FAST
            batch = Resources.LOSE_TOO_FAST
        }
    }

    private fun FireState(code: Int) {
        if (code == Resources.SPACE_CODE) {
            val reactionTime = System.currentTimeMillis() - fireT
            gameState = if (reactionTime <= selectedDifficulty!!.milliseconds) {
                GameState.WIN
            } else {
                GameState.LOSE_TOO_SLOW
            }
            batch = when (gameState) {
                GameState.WIN -> Resources.WIN
                GameState.LOSE_TOO_SLOW -> Resources.LOSE_TOO_SLOW
                else -> batch
            }
        }
    }

    private fun toEndGame(code: Int) {
        when (code) {
            Resources.ENTER_CODE -> Reset()
            Resources.ESC_CODE -> End()
        }
    }

    private fun Start(diff: Difficulty) {
        gameState = GameState.WAIT
        batch = Resources.WAIT
        selectedDifficulty = diff
        waitingStart = System.currentTimeMillis()
        waitingTime = getTimeToWait()
    }

    private fun Reset() {
        gameState = GameState.MENU
        selectedDifficulty = null
        batch = Resources.MENU
    }

    private fun End() {
        System.exit(0)
    }
}

