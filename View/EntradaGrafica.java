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

import Model.Aluno;

public class EntradaGrafica extends JFrame implements ActionListener
{
    // Atributos
    JLabel res;
    JButton OK;
    JButton CANCELAR;
    JTextField tnome;
    JTextField tidade;
    JTextField tra;
    JTextField tcurso;
    JTextField tnota;
    
    
    boolean test = false;

    String nome;
    int idade;
    String id;
    String ra;
    String curso;
    String n;
    float nota;

    Aluno a;

    
    // Construtor
    public EntradaGrafica(int Q){
       
            // Criando a janela
            super ("");
            setSize(300, 500);
            setLocation(200, 100);

            //`Pega e Define atributos do container
            Container cp = getContentPane();
            cp.setLayout(new GridLayout(6,2));

            // Adiciona Label nome
            cp.add(new JLabel("Forneca o nome:", JLabel.CENTER));
            // Adiciona caixa de texto
            tnome = new JTextField();
            tnome.setToolTipText("nome");
            cp.add(tnome);

            // Adiciona Label idade
            cp.add(new JLabel("Forneça a idade:", JLabel.CENTER));
            // Adiciona caixa de texto
            tidade = new JTextField();
            tidade.setToolTipText("idade");
            cp.add(tidade);

            // Adiciona Label ra
            cp.add(new JLabel("Forneça o ra:", JLabel.CENTER));
            // Adiciona caixa de texto
            tra = new JTextField();
            tra.setToolTipText("ra");
            cp.add(tra);

            // Adiciona Label curso
            cp.add(new JLabel("Forneça o curso:", JLabel.CENTER));
            // Adiciona caixa de texto
            tcurso = new JTextField();
            tcurso.setToolTipText("curso");
            cp.add(tcurso);

            // Adiciona Label nota
            cp.add(new JLabel("Forneça a ultima nota:", JLabel.CENTER));
            // Adiciona caixa de texto
            tnota = new JTextField();
            tnota.setToolTipText("nota");
            cp.add(tnota);


            // Adiciona botao
            cp.add(OK = new JButton("ok"));
            OK.setBackground(Color.RED);
            OK.setForeground(Color.CYAN);
            OK.addActionListener(this);
            OK.setToolTipText("ok");

            // Adiciona botao
            cp.add(CANCELAR = new JButton("cancelar"));
            CANCELAR.setBackground(Color.RED);
            CANCELAR.setForeground(Color.CYAN);
            CANCELAR.addActionListener(e -> System.exit(1));
            CANCELAR.setToolTipText("cancelar");

            


    }


    public Aluno criarAluno(){

        return a;
    }

    public void actionPerformed(ActionEvent ae) {
        try{
            nome = tnome.getText();
            id = tidade.getText();
            idade = Integer.parseInt(id);
            ra = tra.getText();
            curso = tcurso.getText();
            n = tnota.getText();
            nota = Float.parseFloat(n);

            
            a = new Aluno(nome, idade, ra, nota, curso);

            dispose();
 

            

        }catch(Exception e){
            System.out.println(a);
            res.setText("Valor invalido!");

        }
    }

}
