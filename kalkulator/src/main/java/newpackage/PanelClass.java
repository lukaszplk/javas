
package newpackage;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import newpackage.PanelActionListener;

public class PanelClass
{
    private JFrame frame;
    private JPanel mainPanel;
    
    private JLabel slowoAng;
    private JLabel slowoPol;
    private JButton przycisk;
    

    public PanelClass()
    {
        frame = new JFrame("Panel");
        mainPanel = new JPanel();
        
        ustawLayout();
        
        frame.setContentPane(mainPanel);
        frame.setSize(800, 100);
        
        slowoAng = new JLabel();
        slowoPol = new JLabel();
        
        przycisk = new JButton("pokaz");
        dodajElementy();
                
        PanelActionListener listener = new PanelActionListener(slowoAng, slowoPol);
        
        
        przycisk.addActionListener(listener);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    protected void ustawLayout(){
       mainPanel.setLayout(new FlowLayout());
       
    }
   
    protected void dodajElementy(){
        mainPanel.add(slowoAng);
        mainPanel.add(slowoPol);
        mainPanel.add(przycisk);
        
    } 
}