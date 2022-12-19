public class FishRed extends Fish  {

  public static int chrono=20; 
  public static int chrono2=20; 
  public int chrono3=1;
  public int chrono4=1;
  
 
  public FishRed(String colors, int speedMax, String nameImage,int id,int speed) {
    super("red", Aquarium.getSpeed(), "Image/FishRed.png",4,80);
    newTarget_X=0; // au debut mon poisson va au il veut (null )
    newTarget_Y=0; // au debut mon poisson va au il veut ( null)
   

  
  }

  public String getColor(){
    return FishRed.super.getColors();
  }

  public void manger(){
    for (int j = 0; j < Aquarium.listFishPrey.size(); j++) {  
      if(pos_x == Aquarium.listFishPrey.get(j).pos_x && pos_y == Aquarium.listFishPrey.get(j).pos_y ){
        Fish fish = Aquarium.listFishPrey.get(j);
        Aquarium.removeFromListFish(fish);
        Aquarium.removeFromListFishPray(fish);   
         recherch();
      }
    } 
  }

  public void recherch(){
    double distanceDepart= Integer.MAX_VALUE;
    for (int j = 0; j < Aquarium.listFishPrey.size(); j++) {  
      int x_dist = Aquarium.listFishPrey.get(j).pos_x-pos_x;
      int y_dist = Aquarium.listFishPrey.get(j).pos_y-pos_y; 
     
      double distance = Math.sqrt(Math.pow(x_dist, 2)+Math.pow(y_dist, 2));
      if(distance < distanceDepart){  
        newTarget_X = Aquarium.listFishPrey.get(j).pos_x;
        newTarget_Y = Aquarium.listFishPrey.get(j).pos_y;
        distanceDepart = distance;     
      }  
    }
  }

  @Override
  public  void update(){
    
    super.update();
    
    target_x=newTarget_X;
    target_y=newTarget_Y;   
    recherch();
    manger(); 
    if(Aquarium.temperature.equals("cold")){
      speed = speedBasic -20;
    }
    if(Aquarium.temperature.equals("hard")){
      speed = speedBasic +20;
    } 
    
  }
}