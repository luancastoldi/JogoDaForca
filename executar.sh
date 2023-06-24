#!/bin/bash
# Executa o nosso jogo (Linux)

#constroi a lista de arquivos .java
CLASSES=$(find . -name "*.java")

# Compila os arquivos Java
javac -d build -cp . $CLASSES

# Verifica se houve erros de compilação
if [ $? -ne 0 ]; then
    echo "Erros de compilação encontrados."
    exit 1
fi

# Executa o programa
java -cp build Main
