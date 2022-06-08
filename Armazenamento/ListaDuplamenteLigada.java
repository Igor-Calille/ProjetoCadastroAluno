package Armazenamento;
import Model.Aluno;
import View.ListarGrafico;
import javax.swing.JFrame;
public class ListaDuplamenteLigada {
    // Atributos
    NoListaDP inicio,aux, ant,prox, fim;  

    int qtdNos; // Quantidade de nos
    
    Aluno vetor[];

    /**
     * ListaLigadaSimples Construtor
     *
     * Inicia uma lista ligada simples. Inicia ponteiros e contador de nos.
     * 
     */
    public ListaDuplamenteLigada(){
        setInicio(null);
        setFim(null);
        setQtdNos(0);
    }

    /**
     * Método setInicio
     *
     * @param inicio no inicial
     */
    private void setInicio(NoListaDP inicio){
        this.inicio = inicio;
    }

    /**
     * Método getInicio
     *
     * @return No no inicial
     */
    public NoListaDP getInicio(){
        return(this.inicio);
    }

    /**
     * Método getFim
     *
     * @return No no final
     */
    public NoListaDP getFim(){
        return(this.fim);
    }

    /**
     * Método setFim
     *
     * @param fim no final
     */
    private void setFim(NoListaDP fim){
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
        NoListaDP novo = new NoListaDP(elem); // Cria um no com o objeto a ser inserido
        novo.setAnterior(null);

        if (estaVazia()){ // Se a lista estiver vazia
            setInicio(novo);
            setFim(novo);
            novo.setProximo(getInicio());
        } else{ // A lista não esta vazia
            novo.setProximo(getInicio());
            getInicio().setAnterior(novo);
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
                ant = aux.getAnterior();
                prox = aux.getProximo();
                ant.setProximo(prox);
                prox.setAnterior(ant);
                
            }
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
}