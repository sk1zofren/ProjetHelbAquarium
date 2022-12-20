public class FishBlue extends Fish {

  public FishBlue() {

    super(2,90);
    newTarget_X=(int) (Fish.screenLimitLeft + (Math.random() * (Aquarium.getHeights())));
    newTarget_Y=(int) (Fish.screenLimitLeft + (Math.random() * (Aquarium.getLenghts()))); 
  
       
    }
      
public void ami(){ //method to find the nearest friendly fish
  double startDepart= Integer.MAX_VALUE;
  for (int i = 0; i < Aquarium.listFishFriend.size(); i++) {
    int x_dist = Aquarium.listFishFriend.get(i).pos_x-pos_x;
    int y_dist = Aquarium.listFishFriend.get(i).pos_y-pos_y;  
    double distance = Math.sqrt(Math.pow(x_dist, 2)+Math.pow(y_dist, 2)); 
    if(distance < startDepart && Aquarium.listFishFriend.get(i).hashCode() != this.hashCode() ){
      newTarget_X = Aquarium.listFishFriend.get(i).pos_x;
      newTarget_Y = Aquarium.listFishFriend.get(i).pos_y;
      startDepart = distance;
      
    }  
  }
}  

@Override
public void update(){ 
    super.update(); 
    target_x=newTarget_X;
    target_y=newTarget_Y;
    ami();
   
   
    }



}
