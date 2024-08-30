package org.example

import com.jakewharton.mosaic.runMosaicBlocking
import com.jakewharton.mosaic.ui.Text
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import kotlinx.coroutines.*
import org.example.game.GameImpl
import org.jline.terminal.TerminalBuilder

fun main() = runMosaicBlocking {
        println("Welcome to Quick Drw reaction game!")
        println("To start the game press enter !")

        val terminal = TerminalBuilder.terminal()
        terminal.enterRawMode()
        val reader = terminal.reader()

        val game = GameImpl()
        val enter = reader.read()

        if (enter == Resources.ENTER_CODE) {
            setContent {
                Text(game.batch)
            }
        }

        withContext(IO) {

        launch {
            while (true) {
                val currentTime = System.currentTimeMillis()
                game.updateState(currentTime)
                delay(50L)
            }
        }

        while (true) {
            if (reader.ready()) {
                val symbol = reader.read()
                game.processCommand(symbol)
            }
            delay(50L)
        }
    }
}
        
    


