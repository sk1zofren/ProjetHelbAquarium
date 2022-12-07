import java.awt.Image;
import javax.swing.ImageIcon;


public abstract class Bug {
    
    
    private final Image BugImage;
    private  int x =0;
    private  int y=0;
    private int bordure =1;
    private String name;

    public Bug(String nameImage ,String name) {

        ImageIcon iib = new ImageIcon(nameImage);
        BugImage = iib.getImage();
        x = (int) (Math.random()*Aquarium.getTaille()-bordure); // -1 c'est pour eviter que le poisson appraisse directemet dans les bords
        y = (int) (Math.random()*Aquarium.getTaille()-bordure);
        this.name = name;
    }



    public Image getBug(){    
        return BugImage;
        }

     public  int getX(){
            return x;
            }
        
     public int getY(){
            return y;
           }
    
           public String getName(){
            return name;
           }

     public void update(){

        } 
}
