# Teste desenvolvedor 1 - versão Java

Input e output são feitos via arquivo e podem ser especificados por linha de comando. Instruções que façam com que um rover saia da planície são ignoradas e uma mensagem de alerta é emitida pelo programa.


## Formas de uso

    java MoveRover C:\entrada.txt C:\saida.txt
Roda o programa utilizando `C:\entrada.txt` como arquivo de input e gera a saída em `C:\saida.txt`

---

    java MoveRover
Entende que o arquivo de entrada se chama `input.txt` e está localizado no mesmo diretório que o programa. 
Gera a saída em arquivo chamado `output.txt` no mesmo diretório do programa.

---

    java MoveRover C:\entrada
Utiliza `C:\entrada.txt` como arquivo de entrada, mas gera a saída como `output.txt` no mesmo diretório do programa

---

    java MoveRover -t
Utiliza o arquivo de teste como entrada e efetua rotina de teste após a execução. 
Gera a saída em arquivo chamado `output.txt` no mesmo diretório do programa.

---

    java MoveRover -t C:\saida.txt
Utiliza o arquivo de teste como entrada e efetua rotina de teste após a execução. Gera a saída em `C:\saida.txt`

## Compilando

Foi criado um arquivo `build.bat` para a compilação. Entretanto, o mesmo é bem simples: compile todas as classes na ordem correta:
```
del *.class
javac ReadFile.java                                                                                                                                                                                                                                                                                     
javac WriteFile.java 
javac Cardinal.java 
javac MoveRoverException.java
javac Rover.java
javac MoveRover.java
```

## Ambiente
Sistema WIndows 10 x64

### Versão do java (`java -version`)
```
java version "1.8.0_102"
Java(TM) SE Runtime Environment (build 1.8.0_102-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.102-b14, mixed mode)
```