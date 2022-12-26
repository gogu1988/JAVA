@echo off

goto :function3

:function1
    echo This is function 1

:function2
    echo This is function 2
goto :eof

:function3
    echo This is function 3
    call :function1

exit
:: exit will stop the CMD commands and close the CMD window

timeout 15
:: will wait for 15 sec

exit /B 0
:: will exit only the script and will not close the CMD window

