package net.snortum.wordle

import org.junit.jupiter.api.*
import kotlin.test.assertEquals

class TestGame {
    private val game = Game()

    @Test
    fun test_when_guess_is_jumps_and_word_is_munch_then_M_inWord() {
        val actual = game.displayWordToGuess("jumps", "might")
        val expected = game.noLetter('J') +
                game.noLetter('U') +
                game.inWord('M') +
                game.noLetter('P') +
                game.noLetter('S')
        assertEquals(expected, actual)
    }

    @Test
    fun test_when_guess_is_jumps_and_word_is_comfy_then_M_rightPlace() {
        val actual = game.displayWordToGuess("jumps", "comfy")
        val expected = game.noLetter('J') +
                game.noLetter('U') +
                game.rightPlace('M') +
                game.noLetter('P') +
                game.noLetter('S')
        assertEquals(expected, actual)
    }

    @Test
    fun test_when_guess_is_jumps_and_word_is_chops_then_P_rightPlace_S_rightPlace() {
        val actual = game.displayWordToGuess("jumps", "chops")
        val expected = game.noLetter('J') +
                game.noLetter('U') +
                game.noLetter('M') +
                game.rightPlace('P') +
                game.rightPlace('S')
        assertEquals(expected, actual)
    }

    @Test
    fun test_when_guess_is_jumps_and_word_is_thuds_then_U_inWord_S_rightPlace() {
        val actual = game.displayWordToGuess("jumps", "thuds")
        val expected = game.noLetter('J') +
                game.inWord('U') +
                game.noLetter('M') +
                game.noLetter('P') +
                game.rightPlace('S')
        assertEquals(expected, actual)
    }

    @Test
    fun test_when_guess_is_jumps_and_word_is_momma_then_M_rightPlace() {
        val actual = game.displayWordToGuess("jumps", "momma")
        val expected = game.noLetter('J') +
                game.noLetter('U') +
                game.rightPlace('M') +
                game.noLetter('P') +
                game.noLetter('S')
        assertEquals(expected, actual)
    }

    @Test
    fun test_when_guess_is_entry_and_word_is_later_then_E_inWord_T_rightPlace_R_inWord() {
        val actual = game.displayWordToGuess("entry", "later")
        val expected = game.inWord('E') +
                game.noLetter('N') +
                game.rightPlace('T') +
                game.inWord('R') +
                game.noLetter('Y')
        assertEquals(expected, actual)
    }
}