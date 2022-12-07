import java.awt.EventQueue;
import javax.swing.JFrame;

public class Programme extends JFrame {

    public Programme() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Aquarium());
               
        setResizable(false);
        pack();
        
        setTitle("Programme");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new Programme();
            ex.setVisible(true);
        });
    }
}
