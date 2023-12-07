@echo off

rem --- Run Wordle ---

if defined JAVA_HOME goto foundJavaHome

rem Can we find Java from the PATH?
set JAVA=java.exe
%JAVA% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto setJarFile

echo JAVA_HOME is not set and "java.exe" can't be run from your PATH
goto fail:

:foundJavaHome
rem Make sure JAVA_HOME points to something reasonable
set JAVA="%JAVA_HOME%\bin\java.exe"
%JAVA% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto setJarFile

echo JAVA_HOME ("%JAVA_HOME%") points to an invalid java.exe
goto fail

:setJarFile
rem Java was found and works, set jar (remember to change the version numbers, see build.gradle.kts)
set JAR=build\libs\Wordle-0.5-standalone.jar
if exist "%JAR%" goto execute

rem Build the jar file
cmd /c .\gradlew build

:execute
%JAVA% -jar %JAR% 
goto end

:fail
echo Make sure Java is installed and JAVA_HOME points to the installation folder

:end 