@echo off

goto :displayName

:displayName
setlocal
set /P name=enter name
echo your name is %name%
endlocal

set /P number=Enter number
echo your number is %number%

goto :eof