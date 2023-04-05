@echo off

goto :main
:main
set /A number=1
if %number% EQU 1 (echo This is if statement)
goto :eof