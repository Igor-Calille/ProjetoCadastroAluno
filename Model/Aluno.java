package Model;
/**
 * Escreva uma descrição da classe Aluno aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Aluno implements java.io.Serializable
{
    public String ra;
    private String curso;
    private float nota;
    public String nome;
    public int idade;
    
    
    public Aluno(String nome, int idade, String ra, float nota, String curso){
        
        setIdade(idade);
        setRa(ra);
        setCurso(curso);
        setNota(nota);
        setNome(nome);
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public int getIdade(){
        return this.idade;
    }
    
    public String getNome() {
        return this.nome;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public String getRa() {
        return this.ra;
    }

   
    public void setRa(String ra) {
        this.ra = ra;
    }


    public String getCurso() {
        return this.curso;
    }

   
    protected void setCurso(String curso) {
        this.curso = curso;
    }


    public float getNota() {
        return this.nota;
    }

   
    protected void setNota(float nota) {
        this.nota = nota;
    }
    
    
}



