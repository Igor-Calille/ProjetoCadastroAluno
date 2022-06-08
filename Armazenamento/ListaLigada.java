package Armazenamento;
import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.JFrame;

import java.lang.Thread;
import java.io.*; 
import java.util.*;
import java.lang.Object;

import Model.Aluno;
public class ListaLigada implements IArmazenador
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int x;
    ListaLigadaSimples list = new ListaLigadaSimples();
    /**
     * Construtor para objetos da classe ListaLigada
     */
    public ListaLigada()
    {
        
    }

    public void inserir(Aluno A){
        list.inserirInicio(A);
    }
    
    public void remover(String ra){
        list.removerRa(ra);
    }
    
    public void listar(){
        list.listarLL();
    }
    
    public void gravar(){
        list.gravarLL();
    }
    
    public void ler(){
        list.lerLL();
    }
}
