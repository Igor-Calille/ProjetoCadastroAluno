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


public class RemoverGrafico extends JFrame implements ActionListener
{
    JLabel res;
    JButton OK;
    JButton CANCELAR;
    JTextField tra;
    
    String ra;

    /**
     * Construtor para objetos da classe RemoverGrafico
     */
    public RemoverGrafico()
    {
        super ("Alunos");
        setSize(300, 500);
        setLocation(200, 100);
        
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2,2));
        
        cp.add(new JLabel("Forneça o ra:", JLabel.CENTER));
        // Adiciona caixa de texto
        tra = new JTextField();
        tra.setToolTipText("ra");
        cp.add(tra);
        
        // Adiciona botao
        cp.add(OK = new JButton("ok"));
        OK.addActionListener(this);
        OK.setToolTipText("ok");

        // Adiciona botao
        cp.add(CANCELAR = new JButton("cancelar"));
        CANCELAR.addActionListener(e -> System.exit(1));
        CANCELAR.setToolTipText("cancelar");
    }
    
    public String getRaRemover(){

        return ra;
    }

    /**
     * Método actionPerformed
     *
     * @param ae Um parâmetro
     */
    public void actionPerformed(ActionEvent ae) {
        try{
            ra = tra.getText();
            dispose();
        }catch(Exception e){
            res.setText("Valor invalido!");

        }
    }
}
