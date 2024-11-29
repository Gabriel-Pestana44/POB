package controller;

import model.Funcionario;
import model.Desenvolvedor;
import model.Gerente;
import model.Treinador;

import java.io.*;
import java.util.ArrayList;

public class FuncionarioController {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        salvarEmArquivo();
    }

    public void listarFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println(f.mostrarDetalhes());
        }
    }

    public void atualizarFuncionario(String nome, String novoNome, double novoSalario) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                f.setNome(novoNome);
                f.setSalario(novoSalario);
                salvarEmArquivo();
                return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }

    public void excluirFuncionario(String nome) {
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
        salvarEmArquivo();
    }

    private void salvarEmArquivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("funcionarios.txt"))) {
            for (Funcionario f : funcionarios) {
                writer.println(f.getClass().getSimpleName() + ";" + f.getNome() + ";" + f.getSalario());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar em arquivo: " + e.getMessage());
        }
    }

    public void carregarDeArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("funcionarios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                String tipo = partes[0];
                String nome = partes[1];
                double salario = Double.parseDouble(partes[2]);

                Funcionario f = switch (tipo) {
                    case "Desenvolvedor" -> new Desenvolvedor(nome, salario);
                    case "Gerente" -> new Gerente(nome, salario);
                    case "Treinador" -> new Treinador(nome, salario);
                    default -> null;
                };
                if (f != null) funcionarios.add(f);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar de arquivo: " + e.getMessage());
        }
    }
}

