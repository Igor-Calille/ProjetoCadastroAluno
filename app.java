
/*
 * Autor: Igor Masson Calille - RA00297594
 * Projeto: Cadastro de alunos
 * data:28/03/22
 */
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

import View.LimpaConsole;
public class app
{
    public static void main(String[] args) {
        // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
        
        LimpaConsole Terminal = new LimpaConsole();
        try{
            Terminal.limpar();
        }catch(IOException e){
            
        }catch(InterruptedException e){
            
        }
        
        Cadastro info = new Cadastro();
        
        
        info.mostrarMenu();


        
    
    }
    
}
