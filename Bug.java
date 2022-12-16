import java.awt.Image;
import javax.swing.ImageIcon;

public class Bug {

      
    private final Image BugImage;
    private  int x =0;
    private  int y=0;
    private int bordure =1;
    private String name;
    private static int chrono5=10000;
    
    
   
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
           
       public int getDuree(){
        if(getName().equals("Butterfly")){
            chrono5=9999;
        }
        if(getName().equals("Cockroach")){
            chrono5=8888;
        }
        if(getName().equals("LadyBug")){
            chrono5=7777;
        }
       
        return chrono5;
       }  
           
    
           public String getName(){
            
            return name;
           }

     public void update(){

      if(chrono5<10000){
        chrono5--;
      }
     
        
if(chrono5<0){
    for (int j = 0; j < Aquarium.listFish.size(); j++) {
        if ( Aquarium.listFish.get(j).speed == 91) {
        Aquarium.listFish.get(j).speed = 50;
      }

      }

    }         
        for (int i = 0; i < Aquarium.listFish.size(); i++) {  
          if (Aquarium.listFish.get(i).pos_x > getX() - 6 && Aquarium.listFish.get(i).pos_x < getX() + 6 && Aquarium.listFish.get(i).pos_y > getY() - 6 && Aquarium.listFish.get(i).pos_y < getY() + 6) { // TODO je fais sa car vu que je travaille en pixelle, la prob que leurs coordonee se touche est très faible, duplication de code ? 
            Bug bug = this;  
            Aquarium.removeFromListBug(bug);  
            Aquarium.listFish.get(i).speed=91; 
            chrono5=this.getDuree(); 
             
          }  
        }
        
        
        } 
}
