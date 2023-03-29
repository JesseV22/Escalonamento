import time

class Processo:
    def __init__(self, pid, owner, tempo, prioridade):
        self.pid = pid
        self.owner = owner
        self.tempo = tempo
        self.prioridade = prioridade

    def executar(self):
        print(f"Executando processo {self.pid} ({self.owner}), tempo restante: {self.tempo}")
        time.sleep(1)
        self.tempo -= 1

class Escalonador:
    def __init__(self):
        self.fila = []

    def adicionar_processo(self, pid, owner, tempo, prioridade):
        processo = Processo(pid, owner, tempo, prioridade)
        self.fila.append(processo)

    def imprimir_processos(self):
        print("Lista de Processos:")
        for processo in self.fila:
            print(f"PID: {processo.pid}, Owner: {processo.owner}, Tempo: {processo.tempo}, Prioridade: {processo.prioridade}")

    def escalonar_processos(self, tempo_execucao):
        while self.fila:
            processo_atual = self.fila.pop(0)
            while processo_atual.tempo > 0:
                processo_atual.executar()
                if processo_atual.prioridade > 0:
                    self.fila.insert(0, processo_atual)
                else:
                    self.fila.append(processo_atual)
                if len(self.fila) % 5 == 0:
                    resposta = input("Deseja adicionar outro processo? (s/n) ")
                    if resposta.lower() == "s":
                        self.adicionar_processo(int(input("PID: ")), input("Owner: "), int(input("Tempo: ")), int(input("Prioridade: ")))
            print(f"Processo {processo_atual.pid} ({processo_atual.owner}) finalizado.")
        print("Não existem mais processos na fila.")

escalonador = Escalonador()

while True:
    print("Selecione uma opção:")
    print("1 - Entrar um Processo")
    print("2 - Escalonar os Processos")
    print("3 - Imprimir os Processos")
    print("4 - Sair")
    opcao = int(input("Opção selecionada: "))

    if opcao == 1:
        pid = int(input("PID: "))
        owner = input("Owner: ")
        tempo = int(input("Tempo: "))
        prioridade = int(input("Prioridade: "))
        escalonador.adicionar_processo(pid, owner, tempo, prioridade)
    elif opcao == 2:
        escalonador.escalonar_processos(1)
    elif opcao == 3:
        escalonador.imprimir_processos()
    elif opcao == 4:
        break
    else:
        print("Opção inválida. Tente novamente.")
