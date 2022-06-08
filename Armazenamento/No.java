package Armazenamento;
import Model.Aluno;
public class No{
    // Atributos
    Aluno conteudo; // conteudo
    No proximo; // proximo

    /**
     * Constroi um no da lista ligada
     * @param Object conteudo do no
     */
    public No(Aluno conteudo){
        setConteudo(conteudo);
        setProximo(null);
    }
    // setters e getters
    /**
     * Método setConteudo
     *
     * @param conteudo conteudo do no
     */
    public void setConteudo(Aluno conteudo){
        this.conteudo = conteudo;
    }
    
    /**
     * Método setProximo
     *
     * @param proximo referencia para o proximo no
     */
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    /**
     * Método getConteudo
     *
     * @return Object conteudo do no
     */
    public Aluno getConteudo(){
        return(this.conteudo);
    }
    
    /**
     * Método getProximo
     *
     * @return NO referencia do proximo no
     */
    public No getProximo(){
        return(this.proximo);
    }
    /**
     * Método toString
     *
     * @return String conteudo do no como string
     */
    public String toString(){
        return(getConteudo().toString());
    }
}