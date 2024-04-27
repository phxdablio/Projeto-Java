package prog;

public class Funcionario extends Thread {
    private String nome; // Nome do funcionário
    private Conta contaSalario; // Conta para receber o salário
    private Conta contaInvestimento; // Conta para investimento do funcionário
    private Loja loja; // Referência à loja onde o funcionário trabalha
    private double salario; // Salário do funcionário
    private boolean pago; // Indica se o funcionário foi pago ou não

    public Funcionario(String nome, Conta contaSalario, Conta contaInvestimento, Loja loja, double salario) {
        this.nome = nome;
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
        this.loja = loja;
        this.salario = salario;
        this.pago = false; // Inicialmente, o funcionário não foi pago
    }

    @Override
    public void run() {
        while (!pago) { // Enquanto o funcionário não for pago, continua verificando
            synchronized (loja) { // Bloqueia o acesso concorrente à loja
                double lucroLoja = loja.getLucro(); // Obtém o lucro atual da loja
                if (lucroLoja >= salario) { // Se o lucro da loja for suficiente para pagar o salário
                    loja.sacar(salario); // Saque o salário da loja
                    contaSalario.depositar(salario); // Deposita o salário na conta do funcionário
                    contaInvestimento.depositar(280); // Deposita 280 reais na conta de investimento do funcionário
                    System.out.println("Pagamento para " + nome + " realizado. Saldo atual (Salário): " + contaSalario.getSaldo() + ", Saldo atual (Investimento): " + contaInvestimento.getSaldo());
                    pago = true; // Marca o funcionário como pago
                } else {
                    System.out.println("Lucro insuficiente para pagar " + nome); // Se o lucro da loja não for suficiente
                }
            }
            try {
                Thread.sleep(2000); // Espera 2 segundos antes de verificar novamente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Métodos getters e setters para os atributos privados

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public void setContaSalario(Conta contaSalario) {
        this.contaSalario = contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

    public void setContaInvestimento(Conta contaInvestimento) {
        this.contaInvestimento = contaInvestimento;
    }
}
