@echo off
echo Limpando arquivos compilados...
if exist build (
    rmdir /s /q build
    echo Pasta build removida com sucesso!
) else (
    echo Nenhum arquivo compilado encontrado.
)

REM Remove qualquer arquivo .class que possa estar na pasta src
for /r src %%i in (*.class) do (
    del "%%i"
    echo Removido: %%i
)

echo Limpeza concluida!
pause 