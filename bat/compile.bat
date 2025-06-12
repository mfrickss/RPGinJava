@echo off
echo Compilando projeto RPG...
mkdir build 2>nul
javac -d build -cp src src\Main.java src\Personagens\*.java src\Personagens\Monstros\*.java src\Personagens\Itens\*.java
if %errorlevel% equ 0 (
    echo Compilacao concluida com sucesso!
    echo Arquivos .class gerados em: build/
) else (
    echo Erro na compilacao!
)
pause 