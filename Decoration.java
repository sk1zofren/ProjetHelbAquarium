import javax.swing.ImageIcon;
import java.awt.Image;

public class Decoration {
    

    private final Image DecoImage;
    private String nameImage;
    private   int x =0; // j'ai mit en static pour pourvoir les utiliser dans la classe fish
    private   int y=0;
    private int bordureDroite =2;
    private int borureGrauche=2;
    private int bordureBas=4;
    private int bordureHaut=4;

    public Decoration(String nameImage) {
       
       ImageIcon iib = new ImageIcon("Image/Dec.png");
       DecoImage = iib.getImage();
       x = (int) (Math.random()*Aquarium.getTaille()-1);
        y = (int) (Math.random()*Aquarium.getTaille()-1);
      
       
    }


    public Image getDeco(){
        return DecoImage;
    }

    public static int getNDeco(){
        return Aquarium.listDeco.size();
    }

    public int getX(){
        return x;
        }
    
        public int getY(){
        return y;
       }

       public int getBordureGauche(){
        return borureGrauche;
        }
        
        public int getBordureDroite(){
            return bordureDroite;
        } 
        
        public int getBordureHaut(){
            return bordureHaut;
            } 

            public int getBordureBas(){
                return bordureBas;
                } 


       public void update(){

       
       }

}
