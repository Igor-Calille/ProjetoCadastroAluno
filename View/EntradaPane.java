package View;
import java.util.Scanner;
import javax.swing.JOptionPane;

import Model.Aluno;

/**
 * Escreva uma descrição da classe EntradaConsole aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class EntradaPane implements IEntrada
{
    //Cadastro cad = new Cadastro(5);
    Scanner scan = new Scanner( System.in );

    public String nome;
    String n;
    float nota;
    String curso;
    String ra;
    String id;
    public int Q;
    public int x;
    int idade;
    char carac;
    boolean test;

    public EntradaPane(int Q){
        this.Q = Q;
    }

    public String lerNome(){ 
        do{
            test = true;
            try{

                nome = JOptionPane.showInputDialog("Aluno " + (Q+1)  + " Forneca o nome: " );

                for(int i = 0; i< nome.length();i++){
                    carac = nome.charAt(i);
                    if(carac == '0' || carac == '1' || carac == '2' || carac == '3' || carac == '4' || carac == '5' || carac == '6' || carac == '7' || carac == '8' || carac == '9'){
                        test = false;
                    }
                }
                if(test == false){
                    JOptionPane.showMessageDialog(null, "Utilize apenas letras");
                }

            }catch(Exception e){
                if( nome == null){
                    JOptionPane.showMessageDialog(null, "Cancelado");
                    //cad.mostrarMenu();

                }
                else if(nome.equals("")){
                    JOptionPane.showMessageDialog(null, "Falta de informacao");
                    System.out.println("teste");
                    test = false;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro desconhecido");
                    test = false;
                }
            }
        }while(test == false);
        return nome;
    }

    public int lerIdade(){ 
        do{
            test = true;
            try{
                do{
                    id = JOptionPane.showInputDialog("Aluno " + (Q+1) + " Forneça a idade: ");
                    idade = Integer.parseInt(id);
                    if(idade<0 || idade>200){
                        System.out.println("A idade deve estar entre 0 e 200");
                    }
                }while(idade<0 || idade>200);
            }catch(Exception e){
                if( id == null){
                    JOptionPane.showMessageDialog(null, "Cancelado");
                    //cad.mostrarMenu();

                }
                else if(id.equals("")){
                    JOptionPane.showMessageDialog(null, "Falta de informacao");
                    test = false;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Digite apenas numeros");
                    test = false;
                }
            }
        }while(test == false);
        return idade;
    }

    public String lerRa(){ 
        do{
            test = true;
            try{
                ra = JOptionPane.showInputDialog("Aluno " + (Q+1) + " Forneça o ra: ");
            }catch(Exception e){
                if( ra == null){
                    JOptionPane.showMessageDialog(null, "Cancelado");
                    //cad.mostrarMenu();
                }
                else if(ra.equals("")){
                    JOptionPane.showMessageDialog(null, "Falta de informacao");
                    test = false;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Digite apenas numeros");
                    test = false;
                }
            }
        }while(test == false);
        return ra;
    }
    
    public String lerCurso(){ 
        do{
            test = true;
            try{

                curso = JOptionPane.showInputDialog("Aluno " + (Q+1) + " Forneça o curso: ");

                for(int i = 0; i< curso.length();i++){
                    carac = curso.charAt(i);
                    if(carac == '0' || carac == '1' || carac == '2' || carac == '3' || carac == '4' || carac == '5' || carac == '6' || carac == '7' || carac == '8' || carac == '9'){
                        test = false;
                    }
                }
                if(test == false){
                    JOptionPane.showMessageDialog(null, "Utilize apenas letras");
                }

            }catch(Exception e){
                if( curso == null){
                    JOptionPane.showMessageDialog(null, "Cancelado");
                    //cad.mostrarMenu();

                }
                else if(curso.equals("")){
                    JOptionPane.showMessageDialog(null, "Falta de informacao");
                    test = false;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro desconhecido");
                    test = false;
                }
            }
        }while(test == false);
        return curso;
    }
    
    public float lerNota(){ 
        do{
            test = true;
            try{
                do{
                    n = JOptionPane.showInputDialog("Aluno " + (Q+1) + " Forneça a ultima nota: ");
                    nota = Float.parseFloat(n);
                    if(nota<=0.0 || nota>=10.0){
                        JOptionPane.showMessageDialog(null, "A nota deve estar entre 0 e 10");
                    }
                }while(nota<0.0 || nota>10.0);
            }catch(Exception e){
                if( id == null){
                    JOptionPane.showMessageDialog(null, "Cancelado");
                    //cad.mostrarMenu();

                }
                else if(id.equals("")){
                    JOptionPane.showMessageDialog(null, "Falta de informacao");
                    test = false;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Digite apenas numeros");
                    test = false;
                }
            }
        }while(test == false);
        return nota;
    }

    public Aluno criarAluno(){
        // le os dados do aluno
        String nome = lerNome();
        int idade = lerIdade();
        String ra = lerRa();
        String curso = lerCurso();
        float nota = lerNota();

        Aluno a = new Aluno(nome, idade, ra, nota, curso);
        return a;
    }
}