public class FishOrange extends Fish {

  private static int chrono =20;
  private static int chrono2 =90;
  
  public int chrono3=50;
  public int chrono4=50;
  
 

  public FishOrange(String colors, int vitesse, String nameImage,int id, int speed) {
    super("orange", vitesse, "Image/fishOrange.png",1,50);
    
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
  /*   
   if(chrono3<0){
bouge=false;
chrono4--;

   }
   if(chrono4<0){
    bouge=true;
    chrono3=50;
    chrono4=50;
   }
*/
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
/* 
    for (int i = 0; i < Aquarium.listButterfly.size(); i++) {
      if(FishOrange.this.getX() == Aquarium.listButterfly.get(i).getX() && Aquarium.listButterfly.get(i).getY() == FishOrange.this.getY()){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
        Bug bug = Aquarium.listButterfly.get(i);
        Aquarium.removeFromListBug(bug); 
        for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
          if(Aquarium.getlistFish().get(j).getId()==1){   
            chrono=40;
            vitesse =3;
          }  
        }
      }   
    }
    if(chrono<1 && vitesse ==3){
      vitesse=2;
  }    
    
    for (int i = 0; i < Aquarium.listCockroach.size(); i++) {
      if(FishOrange.this.getX() == Aquarium.listCockroach.get(i).getX() && Aquarium.listCockroach.get(i).getY() == FishOrange.this.getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
        Bug bug = Aquarium.listCockroach.get(i);
        Aquarium.removeFromListBug(bug); 
        for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
          if(Aquarium.getlistFish().get(j).getId()==1){   
            chrono=50;
            vitesse =3;
          }  
        }
      }   
    }
    if(chrono<1 && vitesse ==3){
      vitesse=2;
  }   
      

    for (int i = 0; i < Aquarium.listLadyBug.size(); i++) {
      if(FishOrange.this.getX() == Aquarium.listLadyBug.get(i).getX() && Aquarium.listLadyBug.get(i).getY() == FishOrange.this.getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
        Bug bug = Aquarium.listLadyBug.get(i);
        Aquarium.removeFromListBug(bug); 
        for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
          if(Aquarium.getlistFish().get(j).getId()==1){   
            chrono=60;
            vitesse =3;
          }  
        }
      }   
    }
    if(chrono<1 && vitesse ==3){
      vitesse=2;
  }
  
    
   */ 
   
                                                 
  }  
}
