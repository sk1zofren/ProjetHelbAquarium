import javax.swing.ImageIcon;
import java.awt.Image;

public class Rosa {
    

    private final Image RosaImage;
    private String nameImage;
    private   int x =0; // j'ai mit en static pour pourvoir les utiliser dans la classe fish
    private   int y=0;
    private int CompId;
    

    public Rosa(String nameImage) {
       
       ImageIcon iib = new ImageIcon("Image/rose.png");
       RosaImage = iib.getImage();
       x = (int) (Math.random()*Aquarium.getTaille()-1);
        y = (int) (Math.random()*Aquarium.getTaille()-1);
      
       
    }


    public Image getRosa(){
        return RosaImage;
    }

 

    public int getX(){
        return x;
        }
    
        public int getY(){
        return y;
       }



       public void update(){

        for (int i = 0; i < Aquarium.listFish.size(); i++) {
            if (Aquarium.listFish.get(i).pos_x > getX() - 6 && Aquarium.listFish.get(i).pos_x < getX() + 6 && Aquarium.listFish.get(i).pos_y > getY() - 6 && Aquarium.listFish.get(i).pos_y < getY() + 6) { // TODO je fais sa car vu que je travaille en pixelle, la prob que leurs coordonee se touche est très faible, duplication de code ? 
              Rosa rosa = this;
              Aquarium.removeFromListRosa(rosa);
              CompId = Aquarium.listFish.get(i).getId();
              for (int j = 0; j < Aquarium.listFish.size(); j++) {
                if (Aquarium.listFish.get(j).getId() == CompId)
                  Aquarium.listFish.get(j).pos_x = (int)(1 + (Math.random() * (Aquarium.getTaille())));
                  Aquarium.listFish.get(j).pos_y = (int)(1 + (Math.random() * (Aquarium.getTaille())));
      
              }
             
            }
          }
       
       }

}
