package View;
import Model.Aluno;
public interface IEntrada {
    public String lerNome(); 
    public int lerIdade(); 
    public String lerRa();
    public String lerCurso();
    public float lerNota(); 
    public Aluno criarAluno();
}