package net.snortum.wordle

import com.github.ajalt.mordant.terminal.Terminal

fun main() {
    Main().run()
}

class Main {
    private val t = Terminal()

    fun run() {
        var playAgain: String? = "yes"
        val game = Game()

        while (playAgain == "yes") {
            game.play()
            playAgain = t.prompt("Play another game?", default = "yes", choices = listOf("yes", "no"))
        }
    }
}
