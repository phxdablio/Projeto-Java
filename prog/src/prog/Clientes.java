
package prog;

import java.util.Random;


public class Clientes extends Thread {
    // Atributos
    private String nome; // Nome do cliente
    private double saldo = 1000; // Saldo inicial do cliente (default: 1000)
    private Conta conta; // Conta do cliente
    private Loja loja01; // Referência à primeira loja
    private Loja loja02; // Referência à segunda loja
    private Banco banco; // Referência ao banco

    // Construtor da classe Clientes
    public Clientes(String nome, double saldo, Conta conta, Loja loja01, Loja loja02, Banco banco){
        this.nome = nome;
        this.saldo = saldo;
        this.conta = conta;
        this.saldo = 1000.00; // Define o saldo inicial como 1000 (sobrescreve o saldo inicial passado)
        this.loja01 = loja01;
        this.loja02 = loja02;
        this.banco = banco;
    }

    // Método run() para realizar as compras dos clientes
    public void run() {
        while (saldo > 0) { // Enquanto o saldo do cliente for positivo
            Random random = new Random(); // Instancia um objeto Random para escolher aleatoriamente entre as lojas
            // Escolhe aleatoriamente entre as duas lojas
            Loja lojaEscolhida = random.nextBoolean() ? loja01 : loja02;
            double valorCompra = saldo; // Cliente gasta todo o seu saldo

            // Realiza a transferência do valor da compra para a loja escolhida
            synchronized (this) {
                banco.transferir(valorCompra, this.conta, lojaEscolhida.getConta());
            }

            // Atualiza o saldo do cliente após a compra
            saldo = this.conta.getSaldo();

            // Verifica se o saldo é suficiente para continuar comprando
            if (saldo == 0) {
                System.out.println("Saldo de " + nome + " esgotado.");
                break; // Sai do loop se o saldo for esgotado
            }
        }
        System.out.println("Saldo final de " + nome + ": " + saldo); // Imprime o saldo final do cliente
    }

    // Método getter para a conta do cliente
    public Conta getConta(){
        return conta;
    }

    // Método setter para a conta do cliente
    public void setConta (Conta conta){
        this.conta = conta;
    }

    // Método getter para o nome do cliente
    public String getNome(){
        return nome;
    }

    // Método setter para o nome do cliente
    public void setNome(String nome){
        this.nome = nome;
    }

    // Método getter para o saldo do cliente
    public double getSaldo(){
        return saldo;
    }

    // Método setter para o saldo do cliente
    public void setSaldo(){
        this.saldo = 1000; // Define o saldo do cliente como 1000
    } 
}
