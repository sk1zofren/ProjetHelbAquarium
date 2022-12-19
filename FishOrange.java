public class FishOrange extends Fish {

  
 

  public FishOrange(String nameImage,int id, int speed) {
    super("Image/fishOrange.png",1,50);
    
    newTarget_X=(int) (1 + (Math.random() * (Aquarium.getHeights())));;
    newTarget_Y=(int) (1 + (Math.random() * (Aquarium.getHeights())));;
    
  } 
  

  @Override
  public  void update(){
    super.update();
 

    target_x=newTarget_X;
    target_y=newTarget_Y;
  
  // Quand le poisson Orange touche un obstacle, il change direction //TODO regarder la methode dans fish puis revenir
      
  if(touchOb){
    newTarget_X =(int) (1 + (Math.random() * (Aquarium.getHeights())));         
    newTarget_Y = (int) (1 + (Math.random() * (Aquarium.getLenghts())));
    touchOb =false;
  }
   

   
                                                 
  }  
}
