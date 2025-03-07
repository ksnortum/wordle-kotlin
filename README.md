# Wordle

This is a Wordle game written in Kotlin with a simple command-line interface.  It is meant to emulate the 
New York Times version of the game, except for the [dictionary](#dictionary).

## Execution

Any execution method will need Java 11 and up.

Probably the easiest way to run the app is to create a project in your IDE and run it from there.  A close
second would be to go to a command line, change directories (folders) to the installation folder and type
`./wordle.sh` in Linux or `.\wordle.bat` in Windows.  Otherwise, you can build it by issuing this Gradle 
command in the installation directory:

#### Linux

    ./gradlew build

#### Windows 

    .\gradlew build

Then execute the app with:

#### Linux

    ./gradlew run -q --console=plain

#### Windows

    .\gradlew run -q --console=plain

Or you can execute the app using the Java jar file.  From the installation directory, type:

#### Linux

    java -jar build/libs/Wordle-0.5-standalone.jar

#### Windows

    java -jar build\libs\Wordle-0.5-standalone.jar

## Colors

Being red/green colorblind, I am sensitive to the choice of colors.  The NYTimes version of Wordle uses orange and
green, which are very hard for me to tell apart.  So the letters that are in the right place are still green, but
the background is white (or grey on a terminal with a white background.)  This makes it easy for me to 
distinguish the two, but is still the color scheme that most people are used to. 

## Dictionary

The dictionary is just a text file called `words.txt` with one word per line located in `src/main/resources`.
You can also build your own dictionary.  If your system has a text dictionary with one word per line, like
`/usr/share/dict/words`, there is a Python program in `src/main/resources` called `build_words.py` that will create the
file from scratch.

One thing that is not easy to do is filter out plurals, so they are left in.  They are not legal in the NYTimes
version of Wordle, so be aware of that.

The word list is somewhat curated.  It contains no offensive words or racial slurs that I can think of, but some may
have gotten past me.

## Related Projects
* https://github.com/ksnortum/find-words-web
* https://github.com/ksnortum/find-words-java
* https://github.com/ksnortum/find-words-python
* https://github.com/ksnortum/wordle-kotlin (this site)
* https://github.com/ksnortum/wordle-python
