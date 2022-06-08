package Armazenamento;
import Model.Aluno;
/**
 * Escreva a descrição da interface IArmazenador aqui.
 * 
 * @author (seu nome aqui) 
 * @version (um número da versão ou data aqui)
 */

public interface IArmazenador
{
    public void inserir(Aluno A);
    
    public void remover(String ra);
    
    public void listar();
    
    public void gravar();
    
    public void ler();
}
