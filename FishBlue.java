public class FishBlue extends Fish {

   // ce poisson de base a une vitesse plus grande donc avev le bonus c'est encore plus
private static int chrono=20;
private static int chrono2=20;
static boolean pret=true;


  public FishBlue( String nameImage,int id,int speed) {
    super("Image/FishBlue.png",2,90);
    newTarget_X=0;
    newTarget_Y=0;   
  
       
    }
      
public void ami(){
  double distanceDepart= Integer.MAX_VALUE;
  for (int i = 0; i < Aquarium.listFishFriend.size(); i++) {
    int x_dist = Aquarium.listFishFriend.get(i).pos_x-pos_x;
    int y_dist = Aquarium.listFishFriend.get(i).pos_y-pos_y;  
    double distance = Math.sqrt(Math.pow(x_dist, 2)+Math.pow(y_dist, 2)); 
    if(distance < distanceDepart && Aquarium.listFishFriend.get(i).hashCode() != this.hashCode() ){ //TODO je dois peut etre rajouter pos_y aussi pour dire la meme position que lui
      newTarget_X = Aquarium.listFishFriend.get(i).pos_x;
      newTarget_Y = Aquarium.listFishFriend.get(i).pos_y;
      distanceDepart = distance;
      
    }  
  }
}  

@Override
public void update(){
 
    super.update(); 
    target_x=newTarget_X;
    target_y=newTarget_Y;
    if(pret){
    ami();
    }
   
   
    }



}
