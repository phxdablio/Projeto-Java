package prog;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Criando o banco
        Banco nubank = new Banco("nubank");

        // Criando as contas dos clientes
        Conta cliente01 = new Conta("Joao", 1, 1000.00, nubank);
        Conta cliente02 = new Conta("Marcos", 2, 1000.00, nubank);
        Conta cliente03 = new Conta("Caio", 3, 1000.00, nubank);
        Conta cliente04 = new Conta("Pedro", 4, 1000.00, nubank);
        Conta cliente05 = new Conta("Vinicius", 5, 1000.00, nubank);

        // Criando as contas das lojas
        Conta contaLoja01 = new Conta("Pichau", 6, 0, nubank);
        Conta contaLoja02 = new Conta("Kabum", 7, 0, nubank);

        // Criando as lojas
        Loja loja01 = new Loja("Pichau", contaLoja01, 100.00, nubank);
        Loja loja02 = new Loja("Kabum", contaLoja02, 100.00, nubank);

        // Criando os clientes
        Clientes joao = new Clientes("Joao", 1000.00, cliente01, loja01, loja02, nubank);
        Clientes marcos = new Clientes("Marcos", 1000.00, cliente02, loja01, loja02, nubank);
        Clientes caio = new Clientes("Caio", 1000.00, cliente03, loja01, loja02, nubank);
        Clientes pedro = new Clientes("Pedro", 1000.00, cliente04, loja01, loja02, nubank);
        Clientes vinicius = new Clientes("Vinicius", 1000.00, cliente05, loja01, loja02, nubank);

        // Criando as contas de salários e investimentos dos funcionários
        Conta salarioFuncionario01 = new Conta("Marcelo - Salario", 8, 0, nubank);
        Conta investimentoFuncionario01 = new Conta("Marcelo - Investimento", 12, 0, nubank);

        Conta salarioFuncionario02 = new Conta("Fabiana - Salario", 9, 0, nubank);
        Conta investimentoFuncionario02 = new Conta("Fabiana - Investimento", 13, 0, nubank);

        Conta salarioFuncionario03 = new Conta("Lucas - Salario", 10, 0, nubank);
        Conta investimentoFuncionario03 = new Conta("Lucas - Investimento", 14, 0, nubank);

        Conta salarioFuncionario04 = new Conta("Raquel - Salario", 11, 0, nubank);
        Conta investimentoFuncionario04 = new Conta("Raquel - Investimento", 15, 0, nubank);

        // Criando os funcionários
        Funcionario funcionario01 = new Funcionario("Marcelo", salarioFuncionario01, investimentoFuncionario01, loja01, 1120);
        Funcionario funcionario02 = new Funcionario("Fabiana", salarioFuncionario02, investimentoFuncionario02, loja01, 1120);
        Funcionario funcionario03 = new Funcionario("Lucas", salarioFuncionario03, investimentoFuncionario03, loja02, 1120);
        Funcionario funcionario04 = new Funcionario("Raquel", salarioFuncionario04, investimentoFuncionario04, loja02, 1120);

        // Exibindo informações iniciais
        System.out.println("Saldo inicial de " + joao.getNome() + ": " + joao.getConta().getSaldo());
        System.out.println("Saldo inicial de " + marcos.getNome() + ": " + marcos.getConta().getSaldo());
        System.out.println("Saldo inicial de " + caio.getNome() + ": " + caio.getConta().getSaldo());
        System.out.println("Saldo inicial de " + pedro.getNome() + ": " + pedro.getConta().getSaldo());
        System.out.println("Saldo inicial de " + vinicius.getNome() + ": " + vinicius.getConta().getSaldo());
        System.out.println("Saldo inicial da Loja " + loja01.getNome() + ": " + contaLoja01.getSaldo());
        System.out.println("Saldo inicial da Loja " + loja02.getNome() + ": " + contaLoja02.getSaldo());

        // Iniciando as threads dos clientes
        joao.start();
        marcos.start();
        caio.start();
        pedro.start();
        vinicius.start();

        // Aguardando a execução das threads dos clientes
        joao.join();
        marcos.join();
        caio.join();
        pedro.join();
        vinicius.join();

        // Exibindo os saldos
        System.out.println("Saldo atual de " + joao.getNome() + ": " + joao.getConta().getSaldo());
        System.out.println("Saldo atual de " + marcos.getNome() + ": " + marcos.getConta().getSaldo());
        System.out.println("Saldo atual de " + caio.getNome() + ": " + caio.getConta().getSaldo());
        System.out.println("Saldo atual de " + pedro.getNome() + ": " + pedro.getConta().getSaldo());
        System.out.println("Saldo atual de " + vinicius.getNome() + ": " + vinicius.getConta().getSaldo());
        System.out.println("Saldo atual da Loja " + loja01.getNome() + ": " + contaLoja01.getSaldo());
        System.out.println("Saldo atual da Loja " + loja02.getNome() + ": " + contaLoja02.getSaldo());

        // Iniciando as threads dos funcionários
        funcionario01.start();
        funcionario02.start();
        funcionario03.start();
        funcionario04.start();

        // Aguardando a execução das threads dos funcionários
        funcionario01.join();
        funcionario02.join();
        funcionario03.join();
        funcionario04.join();

        // Exibindo os saldos finais dos funcionários
        System.out.println("Saldo atual de " + funcionario01.getNome() + ": " + salarioFuncionario01.getSaldo());
        System.out.println("Saldo atual de " + funcionario02.getNome() + ": " + salarioFuncionario02.getSaldo());
        System.out.println("Saldo atual de " + funcionario03.getNome() + ": " + salarioFuncionario03.getSaldo());
        System.out.println("Saldo atual de " + funcionario04.getNome() + ": " + salarioFuncionario04.getSaldo());

        // Exibindo os saldos finais dos investimentos dos funcionários
        System.out.println("Saldo atual do Investimento de " + funcionario01.getNome() + ": " + investimentoFuncionario01.getSaldo());
        System.out.println("Saldo atual do Investimento de " + funcionario02.getNome() + ": " + investimentoFuncionario02.getSaldo());
        System.out.println("Saldo atual do Investimento de " + funcionario03.getNome() + ": " + investimentoFuncionario03.getSaldo());
        System.out.println("Saldo atual do Investimento de " + funcionario04.getNome() + ": " + investimentoFuncionario04.getSaldo());
    }
}
