import java.util.Scanner;
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o nome do Cliente: ");
    String nome = sc.nextLine();

    System.out.println("Digite o valor do deposito inicial: ");
    double deposito = sc.nextDouble();
    ContaBancaria contaBancaria = new ContaBancaria(nome, deposito);


    int i;
    do {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Consultar cheque especial disponível");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Pagar boleto");
        System.out.println("6 - Verificar uso de cheque especial");
        System.out.println("7 - Sair");
        System.out.print("Escolha: ");
        i = sc.nextInt();

        switch (i) {
            case 1:
                System.out.printf("Saldo: R$ %.2f%n", contaBancaria.consultarSaldo());
                break;
            case 2:
                System.out.printf("Cheque especial disponível: R$ %.2f%n",
                    contaBancaria.consultarChequeEspecialDisponivel());
                break;
            case 3:
                System.out.print("Valor a depositar: ");
                double valorDep = sc.nextDouble();
                contaBancaria.depositar(valorDep);
                System.out.println("Depósito concluído.");
                break;
            case 4:
                System.out.print("Valor a sacar: ");
                double valorSaq = sc.nextDouble();
                contaBancaria.sacar(valorSaq);
                break;
            case 5:
                System.out.print("Valor do Boleto: ");
                double valorBoleto = sc.nextDouble();
                contaBancaria.pagarBoleto(valorBoleto);
                break;
            case 6:
                System.out.println(contaBancaria.estaUsandoChequeEspecial()
                    ? "A conta está usando cheque especial."
                    : "A conta NÃO esta usando cheque especial.");
                break;
            case 7:
                System.out.println("Encerrando...");
                break;
            default:
                System.out.println("Opção Inválida.");

        }
        //Mostra o estado atual da conta apos cada operacao
        System.out.println("\nEstado da conta: ");
        System.out.println(contaBancaria);

    } while (i != 7);
sc.close();

}
