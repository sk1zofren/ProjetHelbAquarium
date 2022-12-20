public class FishPurple extends Fish {
  
  private int departX=0;

  public FishPurple() {
    super(3,50);    
    newTarget_X=(int) (Fish.screenLimitLeft + (Math.random() * (Aquarium.getHeights()))); // random target
    newTarget_Y=(int) (Fish.screenLimitLeft + (Math.random() * (Aquarium.getLenghts()))); //random target
   
      
  }

public void go(){ // the purple fish searches for the nearest bald fish and goes in its opposite direction
  double startDepart= Integer.MAX_VALUE;
  for (int i = 0; i < Aquarium.listFishRed.size(); i++) {
    int x_dist = Aquarium.listFishRed.get(i).pos_x-pos_x;
    int y_dist = Aquarium.listFishRed.get(i).pos_y-pos_y;  
    double distance = Math.sqrt(Math.pow(x_dist, 2)+Math.pow(y_dist, 2)); 
    if(distance < startDepart ){ 
      if(pos_x<Aquarium.listFishRed.get(i).pos_x){ 
      newTarget_X = departX;
      newTarget_Y = pos_y;
      
      }else if(pos_x>Aquarium.listFishRed.get(i).pos_x) {
        newTarget_X = Aquarium.getHeights();
        newTarget_Y = Aquarium.listFishRed.get(i).pos_y;
        
      }else if (pos_y<Aquarium.listFishRed.get(i).pos_y && pos_x == Aquarium.listFishRed.get(i).pos_x){
        newTarget_X = Aquarium.listFishRed.get(i).pos_y;
        newTarget_Y =departX;
      }else if(pos_y<Aquarium.listFishRed.get(i).pos_y && pos_x == Aquarium.listFishRed.get(i).pos_x){
        newTarget_X = Aquarium.listFishRed.get(i).pos_y;
        newTarget_Y=Aquarium.getLenghts();
      }
      startDepart = distance;
      
    } 
  }
}
  
  @Override
  public void update(){
    super.update();  
    target_x=newTarget_X;
    target_y=newTarget_Y;
    go();  
    if(speed >= speedMax){ // the limit of speed
      speed = speedMax;
      }else{
        speed=speedBasic+Aquarium.numberOfDeco;
      }
      }
}
