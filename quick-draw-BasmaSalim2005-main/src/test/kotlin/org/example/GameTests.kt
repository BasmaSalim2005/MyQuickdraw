package org.example

import com.ginsberg.junit.exit.ExpectSystemExitWithStatus
import io.mockk.every
import io.mockk.mockkObject
import org.example.game.Game
import org.example.game.GameImpl
import org.example.game.GameState
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test
import kotlin.test.assertEquals

class GameTests {
    private var game: Game = GameImpl()

    @BeforeEach
    fun startUp() {
        game = GameImpl()
        mockkObject(game)
        every { game.getTimeToWait() } returns 100L // Time to wait before the shoot
    }

    companion object {
        @JvmStatic
        fun codeToTime() = listOf(
            Arguments.of(Resources.CODE_1, Resources.EASY_TIME),
            Arguments.of(Resources.CODE_2, Resources.MEDIUM_TIME),
            Arguments.of(Resources.CODE_3, Resources.HARD_TIME),
            Arguments.of(Resources.CODE_4, Resources.HARDER_TIME),
        )
    }

    private fun processGame(code: Int) {
        assertEquals(GameState.MENU, game.gameState)
        game.processCommand(code)
        assertEquals(GameState.WAIT, game.gameState)
    }

    private fun processWin(code: Int) {
        processGame(code)
        Thread.sleep(150L) // lead time
        assertEquals(GameState.FIRE, game.gameState)
        game.processCommand(Resources.SPACE_CODE)
        assertEquals(GameState.WIN, game.gameState)
    }

    private fun processExit() {
        game.processCommand(Resources.ESC_CODE)
    }

    @Test
    @ExpectSystemExitWithStatus(0)
    fun testExit() {
        assertEquals(GameState.MENU, game.gameState)
        processExit()
    }

    @ExpectSystemExitWithStatus(0)
    @ParameterizedTest
    @MethodSource("codeToTime")
    fun testWinAndExit(code: Int) {
        processWin(code)
        processExit()
    }

    @ParameterizedTest
    @MethodSource("codeToTime")
    fun testWinAndRepeat(code: Int) {
        processWin(code)
        game.processCommand(Resources.ENTER_CODE)
        assertEquals(GameState.MENU, game.gameState)
    }

    @ParameterizedTest
    @MethodSource("codeToTime")
    fun testTooFast(code: Int) {
        processGame(code)
        game.processCommand(Resources.ENTER_CODE)
        assertEquals(GameState.WAIT, game.gameState)
        game.processCommand(Resources.SPACE_CODE)
        assertEquals(GameState.LOSE_TOO_FAST, game.gameState)
    }

    @ParameterizedTest
    @MethodSource("codeToTime")
    fun testTooSlow(code: Int, time: Long) {
        processGame(code)
        assertEquals(GameState.WAIT, game.gameState)
        Thread.sleep(300L + time) // time to lose
        assertEquals(GameState.LOSE_TOO_SLOW, game.gameState)
    }
}
