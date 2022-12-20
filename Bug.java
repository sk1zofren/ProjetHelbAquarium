public class Bug extends GameObjectElement {

    private String name; // name of insect type
    private static int chrono5=10000; // chrono for timer
    private int chronoB= 9999; // chrono bonus speed for butterfly
    private int chronoC = 8888; // chrono bonus speed for cockroach
    private int chronoL = 7777; // chrono bonus speed for ladybug
    private int borderBug =6; // the outline of the bug
    private int speedBonus = 99; // bonus speed
    private int basicSpeed=50; // basic speed
    
    
   
    public Bug(String name) {
       
     
      this.name = name;
       
    }
           
       public int getDuree(){
        if(getName().equals("Butterfly")){
            chrono5=chronoB;
        }
        if(getName().equals("Cockroach")){
            chrono5=chronoC;
        }
        if(getName().equals("LadyBug")){
            chrono5=chronoL;
        }
       
        return chrono5;
       }  
           
    
           public String getName(){
            
            return name;
           }

     public void update(){

      if(chrono5<chrono5){ // the departure of chrono
        chrono5--;
      }
     
        
if(chrono5<0){ // when the chrono is below 0 we reset the base speed
    for (int j = 0; j < Aquarium.listFish.size(); j++) {
        if ( Aquarium.listFish.get(j).speed == speedBonus) {
        Aquarium.listFish.get(j).speed = basicSpeed;
      }

      }

    }         
        for (int i = 0; i < Aquarium.listFish.size(); i++) {   // when a fish touches an insect, the timer is triggered
          if (Aquarium.listFish.get(i).pos_x > getX() - borderBug && Aquarium.listFish.get(i).pos_x < getX() + borderBug && Aquarium.listFish.get(i).pos_y > getY() - borderBug && Aquarium.listFish.get(i).pos_y < getY() + borderBug) {  
            Bug bug = this;  
            Aquarium.removeFromListBug(bug);  
            Aquarium.listFish.get(i).speed=speedBonus; 
            chrono5=this.getDuree(); 
             
          }  
        }
        
        
        } 
}
