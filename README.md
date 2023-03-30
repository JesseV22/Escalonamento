# Escalonamento
 Projeto de Escalonamento em python Da Aula de SOPA-trab-1
 
Explicação do código:

A classe Processo representa um processo do sistema, com seus respectivos pid, owner, tempo e prioridade. O método executar é responsável por simular a execução do processo, mostrando na tela seu pid, owner e tempo restante, e diminuindo seu tempo em 1 segundo a cada execução.

A classe Escalonador representa o
Cliente
continua

escalonador, que possui uma lista de processos (fila) e métodos para adicionar um processo à fila (adicionar_processo), imprimir os processos restantes (imprimir_processos) e escalonar os processos na fila (escalonar_processos).

O método escalonar_processos é o responsável por realizar o escalonamento dos processos na fila. Ele utiliza um loop while para percorrer a fila de processos, executando um de cada vez e intercalando entre eles. O parâmetro tempo_execucao é utilizado para determinar o tempo de processamento que deve ser usado para cada processo.

Se o processo tiver prioridade maior que zero, ele será inserido no início da fila. Caso contrário, ele será inserido no final da fila. A cada 5 processamentos, o usuário é perguntado se deseja adicionar outro processo à fila.

O loop while do método escalonar_processos só será interrompido quando não houver mais processos na fila. Nesse caso, uma mensagem é exibida informando que não existem mais processos na fila.

No código principal, é criada uma instância da classe Escalonador e um menu com quatro opções é exibido na tela. Dependendo da opção selecionada pelo usuário, o método correspondente da classe Escalonador é chamado.




![Captura de tela do aplicativo](https://github.com/JesseV22/Escalonamento/blob/main/Captura%20de%20tela%20de%202023-03-29%2021-15-20.png?raw=true)

