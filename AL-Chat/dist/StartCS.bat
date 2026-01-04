@ECHO off
TITLE Aion BeckUp 2.4 Classic - Chat Server Console
@COLOR 0B
SET PATH="..\Zulu\bin"
:START
CLS

ECHO Starting Aion 2.4 Classic Chat Server.
java -cp ./libs/*;AL-Chat.jar com.aionemu.chatserver.ChatServer
SET CLASSPATH=%OLDCLASSPATH%
IF ERRORLEVEL 2 GOTO START
IF ERRORLEVEL 1 GOTO ERROR
IF ERRORLEVEL 0 GOTO END
:ERROR
ECHO.
ECHO Chat Server has terminated abnormaly!
ECHO.
PAUSE
EXIT
:END
ECHO.
ECHO Chat Server is terminated!
ECHO.
PAUSE
EXIT
