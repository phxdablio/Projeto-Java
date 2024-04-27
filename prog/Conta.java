package prog;

public class Conta {
    // Atributos
    private String nome; // Nome da conta
    private int id; // ID da conta
    private double saldo; // Saldo da conta
    private Banco banco; // Referência ao banco associado à conta

    // Construtor da classe Conta
    public Conta(String nome, int id, double saldo, Banco banco) {
        this.nome = nome;
        this.id = id;
        this.saldo = saldo;
        this.banco = banco;
    }

    // Método synchronized para depositar dinheiro na conta
    public synchronized void depositar(double valor) {
        saldo += valor;
    }

    // Métodos getters e setters para os atributos privados

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
