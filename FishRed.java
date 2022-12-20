public class FishRed extends Fish  {

   private int tempChangment = 20;
  public FishRed() {
    super(4,80);
    newTarget_X=(int) (Fish.screenLimitLeft + (Math.random() * (Aquarium.getHeights()))); // random target
    newTarget_Y=(int) (Fish.screenLimitLeft + (Math.random() * (Aquarium.getLenghts()))); // random target
   

  
  }


  public void eat(){ // methode that eat the prey
    for (int j = 0; j < Aquarium.listFishPrey.size(); j++) {  
      if(pos_x == Aquarium.listFishPrey.get(j).pos_x && pos_y == Aquarium.listFishPrey.get(j).pos_y ){
        Fish fish = Aquarium.listFishPrey.get(j);
        Aquarium.removeFromListFish(fish);
        Aquarium.removeFromListFishPray(fish);   
        research();
      }
    } 
  }

  public void research(){ // method that searches for the nearest fish in the prey list
    double startDepart= Integer.MAX_VALUE;
    for (int j = 0; j < Aquarium.listFishPrey.size(); j++) {  
      int x_dist = Aquarium.listFishPrey.get(j).pos_x-pos_x;
      int y_dist = Aquarium.listFishPrey.get(j).pos_y-pos_y; 
     
      double distance = Math.sqrt(Math.pow(x_dist, 2)+Math.pow(y_dist, 2));
      if(distance < startDepart){  
        newTarget_X = Aquarium.listFishPrey.get(j).pos_x;
        newTarget_Y = Aquarium.listFishPrey.get(j).pos_y;
        startDepart = distance;     
      }  
    }
  }

  @Override
  public  void update(){
    
    super.update();
    
    target_x=newTarget_X;
    target_y=newTarget_Y;   
    research();
    eat(); 
    if(Aquarium.temperature.equals("cold")){ // temperature change cold
      speed = speedBasic -tempChangment;
    }
    if(Aquarium.temperature.equals("hard")){ // temperature change hard
      speed = speedBasic +tempChangment;
    } 
    
  }
}