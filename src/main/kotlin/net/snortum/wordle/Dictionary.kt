package net.snortum.wordle

class Dictionary {
    private lateinit var words: List<String>

    init {
        val fileName = "/words.txt"
        val inputStream = javaClass.getResourceAsStream(fileName)

        if (inputStream == null) {
            println("ERROR: could not find resource: $fileName")
        } else {
            words = inputStream.bufferedReader().readLines().toList()
        }
    }

    fun randomFiveLetterWord(): String = words.random()

    fun findWord(guess: String): Boolean = words.contains(guess)
}