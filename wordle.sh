#!/bin/sh

if [ -n $JAVA_HOME ]; then 
	JAVA="$JAVA_HOME/bin/java" 
	if [ ! -x $JAVA ]; then
		echo "JAVA_HOME ($JAVA_HOME) does not point to an executable Java" >&2
		exit
	fi
else
	JAVA=java
	if [ which $JAVA >/dev/nul 2>&1 ]; then
	      echo "You don't have JAVA_HOME set and 'java' cannot be found in your PATH" >&2
	      exit
	fi
fi

# Make sure the version numbers are correct in the Jar file name
JAR=build/libs/Wordle-0.1-standalone.jar

# If Jar file doesn't exists, build it
if [ ! -f $JAR ]; then
       ./gradlew build 
fi

$JAVA -jar $JAR
