package model;

public class GerenteDesenvolvedor extends Funcionario implements Desenvolve, Gerencia {
    public GerenteDesenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void codar() {
        System.out.println(getNome() + " está codando.");
    }

    @Override
    public void resolverProblemas() {
        System.out.println(getNome() + " está resolvendo problemas técnicos.");
    }

    @Override
    public void organizarEquipe() {
        System.out.println(getNome() + " está organizando a equipe.");
    }

    @Override
    public void conduzirReunioes() {
        System.out.println(getNome() + " está conduzindo reuniões.");
    }

    @Override
    public String mostrarDetalhes() {
        return "Gerente Desenvolvedor: Nome = " + getNome() + ", Salário = " + getSalario();
    }
}
