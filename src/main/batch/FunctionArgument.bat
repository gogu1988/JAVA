@echo off

goto :userInput

:main
echo your number is %~1 and %~2
goto :eof

:userInput
set /P Number1=Enter first number
set /P Number2=Enter second number

call :main %Number1% %Number2%