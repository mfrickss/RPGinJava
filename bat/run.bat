@echo off
echo Executando RPG...
if not exist build\Main.class (
    echo Projeto nao compilado! Execute compile.bat primeiro.
    pause
    exit /b 1
)
java -cp build Main
pause 