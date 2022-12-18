public class FishPurple extends Fish {

  public static int chrono=20;
  public static int chrono2=20;
  public static int bonusDeco = Aquarium.numberOfDeco;
  public boolean commmence=true;
  public FishPurple(String colors, int speedMax,String nameImage,int id,int speed) {
    super(colors, Aquarium.getSpeed(), "Image/FishPurple.png",3,50);    
    newTarget_X=(int) (1 + (Math.random() * (Aquarium.getHeights())));;
    newTarget_Y=(int) (1 + (Math.random() * (Aquarium.getHeights())));;
      
  }

public void fuit(){
  double distanceDepart= Integer.MAX_VALUE;
  for (int i = 0; i < Aquarium.listFishRed.size(); i++) {
    int x_dist = Aquarium.listFishRed.get(i).pos_x-pos_x;
    int y_dist = Aquarium.listFishRed.get(i).pos_y-pos_y;  
    double distance = Math.sqrt(Math.pow(x_dist, 2)+Math.pow(y_dist, 2)); 
    if(distance < distanceDepart ){ 
      if(pos_x<Aquarium.listFishRed.get(i).pos_x){ //if the purple fish is on the left of red fish
      newTarget_X = 0;
      newTarget_Y = pos_y;
      
      }else if(pos_x>Aquarium.listFishRed.get(i).pos_x) {
        newTarget_X = Aquarium.getHeights();
        newTarget_Y = Aquarium.listFishRed.get(i).pos_y;
        
      }else if (pos_y<Aquarium.listFishRed.get(i).pos_y && pos_x == Aquarium.listFishRed.get(i).pos_x){
        newTarget_X = Aquarium.listFishRed.get(i).pos_y;
        newTarget_Y =0;
      }else if(pos_y<Aquarium.listFishRed.get(i).pos_y && pos_x == Aquarium.listFishRed.get(i).pos_x){
        newTarget_X = Aquarium.listFishRed.get(i).pos_y;
        newTarget_Y=Aquarium.getLenghts();
      }
      distanceDepart = distance;
      
    } 
  }
}
  
  @Override
  public void update(){
    super.update();
      
    target_x=newTarget_X;
    target_y=newTarget_Y;
    fuit();  
    if(speed >= speedMax){
      speed = speedMax;
      }else{
        speed=speedBasic+Aquarium.numberOfDeco;
      }
      }
}
