import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscalonadorDeProcessos {

    private static final int QUANTUM = 5; // tempo de processamento para cada processo
    private static List<Processo> listaDeProcessos = new ArrayList<>();
    private static int contadorDeProcessos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Entrar um Processo");
            System.out.println("2. Escalonar os Processos");
            System.out.println("3. Imprimir os Processos");
            System.out.println("4. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Entre com o PID:");
                    int pid = scanner.nextInt();
                    System.out.println("Entre com o Owner:");
                    String owner = scanner.next();
                    System.out.println("Entre com o Tempo do Processo:");
                    int tempoDeProcesso = scanner.nextInt();
                    Processo processo = new Processo(pid, owner, tempoDeProcesso);
                    listaDeProcessos.add(processo);
                    contadorDeProcessos++;
                    if (contadorDeProcessos % 5 == 0) {
                        System.out.println("Deseja adicionar outro processo? (S/N)");
                        String resposta = scanner.next();
                        if (resposta.equalsIgnoreCase("N")) {
                            opcao = 4; // sair
                        }
                    }
                    break;
                case 2:
                    if (listaDeProcessos.isEmpty()) {
                        System.out.println("Não há processos a serem escalonados.");
                    } else {
                        while (!listaDeProcessos.isEmpty()) {
                            for (int i = 0; i < listaDeProcessos.size(); i++) {
                                Processo processoAtual = listaDeProcessos.get(i);
                                int tempoRestante = processoAtual.getTempoDeProcesso();
                                if (tempoRestante > 0) {
                                    System.out.println("Executando processo " + processoAtual.getPid() +
                                            " (" + processoAtual.getOwner() + "), tempo restante: " + tempoRestante);
                                    tempoRestante -= QUANTUM;
                                    if (tempoRestante < 0) {
                                        tempoRestante = 0;
                                    }
                                    processoAtual.setTempoDeProcesso(tempoRestante);
                                } else {
                                    listaDeProcessos.remove(i);
                                }
                            }
                        }
                        System.out.println("Todos os processos foram executados.");
                    }
                    break;
                case 3:
                    if (listaDeProcessos.isEmpty()) {
                        System.out.println("Não há processos a serem impressos.");
                    } else {
                        System.out.println("Lista de processos:");
                        for (Processo processo : listaDeProcessos) {
                            System.out.println(processo);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    private static class Processo {
        private int pid;
        private String owner;
        private int tempoDeProcesso;

        public Processo(int pid, String owner, int tempoDeProcesso) {
            this.pid = pid;
            this.owner = owner;
            this.tempoDeProcesso = tempoDeProcesso;
        }

        public int getPid() {
           
