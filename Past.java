import javax.swing.ImageIcon;
import java.awt.Image;

public class Past {
    

    private final Image PastImage;
    private String nameImage;
    private   int x =0; // j'ai mit en static pour pourvoir les utiliser dans la classe fish
    private   int y=0;
    private int bordure =1;

    public Past(String nameImage) {
       
       ImageIcon iib = new ImageIcon("Image/past.png");
       PastImage = iib.getImage();
       x = (int) (Math.random()*Aquarium.getTaille()-bordure);
        y = (int) (Math.random()*Aquarium.getTaille()-bordure);
      
       
    }


    public Image getPast(){
        return PastImage;
    }

    public int getX(){
        return x;
        }
    
        public int getY(){
        return y;
       }

       public void update(){

       }

}
