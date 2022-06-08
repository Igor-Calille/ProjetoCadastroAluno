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

public class MensagemGrafico extends JFrame implements ActionListener
{
    JButton OK;
    public MensagemGrafico(String mensagem){
        super ("Mensagem");
        setSize(300, 500);
        setLocation(200, 100);
        
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(1,2));
        
        cp.add(new JLabel(mensagem, JLabel.CENTER));
        
        cp.add(OK = new JButton("ok"));
        OK.addActionListener(this);
        OK.setToolTipText("ok");
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        try{
            dispose();
        }catch(Exception e){

        }
    }

}
