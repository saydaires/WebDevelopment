class Pessoa {
    private int id;
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public Pessoa setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public int getIdade() {
        return idade;
    }

    public Pessoa setIdade(int idade) {
        this.idade = idade;
        return this;
    }
}

class PessoaFactory {
    private int contadorPessoas = 0;
    public Pessoa criarPessoa(String nome, int idade) {
            return new Pessoa(nome, idade).setId(contadorPessoas++);
    }
}

import java.util.Scanner
public class FactoryExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFactory factory = new PessoaFactory();

        while(true) {
            System.out.print("Nome da Pessoa: ");
            String nome = scanner.nextLine();
            System.out.print("\nIdade da Pessoa: ");
            int idade = scanner.nextInt();

            if(scanner.hasNextLine())
                scanner.nextLine();

            Pessoa pessoa = factory.criarPessoa(nome, idade);

            System.out.println("ID: " + pessoa.getId() + "\n" +
                    "NOME: " + pessoa.getNome() + "\n" +
                    "IDADE: " + pessoa.getIdade());
            System.out.println();
        }
    }
}
