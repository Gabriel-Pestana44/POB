package view;

import controller.FuncionarioController;
import model.Desenvolvedor;
import model.Gerente;
import model.Treinador;

import java.util.Scanner;

public class FuncionarioView {
    private Scanner scanner = new Scanner(System.in);
    private FuncionarioController controller = new FuncionarioController();

    public void menu() {
        controller.carregarDeArquivo();

        while (true) {
            System.out.println("\n1. Cadastrar\n2. Listar\n3. Atualizar\n4. Excluir\n5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> controller.listarFuncionarios();
                case 3 -> atualizar();
                case 4 -> excluir();
                case 5 -> System.exit(0);
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrar() {
        System.out.println("Tipo (1-Desenvolvedor, 2-Gerente, 3-Treinador):");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        System.out.println("Salário:");
        double salario = scanner.nextDouble();

        switch (tipo) {
            case 1 -> controller.cadastrarFuncionario(new Desenvolvedor(nome, salario));
            case 2 -> controller.cadastrarFuncionario(new Gerente(nome, salario));
            case 3 -> controller.cadastrarFuncionario(new Treinador(nome, salario));
            default -> System.out.println("Tipo inválido!");
        }
    }

    private void atualizar() {
        System.out.println("Nome do funcionário a atualizar:");
        String nome = scanner.nextLine();
        System.out.println("Novo nome:");
        String novoNome = scanner.nextLine();
        System.out.println("Novo salário:");
        double novoSalario = scanner.nextDouble();
        controller.atualizarFuncionario(nome, novoNome, novoSalario);
    }

    private void excluir() {
        System.out.println("Nome do funcionário a excluir:");
        String nome = scanner.nextLine();
        controller.excluirFuncionario(nome);
    }
}
