public class FishOrange extends Fish {

  private static int chrono =20;
  private static int chrono2 =90;
  
  public int chrono3=50;
  public int chrono4=50;
  
 

  public FishOrange(String colors, String nameImage,int id, int speed) {
    super("orange", "Image/fishOrange.png",1,50);
    
    newTarget_X=(int) (1 + (Math.random() * (Aquarium.getHeights())));;
    newTarget_Y=(int) (1 + (Math.random() * (Aquarium.getHeights())));;
    
  } 
  
  public String getColor(){
    return FishOrange.super.getColors();
  }

  @Override
  public  void update(){
    super.update();
    chrono3--;

    target_x=newTarget_X;
    target_y=newTarget_Y;
  
  // Quand le poisson Orange touche un obstacle, il change direction //TODO regarder la methode dans fish puis revenir
      
  if(touchOb){
    newTarget_X =(int) (1 + (Math.random() * (Aquarium.getHeights())));         
    newTarget_Y = (int) (1 + (Math.random() * (Aquarium.getLenghts())));
    touchOb =false;
  }
    chrono--;
    chrono2--;

   
                                                 
  }  
}
