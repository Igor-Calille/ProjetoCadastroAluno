package Armazenamento;
import java.io.*;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.io.*;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

import Model.Aluno;
import View.ListarGrafico;

/**
 * Escreva uma descrição da classe ArquivoBinario aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ArquivoBinario
{
    int Q;
    public ArquivoBinario( int Q){
        this.Q = Q;
    }
    /**
     * Method gravarObj grava um objeto em arquivo
     *
     * @param objeto objeto a ser gravado
     * @param nomeArq nome do arquivo
     */
    public void gravarObjeto(Object objeto){
        ObjectOutputStream output = null;
        File file = null;
        String nomeArq = null;
        String sn = "S";

        do {
            nomeArq = JOptionPane.showInputDialog("Arquivo: ");
            file = new File(nomeArq);
            if (file.exists()) {
                sn = JOptionPane.showInputDialog("Arquivo: " + nomeArq + " ja existe, pode sobrescreve-lo?(s/n): ");
            }

        } while(sn.toUpperCase().charAt(0) == 'N');

        try {
            //file = new File(nomeArq);
            output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(objeto);  // escreve o objeto no arquivo
        } catch(Exception e){
            System.out.println(e.toString());
        } finally {
            try {
                output.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
    }

    /**
     * Method lerObj
     *
     * @param nomeArq nome do arquivo a ser lido
     * @return Object o objeto lido
     */
    public void lerObjeto(){
        Object objeto = null;
        ObjectInputStream input = null;

        File file = null;
        String nomeArq = null;
        boolean repetir = false;

        // Faz leitura do nome do arquivo
        do {
            repetir = false;
            nomeArq = JOptionPane.showInputDialog("Arquivo: ");
            file = new File(nomeArq);
            if (!file.exists()) { // Verifica se o qruivo existe
                String sn = JOptionPane.showInputDialog("Arquivo:" + nomeArq + " inexistente, deseja tentar de novo?(s/n): ");
                if (sn.toUpperCase().charAt(0) == 'S') {
                    repetir = true;
                } else {
                    System.exit(0);
                }
            }
        } while(repetir);

        try {
            //file = new File(nomeArq);
            input = new ObjectInputStream(new FileInputStream(file));
            objeto = (Object)input.readObject();  // le o objeto do arquivo
        }
        catch(Exception e){
            System.out.println(e.toString());
        } finally {
            try {
                input.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
        

        Aluno[] vetor = new Aluno[Q];
        vetor = (Aluno[])objeto;

        for(int j = 0; j<Q; j++){
            System.out.println("    Aluno " + (j+1));
            System.out.println("    Nome: " + vetor[j].getNome());
            System.out.println("    Idade: " + vetor[j].getIdade());
            System.out.println("    ra: " + vetor[j].getRa());
            System.out.println("    curso: " + vetor[j].getCurso());
            System.out.println("    nota: " + vetor[j].getNota() + "\n");

        }
    }
}
