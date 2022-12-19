public class Past {


  private int x = 0; // x coordinate
  private int y = 0; // y coordinate
  static int borderPast=6;
  private static int chrono = 10000; // chrono for timer
  private int CompId; // to compare id

  public Past() {

    
    x = (int)(Math.random() * Aquarium.getheight() - Fish.screenLimitLeft);
    y = (int)(Math.random() * Aquarium.getheight() - Fish.screenLimitLeft);

  }

  

  public int getDuree(){
    return chrono;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void update() {
    
    chrono--;
    if (chrono < 0) { // when the time is finish the fish can move
      for (int j = 0; j < Aquarium.listFish.size(); j++) {
        Aquarium.listFish.get(j).move = true;
      }
    }
    for (int i = 0; i < Aquarium.listFish.size(); i++) { // when a fish touch a past, the auther fish can't move
      if (Aquarium.listFish.get(i).pos_x > getX() - borderPast && Aquarium.listFish.get(i).pos_x < getX() + borderPast && Aquarium.listFish.get(i).pos_y > getY() - borderPast && Aquarium.listFish.get(i).pos_y < getY() + borderPast) { // TODO je fais sa car vu que je travaille en pixelle, la prob que leurs coordonee se touche est très faible, duplication de code ? 
        Past past = this;
        Aquarium.removeFromListPast(past);   
        CompId = Aquarium.listFish.get(i).getId();
        for (int j = 0; j < Aquarium.listFish.size(); j++) {
          if (Aquarium.listFish.get(j).getId() != CompId)
            Aquarium.listFish.get(j).move = false;
            chrono = chrono;
        }
        
      }
     
    }

  }

}