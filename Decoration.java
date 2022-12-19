public class Decoration {

    private   int x =0; // fish x coordinate
    private   int y=0; // fish y coordinate
  
    public Decoration() {
       
       
       x = (int) (Math.random()*Aquarium.getheight()-Fish.screenLimitLeft);
        y = (int) (Math.random()*Aquarium.getheight()-Fish.screenLimitLeft);
      
       
    }

    

    public int getX(){
        return x;
        }
    
        public int getY(){
        return y;
       }



       public void update(){

       
       }

}
