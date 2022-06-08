package Armazenamento;
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

public class ArquivoTexto implements IResistencia
{
    Aluno vetor[];
    Aluno vetAux;
    int Q;
    
    String nome;
        int i;
        String r;
        String curso;
        float n;
    
    public ArquivoTexto(Aluno[] vet, int Q, int max)
    {
        this.vetor = new Aluno[max];
        this.vetor = vet;
        this.Q = Q;
    }
    
    /**
     * Método lerObjeto
     *@Le um arquivo no formato txt criado pelo programa
     */
    public void lerObjeto(){
        File file = null;
        String arquivo = null;
        boolean repetir = false;

        // Faz leitura do nome do arquivo
        do {
            repetir = false;
            arquivo = JOptionPane.showInputDialog("Arquivo: ");
            file = new File(arquivo);
            if (!file.exists()) { // Verifica se o qruivo existe
                String sn = JOptionPane.showInputDialog("Arquivo:" + arquivo + " inexistente, deseja tentar de novo?(s/n): ");
                if (sn.toUpperCase().charAt(0) == 'S') {
                    repetir = true;
                } else {
                    System.exit(0);
                }
            }
        } while(repetir);

        // Classes para leitura de dados
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch(FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar abrir o arquivo: " + arquivo);
            ex.printStackTrace();
            return;
        }

        // Leitura de dados
        
        try {
            
            
            String line = br.readLine();
            while(line != null) { // Enquanto existir linha no arquivo
                String separadores = "\n"+ "|"; //"\t\n\r\f"+ "|";
                StringTokenizer st = new StringTokenizer(line, separadores);

                // nome
                if (st.hasMoreTokens()) {
                    nome = st.nextToken();
                    
                } else {
                    throw new DadosIncorretosException();
                }
                
                
                //idade
                if (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    i = Integer.parseInt(tok);
                } else {
                    throw new DadosIncorretosException();
                }
                

                // ra    
                if (st.hasMoreTokens()) {
                    r = st.nextToken();
                } else {
                    throw new DadosIncorretosException();
                }
                
                
                // curso   
                if (st.hasMoreTokens()) {
                    curso = st.nextToken();
                } else {
                    throw new DadosIncorretosException();
                }
                

                // nota
                if (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    n = Float.parseFloat(tok);
                } else {
                    throw new DadosIncorretosException();
                }

                line = br.readLine(); // Le a proxima linha
                
                vetAux = new Aluno(nome,i,r,n,curso);
                
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

        } catch(DadosIncorretosException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return;
        } catch(EOFException ex) {
            System.out.println("Atingiu prematuramente o final do arquivo: " + arquivo);
            return;
        } catch(IOException ex) {
            System.out.println("Nao conseguiu ler do arquivo: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar ler o arquivo: " + arquivo);
            ex.printStackTrace();
            return;
        } finally {
            try {
                br.close();
            } catch(Exception ex) {
                // Nao faz nada !
            }
            try {
                fr.close();
            } catch(Exception ex) {
                // Nao faz nada !
            }
        }
    }
    
    /**
     * Método gravarObjeto
     *@grava os alunos cadastrados durante a execucao do programa no formato txt
     */
    public void gravarObjeto(){
        File file = null;
        String arquivo = null;
        String sn = "S";

        do {
            arquivo = JOptionPane.showInputDialog("Arquivo: ");
            file = new File(arquivo);
            if (file.exists()) {
                sn = JOptionPane.showInputDialog("Arquivo: " + arquivo + " ja existe, pode sobrescreve-lo?(s/n): ");
            }

        } while(sn.toUpperCase().charAt(0) == 'N');

        char separador = '|'; // caractere que sera utilizado para separar os dados

        // Classes de gravacao de dados
        PrintWriter pw = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
        } catch(IOException ex) {
            System.out.println("Nao conseguiu abrir o arquivo: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar abrir o arquivo: " + arquivo);
            return;
        }

        // Dados a serem gravados
        String nome;
        int i;
        String r;
        String c;
        double nota;

        // Gravacao dos dado no arquivo
        try {
            for (int j = 0; j < Q; j++) { //para gravar algumas linhas
                nome = vetor[j].getNome();
                pw.print(nome);
                pw.print(separador);

                i = vetor[j].getIdade();
                pw.print(i);
                pw.print(separador);
                
                r = vetor[j].getRa();
                pw.print(r);
                pw.print(separador);
                
                c = vetor[j].getCurso();
                pw.print(c);
                pw.print(separador);

                nota = vetor[j].getNota();
                pw.print(nota);
                pw.println(separador); // muda de linha
            }
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar escrever no arquivo: " + arquivo);
            return;
        } finally {
            try {
                pw.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
            try {
                fos.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
        
    }
    

}
