package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.lang.Thread;
import java.io.*; 
import java.util.*;
import java.lang.Object;



public class MenuGrafico extends JFrame implements ActionListener
{
    JButton inserir;
    JButton remover;
    JButton listar;
    JButton gravar;
    JButton ler;
    JButton sair;
    JLabel res;
    
    String veri = "0";
    Container cp = getContentPane();
    
    public MenuGrafico(){
        
        super ("Menu");
        setSize(300, 500);
        setLocation(200, 100);

    
        
        cp.setLayout(new GridLayout(6,1));
        
        
        cp.add(inserir = new JButton("inserir"));
        inserir.addActionListener(this);
        inserir.setToolTipText("inserir");
        
        cp.add(remover = new JButton("remover"));
        remover.addActionListener(this);
        remover.setToolTipText("remover");
        
        cp.add(listar = new JButton("listar"));
        listar.addActionListener(this);
        listar.setToolTipText("listar");
        
        cp.add(gravar = new JButton("gravar"));
        gravar.addActionListener(this);
        gravar.setToolTipText("gravar");
        
        cp.add(ler = new JButton("ler"));
        ler.addActionListener(this);
        ler.setToolTipText("ler");
        
        cp.add(sair = new JButton("sair"));
        sair.addActionListener(this);
        sair.setToolTipText("sair");
        
    }
    
    public String SelecOp(){

        return veri;
    }
    
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == inserir){
                veri = "1";
                dispose();
            }
            else if(e.getSource() == remover){
                veri = "2";
                dispose();
            }
            else if(e.getSource() == listar){
                veri = "3";
                dispose();
            }
            else if(e.getSource() == gravar){
                veri = "4";
                dispose();
            }
            else if(e.getSource() == ler){
                veri = "5";
                dispose();
            }
            else if(e.getSource() == sair){
                veri = "6";
                dispose();
            }

            

        }catch(Exception ae){
            res.setText("Valor invalido!");

        }
    }
    
    public void RemoverGrafico(int Q){
        
        
    }
    
    
}
