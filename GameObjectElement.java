public class GameObjectElement {

    protected  int pos_x; // fish x coordinate
    protected  int pos_y; // fish y coordinate


    public GameObjectElement(){
    pos_x = (int) (Math.random()*Aquarium.getheight()-Fish.screenLimitLeft);
    pos_y = (int) (Math.random()*Aquarium.getheight()-Fish.screenLimitLeft);
    }

    
    public int getX(){
        return pos_x;
    }
    
    public int getY(){
        return pos_y;
    }
}
