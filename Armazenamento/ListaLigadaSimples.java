package Armazenamento;

import javax.swing.JFrame;

import Model.Aluno;
import View.ListarGrafico;
public class ListaLigadaSimples {
    // Atributos
    No inicio,aux, ant, fim;  

    int qtdNos; // Quantidade de nos
    
    Aluno vetor[];

    /**
     * ListaLigadaSimples Construtor
     *
     * Inicia uma lista ligada simples. Inicia ponteiros e contador de nos.
     * 
     */
    public ListaLigadaSimples(){
        setInicio(null);
        setFim(null);
        setQtdNos(0);
    }

    /**
     * Método setInicio
     *
     * @param inicio no inicial
     */
    private void setInicio(No inicio){
        this.inicio = inicio;
    }

    /**
     * Método getInicio
     *
     * @return No no inicial
     */
    public No getInicio(){
        return(this.inicio);
    }

    /**
     * Método getFim
     *
     * @return No no final
     */
    public No getFim(){
        return(this.fim);
    }

    /**
     * Método setFim
     *
     * @param fim no final
     */
    private void setFim(No fim){
        this.fim = fim;
    }

    /**
     * Método getQtdNos
     *
     * @return qtidade de nos
     */
    public int getQtdNos(){
        return this.qtdNos;
    }

    /**
     * Método setQtdNos
     *
     * @param qtdNos atualiza qtde de nos
     */
    private void setQtdNos(int qtdNos){
        this.qtdNos = qtdNos;
    }

    /**
     * Método estaVazia
     *
     * @return true - lista vazia, false - lista nao vazia
     */
    public boolean estaVazia(){
        boolean ret = false; 
        if (getQtdNos() == 0 && getInicio() == null && getFim() == null){
            ret = true;
        }
        return ret;
    }

    /**
     * Método inserirInicio
     *
     * @param elem Objeto a ser inserido na lista
     */
    public void inserirInicio(Aluno elem) {
        No novo = new No(elem); // Cria um no com o objeto a ser inserido

        if (estaVazia()){ // Se a lista estiver vazia
            setInicio(novo);
            setFim(novo);
        } else{ // A lista não esta vazia
            novo.setProximo(inicio);
            setInicio(novo);
        }

        // Incrementa quantidade de nos
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * Metodo removerRa
     * @ metodo criado para percorrer a lista ligada e remover o ra em questao
     */
    public void removerRa(String ra){
        boolean test = false;

        aux = getInicio();
        while(aux != null || test == true){
            Aluno A = aux.getConteudo();
            if(A.getRa().equals(ra)){
                test = true; // achou o ra nos cadastrados
                ant.setProximo(aux.getProximo());
            }
            ant = aux;
            aux = aux.getProximo();

        }

    }

    /**
     * metodo listarLL
     * @metodo utilizado para percorrer toda lista ligada e printar seu conteudo
     */
    public void listarLL(){
        boolean test = false;

        aux = getInicio();
        while(aux != null){
            Aluno A = aux.getConteudo();
            ListarGrafico lg = new ListarGrafico(A);
            lg.setVisible(true);
            lg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            do{
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }

            }while(lg.isVisible()== true);
            aux = aux.getProximo();
        }
        

    }
    
    /**
     * metodo gravarLL
     * @Gravar a lista ligada em txt
     */
    public void gravarLL(){
        vetor = new Aluno[getQtdNos()];
        int i = 0;
        aux = getInicio();
        while(aux != null){
            Aluno A = aux.getConteudo();
            vetor[i] = A;
            i++;
            
            aux = aux.getProximo();
        }
        ArquivoTexto gv = new ArquivoTexto(vetor, getQtdNos(), getQtdNos());
        gv.gravarObjeto();
    }
    
    /**
     * metodo lerLL
     * @ler o conteudo gravado no arquivo txt
     */
    public void lerLL(){
        ArquivoTexto lr = new ArquivoTexto(vetor, getQtdNos(), getQtdNos());
        lr.lerObjeto();
    }

    /**
     * Método inserirFim
     *
     * @param elem Objeto a ser inserido na lista
     */

    public void inserirFim(Aluno elem){
        No novo = new No(elem);// Cria um no com o objeto a ser inserido

        // Se a lista estiver vazia
        if (estaVazia()){
            setInicio(novo);
            setFim(novo);
        } else{ // Alista nao esta vazia
            getFim().setProximo(novo);
            setFim(novo);
        }

        // Incrementa quantidade de nos
        setQtdNos(getQtdNos() + 1);
    }

    
    
    
    
    
    
    
    
    
    
    /**
     * Método removerInicio
     *
     * @return Object objeto a ser removido
     */

    public Object removerInicio(){
        No aux = null;
        Object obj = null; 

        if(!estaVazia()){ 
            if ((getInicio() == getFim())){ // Se existir apenas um no
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else { // Existe mais de um no
                aux = getInicio();
                setInicio(aux.getProximo());
                aux.setProximo(null);
            }

            // Decrementa qtidade de nos
            setQtdNos(getQtdNos() - 1);
            obj = aux.getConteudo(); // pega conteudo do no removido
        }

        return(obj); // retorna o conteudo removido
    }

    /**
     * Método removerFim
     *
     * @return Object objeto a ser removido
     */

    public Object removerFim(){
        No ant = getInicio();
        No aux = null;
        Object obj = null; 

        if (!estaVazia()){
            if ((getInicio() == getFim())){ // Se existir apenas um no
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else { // Existe mais de um no           
                // percorre ate achar o no antes do fim
                while(ant.getProximo() != fim){
                    ant = ant.getProximo();
                }
                ant.setProximo(null); // desliga o no a ser removido
                aux = fim; // guarda no a ser removido
                setFim(ant); // atualiza ponteiro fim
            }

            // Decrementa qtidade de nos
            setQtdNos(getQtdNos() - 1);
            obj = aux.getConteudo(); // pega conteudo do no removido          
        }
        return obj;
    }

    /**
     * Método toString
     *
     * @return String todos os nos da lista
     */
    public String toString(){
        No temp = getInicio();
        String valores = "[ ";
        if (!estaVazia() ){
            while (temp != null){ // percorre toda a lista
                valores += temp.getConteudo() + " ";
                temp = temp.getProximo();
            }
        }
        valores = valores + "]";
        return valores;
    }

}
