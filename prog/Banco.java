package prog;

public class Banco {
    // Atributos
    private String nome; // Nome do banco
    private Clientes clientes; // Referência aos clientes do banco
    private Conta conta; // Conta do banco
    private double valorCompra; // Valor da compra

    // Construtor
    public Banco(String nome) {
        this.nome = nome;
    }

    // Método getter para o nome do banco
    public String getNome() {
        return nome;
    }

    // Método setter para o nome do banco
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para a conta do banco
    public Conta getConta() {
        return conta;
    }

    // Método setter para a conta do banco
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    // Método para transferência de fundos entre contas
    public synchronized void transferir(double valorCompra, Conta pagador, Conta loja) {
        if (pagador.getSaldo() >= valorCompra) { // Se o pagador tiver saldo suficiente
            double restContaPagador = pagador.getSaldo() - valorCompra; // Calcula o saldo restante do pagador
            double addValorLoja = loja.getSaldo() + valorCompra; // Calcula o saldo da loja após a transferência
            pagador.setSaldo(restContaPagador); // Atualiza o saldo do pagador
            loja.setSaldo(addValorLoja); // Atualiza o saldo da loja
        } else {
            System.out.println("Erro de Transação: Saldo insuficiente"); // Se o pagador não tiver saldo suficiente
        }
    }
}
