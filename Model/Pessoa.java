package Model;
/**
 * Representa uma pessoa.
 * 
 * @author Julio Arakaki
 * @version 0.1 24/03/2022
 */
public class Pessoa implements java.io.Serializable{
    // Atributos
    NomePessoa nome;
    int idade;
    
    // Construtor
    Pessoa (String nome, int idade){
        setNome(nome);
        setIdade(idade);
    }
    // setters e getters
    public void setNome(String nome){
        this.nome = new NomePessoa(nome);
    }
    
    public NomePessoa getNome(){
        return this.nome;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public int getIdade(){
        return this.idade;
    }

    public String getNomeInvertido(){
        return getNome().getNomeInvertido();
    }
    public String getNomeBiblio(){
        return getNome().getNomeBiblio();
    }
    
    public String toString(){
        return "Nome: " + getNome() + "\nIdade: " + getIdade();
    }
    
}
