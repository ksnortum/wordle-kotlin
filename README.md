# Wordle

This is a Wordle game written in Kotlin with a simple command-line interface.  It is meant to emulate the 
New York Times version of the game, except for the [dictionary](#dictionary).

## Execution

Any execution method will need [Java 17](https://www.oracle.com/java/technologies/downloads/#java17) and up. 
(It will work with Java 11 if that's what you have already.)

Probably the easiest way to run the app is to create a project in your IDE and run it from there.  A close
second would be to go to a command line, change directories (folders) to the installation folder and type
`./wordle.sh` in Linux or `.\wordle` in Windows.  Otherwise, can build it by issuing this Gradle command in 
the installation directory:

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

    java -jar build/libs/Wordle-x.y-standalone.jar

#### Windows

    java -jar build\libs\Wordle-x.y-standalone.jar

...where `x` and `y` are the version of the app.

## Colors

Being red/green colorblind, I am sensitive to the choice of colors.  The NYTimes version of Wordle uses orange and
green, which are very hard for me to tell apart.  So the letters that are in the right place are still orange, but
the background is white (or grey on a terminal with a white background.)  This makes it easy for me to tell the
two apart, but is still the color scheme that most people are used to. 

## Dictionary

The dictionary is just a text file called `words.txt` located in `src/main/resources`.  I have a Python program
in that directory call `build_words.py` that will create the file from `/usr/share/dict/words`.  You can change
that in the script.

One thing that is not easy to do is filter out plurals, so they are left in.  They are not legal in the NYTimes
version of Wordle, so be aware of that.  Also, the dictionary is not curated at all, so there's words in it that
would probably be removed NYTimes version.
