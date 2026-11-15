public class ContaBancaria {
    private String nome;
    private double saldo;
    private double limiteChequeEspecial;
    private double usedChequeEspecial;
    private static final double taxa = 0.20;

    public ContaBancaria(String nome, double valor){
        this.nome = nome;
        this.saldo = valor;
        //define valor do cheque especial de acordo com a regra
        if(valor <= 500){
            this.limiteChequeEspecial = 50;

        }else  {
            this.limiteChequeEspecial = valor * 0.5;

        }
        this.usedChequeEspecial = 0.0;

    }

    //Consultar saldo
    public double consultarSaldo(){
        return saldo;
    }

    //consultar restante do saldo do cheque especial
    public double consultarChequeEspecialDisponivel(){
        return limiteChequeEspecial - usedChequeEspecial;
    }

    //Depositar dinheiro -devolvendo cheque especial se necessario
    public void depositar(double valor){
        if(usedChequeEspecial > 0){
            double totalAPagar = usedChequeEspecial * (1*taxa);
            if(valor >= totalAPagar){
            //cobre todo o debito + taxa
                valor -= totalAPagar;
                System.out.printf("Pagamento da taxa de cheque especial (%.2f) efetuado.\n", totalAPagar);
                usedChequeEspecial= 0.0;
            }else{
                //cobre parte do debito
                double parteCoberta = valor/ (1 + taxa);
                usedChequeEspecial -= parteCoberta;
                System.out.printf("Depósito parcial cobre %.2f do cheque usado (taxa incluída).\n", parteCoberta);
                valor = 0.0;
            }
        }
        // o que sobrar aumenta o saldo normal

        this.saldo += valor;
    }


    public void sacar(double valor){
       if (valor <= 0){
           System.out.println("Valor de saque deve ser positivo.");
           return;
       }
       if(valor <= saldo){
           saldo -= valor;
       }else {
           double restante = valor - saldo;
           //Usa todo o saldo disponivel
           saldo = 0.0;
           //Verifica se o cheque especial tem limite suficiente
           if(restante <= consultarChequeEspecialDisponivel()){
               usedChequeEspecial += restante;// registra uso do cheque
               // saldo permanece 0 (já que ultrapassou), mas registramos o débito

           }else{
               System.out.println("Operação não realizada: Limite do cheque especial insuficiente.");
               //devolve o saldo que havia sido reduzido
               saldo = valor - restante;
           }

       }

    }

    //Pagar boleto - mesma logica do saque(retira valor da conta)
    public void pagarBoleto(double valor){
        System.out.println("Pagamento de boleto de R$ " + String.format("%.2f", valor));
        sacar(valor);

    }
    // Verificar se a conta está usando cheque especial (se usedChequeEspecial > 0)
    public boolean estaUsandoChequeEspecial(){
        return usedChequeEspecial > 0;
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s | Saldo: R$ %.2f | Cheque Especial disponível: R$ %.2f | Uso do Cheque: R$ %.2f",
                nome, saldo, consultarChequeEspecialDisponivel(), usedChequeEspecial);
    }
}
