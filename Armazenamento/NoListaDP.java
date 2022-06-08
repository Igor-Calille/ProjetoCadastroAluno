package Armazenamento;
import Model.Aluno;
public class NoListaDP{
    // Atributos
    Aluno conteudo; // conteudo
    NoListaDP proximo; // proximo
    NoListaDP anterior;

    /**
     * Constroi um no da lista ligada
     * @param Object conteudo do no
     */
    public NoListaDP(Aluno conteudo){
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
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
    public void setProximo(NoListaDP proximo){
        this.proximo = proximo;
    }
    
    public void setAnterior(NoListaDP proximo){
        this.anterior = anterior;
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
    public NoListaDP getProximo(){
        return(this.proximo);
    }
    
    public NoListaDP getAnterior(){
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
