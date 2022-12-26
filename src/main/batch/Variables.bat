set var=rahul

:: var
:: If we un-comment above line we will get the below error | var is treated as command
:: 'var' is not recognized as an internal or external command, operable program or batch file.

:: %var%
:: If we un-comment above line we will get the below error | rahul is treated as a command
::'rahul' is not recognized as an internal or external command, operable program or batch file.

echo %var%

set var=dir
%var%

set filename=test.txt
echo The file name is %filename%

set filename=dir
echo The file name is %filename%
:: In the above line dir is treated as string

echo The file name is
%filename%

