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

import Model.Aluno;

public class ListarGrafico extends JFrame implements ActionListener
{
    //JTextField tnome;
        JLabel resNome ;
    
        //JTextField tidade;
        JLabel resIdade;
    
        //JTextField tra;
        JLabel resRa;
    
        //JTextField tcurso;
        JLabel resCurso;
    
        //JTextField tnota;
        JLabel resNota;
    
    private JLabel res;
    
    JButton OK;
    JButton CANCELAR;
    
    
    
    /**
     * ListarGrafico Construtor
     *
     * @param vetAux Um parâmetro do Tipo Aluno q sera listado na interface
     */
    public ListarGrafico(Aluno vetAux){
        
        super ("Alunos");
        setSize(300, 500);
        setLocation(200, 100);
        
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(6,2));
        
        String nome = vetAux.getNome();
        int idade = vetAux.getIdade();
        String id=String.valueOf(idade);
        String ra = vetAux.getRa();
        String curso = vetAux.getCurso();
        float nota = vetAux.getNota();
        String n=String.valueOf(nota);
        
        // Adiciona Label nome
        cp.add(new JLabel("nome:", JLabel.CENTER));
        cp.add(new JLabel(nome, JLabel.CENTER));
    

        // Adiciona Label idade
        cp.add(new JLabel("Idade:", JLabel.CENTER));
        cp.add(new JLabel(id, JLabel.CENTER));

        // Adiciona Label ra
        cp.add(new JLabel("Ra:", JLabel.CENTER));
        cp.add(new JLabel(ra, JLabel.CENTER));

        // Adiciona Label curso
        cp.add(new JLabel("Curso:", JLabel.CENTER));
        cp.add(new JLabel(curso, JLabel.CENTER));

        // Adiciona Label nota
        cp.add(new JLabel("Nota:", JLabel.CENTER));
        cp.add(new JLabel(n, JLabel.CENTER));

        // Adiciona botao
        cp.add(OK = new JButton("ok"));
        OK.addActionListener(this);
        OK.setToolTipText("ok");

        // Adiciona botao
        cp.add(CANCELAR = new JButton("cancelar"));
        CANCELAR.addActionListener(e -> System.exit(1));
        CANCELAR.setToolTipText("cancelar");

    }
    
    /**
     * Método actionPerformed
     *
     * @param ae Um parâmetro 
     */
    public void actionPerformed(ActionEvent ae) {
        try{
            dispose();
        }catch(Exception e){
            res.setText("Valor invalido!");

        }
    }
}
