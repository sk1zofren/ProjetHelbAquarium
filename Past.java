import javax.swing.ImageIcon;
import java.awt.Image;

public class Past {
    
    private final Image PastImage;
    private String nameImage;
    private   int x =0; 
    private   int y=0;
    private int bordure =1;
    private int chrono=500;  
    private int CompId;


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
    for (int j = 0; j < Aquarium.listFish.size(); j++) {          
        Aquarium.listFish.get(j).tqt = true;   
    }  
}
    for (int i = 0; i < Aquarium.listFish.size(); i++) {
            if (Aquarium.listFish.get(i).pos_x > getX()  - 6 && Aquarium.listFish.get(i).pos_x < getX() + 6 && Aquarium.listFish.get(i).pos_y > getY() - 6 && Aquarium.listFish.get(i).pos_y < getY() + 6) { // TODO je fais sa car vu que je travaille en pixelle, la prob que leurs coordonee se touche est très faible, duplication de code ? 
                Past past = this;
                Aquarium.removeFromListPast(past); 
                CompId = Aquarium.listFish.get(i).getId();
                for (int j = 0; j < Aquarium.listFish.size(); j++) {          
                    if(Aquarium.listFish.get(j).getId()!=CompId)
                    Aquarium.listFish.get(j).tqt = false;
                   
                    
                }
                chrono=500;
            }
        }
        

       }

}

