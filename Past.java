import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.concurrent.TimeUnit;

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
/*!!!!!!! 
    for (int i = 0; i < Aquarium.listPast.size(); i++) {

            if (Aquarium.listFish.pos_x > Aquarium.listPast.get(i).getX() - 6 && pos_x < Aquarium.listPast.get(i).getX() + 6 && pos_y > Aquarium.listPast.get(i).getY() - 6 && pos_y < Aquarium.listPast.get(i).getY() + 6) { // TODO je fais sa car vu que je travaille en pixelle, la prob que leurs coordonee se touche est très faible, duplication de code ? 
                Past past = Aquarium.listPast.get(i);
                Aquarium.removeFromListPast(past);
              

            }
        }
 */

       }

}
