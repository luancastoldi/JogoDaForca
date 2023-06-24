:: [Windows] Esse arquivo facilita rodar o código, para que possa ser usado em outros editores.
@echo off
:: Compila os arquivos Java
javac -d build -cp . Main.java

:: Verifica se houve erros de compilação
if %errorlevel% neq 0 (
    echo Erros de compilação encontrados.
    pause
    exit /b
)

:: Executa o programa
java -cp build Main