package net.snortum.wordle

import com.github.ajalt.mordant.terminal.Terminal
import com.github.ajalt.mordant.rendering.TextColors.Companion.rgb
import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.rendering.TextStyles.*

class Game {
    private val dictionary = Dictionary()
    @OptIn(com.github.ajalt.mordant.terminal.ExperimentalTerminalApi::class)
    private val t = Terminal()
    private val inputPromptColor = rgb("#61afef")
    private val orange = rgb("#ffa500")
    private val guesses = mutableListOf<String>()
    private val alphabet = "abcdefghijklnmopqrstuvwxyz"
    private var notUsed = ""

    fun play() {
        var guessNo = 1
        guesses.clear()
        notUsed = alphabet
        val wordToGuess = dictionary.randomFiveLetterWord()
        help()

        while (guessNo <= 6) {
            val guess = getGuess()

            when (guess) {
                "/quit" -> return
                "/help" -> {
                    help()
                    continue
                }
                "/display" -> {
                    displayAll(wordToGuess)
                    continue
                }
                wordToGuess -> {
                    println("You guessed the word in $guessNo guesses!")
                    return
                }
            }

            guesses.add(guess)
            for (letter in guess) {
                notUsed = notUsed.replace(letter.toString(), "")
            }
            displayAll(wordToGuess)
            guessNo += 1
        }

        println("Sorry, you're out of guesses. The word was $wordToGuess.")
    }

    private fun help() {
        println("You get six tries to guess the five-letter word.\n\n" +
                "Letters colored like this ${rightPlace('W')}are the correct letter in the correct place\n" +
                "Letters colored like this ${inWord('W')}are in the word but not in the correct place\n\n" +
                "Enter ${(inputPromptColor + bold)("/quit")} to quit this game\n" +
                "Enter ${(inputPromptColor + bold)("/display")} to redisplay words\n" +
                "Enter ${(inputPromptColor + bold)("/help")} to see this display\n")
    }

    private fun displayAll(wordToGuess: String) {
        for (guess in guesses) {
            println(displayWordToGuess(guess, wordToGuess))
        }
        println("You are on guess number ${guesses.size}")
        val unusedLetters = notUsed.map { it.toString().uppercase() }.toTypedArray().joinToString(",")
        println("Unused letters: $unusedLetters")
    }

    private fun getGuess(): String {
        var guess: String?
        var invalid = true

        do {
            guess = t.prompt("Enter your guess")
            if (guess == null) {
                println("ERROR: Guess is NULL")
                continue
            }

            guess = guess.trim()
            if (guess == "/quit" || guess == "/display" || guess == "/help") break

            if (guess.length != 5) {
                println("You must enter a five-letter word")
                continue
            }

            if (!dictionary.findWord(guess)) {
                println("Your guess must be a word in the dictionary")
                continue
            }

            invalid = false
        } while (invalid)

        return guess!!
    }

    fun displayWordToGuess(guess: String, wordToGuess: String): String {
        var displayString = ""
        val processedLetters = mutableListOf<Char>()

        // Look at guess one char at a time
        for (index in 0..4) {
            if (guess[index] in processedLetters || guess[index] !in wordToGuess) {
                displayString += noLetter(guess[index].uppercaseChar())
                continue
            }

            // At this point we know there is a match in the word to guess
            displayString += if (guess[index] == wordToGuess[index]) {
                rightPlace(guess[index].uppercaseChar())
            } else  {
                inWord(guess[index].uppercaseChar())
            }

            // Match a char in word to guess only once
            processedLetters.add(guess[index])
        }

        return displayString
    }

    fun inWord(letter: Char): String = "${(orange + bold)(letter.toString())} "
    fun rightPlace(letter: Char): String = "${(green on white + bold)(letter.toString())} "
    fun noLetter(letter: Char): String = "${underline(letter.toString())} "
}