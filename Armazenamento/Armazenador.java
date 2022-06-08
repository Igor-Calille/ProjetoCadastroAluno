package Armazenamento;
import Model.Aluno;
/**
 * Escreva uma descrição da classe Armazenador aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Armazenador
{
    //ListaLigada list = new ListaLigada(); 
    Array list = new Array();
    
    
    
    public Armazenador()
    {
        
    }

    public void inserirG(Aluno A){
        list.inserir(A);
    }
    
    public void removerG(String ra){
        list.remover(ra);
    }
    
    public void listarG(){
        list.listar();
    }
    
    public void gravarG(){
        list.gravar();
    }
    
    public void lerG(){
        list.ler();
    }
    
}
