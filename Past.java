import javax.swing.ImageIcon;
import java.awt.Image;

public class Past {
    
    private final Image PastImage;
    private String nameImage;
    private   int x =0; // j'ai mit en static pour pourvoir les utiliser dans la classe fish
    private   int y=0;
    private int bordure =1;
    private int chrono=60;
    private int stop=-100000;


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
chrono--;
if(chrono<0){
    stop=0;
    
}
System.out.println();
    for (int i = 0; i < Aquarium.listFish.size(); i++) {
            if (Aquarium.listFish.get(i).pos_x > getX()  - 6 && Aquarium.listFish.get(i).pos_x < getX() + 6 && Aquarium.listFish.get(i).pos_y > getY() - 6 && Aquarium.listFish.get(i).pos_y < getY() + 6) { // TODO je fais sa car vu que je travaille en pixelle, la prob que leurs coordonee se touche est très faible, duplication de code ? 
                Past past = this;
                Aquarium.removeFromListPast(past); 
                chrono=100;
                stop=-10000;
                for (int j = 0; j < Aquarium.listFish.size(); j++) {          
                    if(Aquarium.listFish.get(j).getId()!=Aquarium.listFish.get(i).getId())
                    Aquarium.listFish.get(j).speed = stop;
                    
                }
            }
        }
        

       }

}
