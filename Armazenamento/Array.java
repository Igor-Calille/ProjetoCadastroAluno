package Armazenamento;
import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.JFrame;

import java.lang.Thread;
import java.io.*; 
import java.util.*;
import java.lang.Object;

import Model.Aluno;
import View.ListarGrafico;
import View.EntradaGrafica;

public class Array implements IArmazenador
{
    public int Max = 5; //maximo de alunos
    Aluno vetor[];
    public int Q=0; //quantidade de alunos
    public String op;
    public String nome;
    String id;
    int idade;
    String remove;
    String opMenu;
    
    
    Scanner scan = new Scanner( System.in );
    
    EntradaGrafica entrada = new EntradaGrafica(Q); //Opcoes: EntradaPane , EntradaConsole e EntradaGrafica IMPORTE: TROQUE A VARIAVEL opPrint abaixo tambem
    int opPrint = 2; // 0 = EntradaConsole ou 1 = EntradaPane  ou   2 = EntradaGrafica(swing)
    

    /**
     * Construtor para objetos da classe Array
     */
    public Array()
    {
        vetor = new Aluno[Max];
    }

    public void inserir(Aluno A){
        if(Q<=Max){
            vetor[Q] = A;
            Q++;
        }
    }
    
    
    /**
     * Método remover
     *
     * @remover o aluno com o ra selecionado do vetor
     */
    public void remover(String remove){
        int g=0; //indice que verifica se o ra foi encontrado no metodo remover()
        for(int j = 0; j<Q; j++){

            if(vetor[j].getRa().equals(remove)){
                vetor[j] = null;
                for(int x = j; x<Q-1; x++){
                    vetor[x] = vetor[x+1];
                }//reordena os alunos na matriz
                Q--;
                g = 1;//existe o ra
                if (opPrint == 1){
                    JOptionPane.showMessageDialog(null, "Aluno removido"); 
                }else if(opPrint == 0){
                    System.out.println("Aluno removido");
                }else{}
            }
        }
        if(g == 0){
            System.out.println("O aluno nao existe");
        }
        
    }
    
    /**
     * Método listar
     *@percorrer o vetor e lista-lo
     */
    public void listar(){
        for(int j = 0; j<Q; j++){
            // Mostra os dados

            if (opPrint == 1){
                JOptionPane.showMessageDialog(null, "Aluno" + (j+1) + "\n Nome: " + vetor[j].getNome() + "\n Idade: " + vetor[j].getIdade() + "\n ra: " + vetor[j].getRa() + "\n curso: " + vetor[j].getCurso() + "\n nota: " + vetor[j].getNota());
            }else if(opPrint == 0){
                System.out.println("    Aluno " + (j+1));
                System.out.println("    Nome: " + vetor[j].getNome());
                System.out.println("    Idade: " + vetor[j].getIdade());
                System.out.println("    ra: " + vetor[j].getRa());
                System.out.println("    curso: " + vetor[j].getCurso());
                System.out.println("    nota: " + vetor[j].getNota() + "\n");
            }else{

                Aluno vetAux;
                vetAux = vetor[j];

                ListarGrafico lg = new ListarGrafico(vetAux);
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
            }

        }
    }
    
    /**
     * Método gravar
     *@gravar o contudo do arquivo em txt
     */
    public void gravar(){
        //ArquivoTexto gv = new ArquivoTexto(vetor, Q, Max);
        //gv.gravarObjeto();
        ArquivoBinario gv = new ArquivoBinario(Q);
        gv.gravarObjeto(vetor);
    }
    
    /**
     * Método ler
     *@ler o arquivo txt salvo no programa
     */
    public void ler(){
        //ArquivoTexto lr = new ArquivoTexto(vetor, Q, Max);
        //lr.lerObjeto();
        ArquivoBinario lr = new ArquivoBinario(Q);
        lr.lerObjeto();
    }
    
    public Aluno[] getVetAluno(){
        
        return vetor;
    }
    
}
