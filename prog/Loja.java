package prog;

public class Loja {
    // Atributos
    private String nome; // Nome da loja
    private Conta conta; // Conta da loja
    private double lucro; // Lucro da loja
    private Banco banco; // Referência ao banco associado à loja

    // Construtor da classe Loja
    public Loja(String nome, Conta conta, double lucro, Banco banco) {
        this.nome = nome;
        this.conta = conta;
        this.lucro = lucro;
        this.banco = banco;
    }

    // Método synchronized para obter o nome da loja
    public synchronized String getNome() {
        return nome;
    }

    // Método synchronized para definir o nome da loja
    public synchronized void setNome(String nome) {
        this.nome = nome;
    }

    // Método synchronized para obter a conta da loja
    public synchronized Conta getConta() {
        return conta;
    }

    // Método synchronized para definir a conta da loja
    public synchronized void setConta(Conta conta) {
        this.conta = conta;
    }

    // Método synchronized para obter o lucro da loja
    public synchronized double getLucro() {
        return lucro;
    }

    // Método synchronized para definir o lucro da loja
    public synchronized void setLucro(double lucro) {
        this.lucro = lucro;
    }

    // Método synchronized para obter o banco associado à loja
    public synchronized Banco getBanco() {
        return banco;
    }

    // Método synchronized para definir o banco associado à loja
    public synchronized void setBanco(Banco banco) {
        this.banco = banco;
    }

    // Método synchronized para sacar dinheiro do lucro da loja
    public synchronized void sacar(double valor) {
        if (valor <= lucro) { // Se o valor do saque for menor ou igual ao lucro da loja
            banco.transferir(valor, conta, banco.getConta()); // Realiza a transferência do lucro para a conta do banco
            lucro -= valor; // Deduz o valor do lucro da loja
        } else {
            System.out.println("Lucro insuficiente para pagar " + nome); // Se o lucro for insuficiente para o saque
        }
    }
}
