public class GameObjectElement {

    protected int pos_x; // fish x coordinate
    protected int pos_y; // fish y coordinate
  
    public GameObjectElement() {
      pos_x = (int)(Fish.screenLimitLeft + (Math.random() * (Aquarium.getLenghts()-Fish.screenLimitLeft)));
      pos_y = (int)(Fish.screenLimitLeft + (Math.random() * (Aquarium.getLenghts())));
    }
  
    public int getX() {
      return pos_x;
    }
  
    public int getY() {
      return pos_y;
    }
  }