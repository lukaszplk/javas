package threads;

import javax.swing.JButton;
import javax.swing.JCheckBox;


public class AutozapisThread extends Thread{
    private JButton przycisk;
    private JCheckBox checkBox;

    public JButton getPrzycisk() {
        return przycisk;
    }

    public void setPrzycisk(JButton przycisk) {
        this.przycisk = przycisk;
    }

    public AutozapisThread(JButton przycisk, JCheckBox checkBox) {
        this.przycisk = przycisk;
        this.checkBox = checkBox;
    }
    
    
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(9000);
                if(checkBox.isSelected()){
                    
                    getPrzycisk().doClick();
                    getPrzycisk().setEnabled(false);
                    Thread.sleep(1000); 
                }
                
                
                     
            }
            catch(Exception ex){
                System.out.println("Watek sie zatrzymal");
                break;
            }
            finally{
                getPrzycisk().setEnabled(true);
            }
        }
    }
}
