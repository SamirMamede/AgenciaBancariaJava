import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    public static void main(String[] args) throws Exception {
             contasBancarias = new ArrayList<Conta>();
             operacoes();

    }
    public static void operacoes(){
        System.out.println("-----------------BEM VINDO A NOSSA AGÊNCIA !!-----------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("-----------SELECIONE A OPERAÇÃO QUE DESEJA REALIZAR-----------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta    |");
        System.out.println("|   Opção 2 - Depositar      |");
        System.out.println("|   Opção 3 - Sacar          |");
        System.out.println("|   Opção 4 - Transferir     |");
        System.out.println("|   Opção 5 - Listar         |");
        System.out.println("|   Opção 6 - Sair           |");

        int operacao = entrada.nextInt();
        switch(operacao){
            case 1:
            criarConta();
            break;
            case 2:
            deposito();
            break;
            case 3:
            saque();
            break;
            case 4:
            transferencia();
            break;
            case 5:
            listarContas();
            break;
            case 6:
            System.out.println("Obrigado por usar nossos serviços, volte sempre!");
            System.exit(0);
            
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
            
        }
    }
    public static void criarConta(){
        
        System.out.println("\nNome: ");
        String nome = entrada.next();

        System.out.println("\nCPF: ");
        String cpf = entrada.next();

        System.out.println("\nE-mail: ");
        String email = entrada.next();

        Usuario cliente = new Usuario(nome, cpf, email);

        Conta conta = new Conta(cliente);
        
        contasBancarias.add(conta);
        System.out.println("Conta bancária criada com sucesso!");

        operacoes();
    }
    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if(contasBancarias.size() > 0){
            for(Conta clientes: contasBancarias){
                if(clientes.getNumeroConta() == numeroConta) {
                    conta = clientes;
                }  
            }
        }
        return conta;
    }
    public static void deposito(){
        System.out.println("Número conta: ");
        int numeroConta = entrada.nextInt();

        Conta conta = encontrarConta(numeroConta);
        if(conta != null){
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = entrada.nextDouble();
            conta.deposito(valorDeposito);
            System.out.println("Valor depositado com  sucesso!");
        } else{
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }
    public static void saque(){
        System.out.println("Número conta: ");
        int numeroConta = entrada.nextInt();

        Conta conta = encontrarConta(numeroConta);
        if(conta != null){
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = entrada.nextDouble();
            conta.saque(valorSaque);
            //System.out.println("Saque feito com  sucesso!");
        } else{
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }
    public static void transferencia(){
        System.out.println("Número da conta do remetente: ");
        int numeroContaRemetente = entrada.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null){
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = entrada.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
            if(contaDestinatario != null){
                System.out.println("Qual o valor da transferência? ");
                Double valorTransferencia = entrada.nextDouble();

                contaRemetente.transferencia(contaDestinatario, valorTransferencia);
            } else{
                System.out.println("Conta não encontrada!");
            }
        }else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }
    public static void listarContas(){
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else {
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();
    }
}
