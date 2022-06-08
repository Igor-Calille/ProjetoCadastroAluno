import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.JFrame;

import View.RemoverGrafico;
import View.ListarGrafico;
import View.MenuGrafico;

import Model.Aluno;
import Armazenamento.Armazenador;
import View.EntradaGrafica;
import View.RemoverGrafico;
import View.EntradaPane;
import View.EntradaConsole;

public class Cadastro {

    public int Q=0; //quantidade de alunos
    public String op;
    public String nome;
    String id;
    int idade;
    String remove;
    String opMenu;

    int g; //indice que verifica se o ra foi encontrado no metodo remover()

    int Entrada;

    Scanner scan = new Scanner( System.in );

    Armazenador arm = new Armazenador();

    
    //Escolha de interface grafica
    EntradaGrafica entrada = new EntradaGrafica(Q); //Opcoes: EntradaPane , EntradaConsole e EntradaGrafica IMPORTE: TROQUE A VARIAVEL opPrint abaixo tambem
    //EntradaPane entrada = new EntradaPane(Q);
    //EntradaConsole entrada = new EntradaConsole(Q);
    
    int opPrint = 2; // 0 = EntradaConsole ou 1 = EntradaPane  ou   2 = EntradaGrafica(swing)

    public Cadastro(){
  
    }

    /**
     * Método inserir
     *@Cadastra um aluno
     */
    public void inserir(){
        boolean test = false;
            if(opPrint == 2){

                do{
                    try{
                        EntradaGrafica entrada = new EntradaGrafica(Q);
                        entrada.setVisible(true);
                        entrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                        do{
                            try
                            {
                                Thread.sleep(1000);
                            }
                            catch (InterruptedException ie)
                            {
                                ie.printStackTrace();
                            }

                        }while(entrada.isVisible()== true);

                        Aluno a = entrada.criarAluno(); 
                        
                        arm.inserirG(a);
                        Q++;
                        

                        test = true;
                    }catch(NumberFormatException e){
                        test = false;
                    }
                }while(test != true);

            }else{
                Aluno a = entrada.criarAluno(); 

                arm.inserirG(a);
                Q++;
            }  
    }

    /**
     * Método remover
     *@remove o aluno com o ra citado
     */
    public void remover(){
        if (opPrint == 1){
            remove = JOptionPane.showInputDialog("Forneça o ra que deseje remover: "); 
        }else if(opPrint == 0){
            System.out.println("Forneça o ra que deseje remover: ");
            remove = scan.next() + scan.nextLine();
        }
        else{
            RemoverGrafico rg = new RemoverGrafico();
            rg.setVisible(true);
            rg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            do{
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }

            }while(rg.isVisible()== true);
            remove = rg.getRaRemover();
        }
        arm.removerG(remove);
        Q--;
    }

    public void listar(){
        arm.listarG();
    }

    
    public void gravar(){
        arm.gravarG();
    }

    public void ler(){
        arm.lerG();
    }
    
    
    /**
     * Método mostrarMenu
     *@Menu inicial com as opcoes de inserir aluno, remover aluno, listar alunos, gravar alunos cadastrados em arquivo txt e ler conteudo do arquivo txt 
     */
    public void mostrarMenu(){
        do{
            if (opPrint == 1){
                opMenu = JOptionPane.showInputDialog("Selecione a opcao: \n1-Cadastrar aluno (Alunos cadastrados: " + (Q) + ")\n2-Remover aluno \n3-Listar alunos \n4-Sair"); 
            }else if(opPrint == 0){
                System.out.println("Selecione a opcao: \n1-Cadastrar aluno (Alunos cadastrados: " + (Q) + ")\n2-Remover aluno \n3-Listar alunos \n4-Sair"); 
                opMenu = scan.next() + scan.nextLine();
            }
            else{
                MenuGrafico mg = new MenuGrafico();
                mg.setVisible(true);
                mg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                do{
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }

                }while(mg.isVisible()== true);

                opMenu = mg.SelecOp(); 
            }

            try{
                switch(opMenu){
                    case "1":
                        inserir();
                        break;
                    case "2" :
                        remover();
                        break;
                    case "3" : 
                        listar();
                        break;
                    case "4" : 
                        gravar();
                        break;
                    case "5" : 
                        ler();
                        break;
                    case "6":
                        System.exit(1);
                        break;

                }
            }catch(Exception e){
                if( opMenu == null){
                    System.out.println("Cancelado");
                    System.exit(1);
                    break;
                }
                else if(opMenu.equals("")){
                    System.out.println("Falta de informacao");
                }
                /*else{
                System.out.println("teste1");
                System.out.println("Outra excecao!");
                }*/
            };

        }while(op != "4");
    }
}