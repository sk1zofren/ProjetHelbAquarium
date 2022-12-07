public class FishOrange extends Fish {

  private static int chrono =20;
  private static int chrono2 =90;
  private static int departureX =400;
  private static int departureY = 400;

  public FishOrange(String colors, int vitesse, String nameImage,int id) {
    super("orange", vitesse, "Image/fishOrange.png",1);
    
    newTarget_X=departureX;
    newTarget_Y=departureY;

    if(vitesse >= vitesseMax){ // car la vitesse d'un poisson ne depasse jamais la vitesse max 
      vitesse = vitesseMax;
    }  
  } 
  
  public String getColor(){
    return FishOrange.super.getColors();
  }

  @Override
  public  void update(){
    super.update();
    target_x=newTarget_X;
    target_y=newTarget_Y;
    
  if(touchOb){
    newTarget_X =0;
    newTarget_Y = 0;
  }

    chrono--;
    chrono2--;

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
  
    for (int i = 0; i < Aquarium.listPast.size(); i++) {
      if(FishOrange.this.getX() == Aquarium.listPast.get(i).getX() && Aquarium.listPast.get(i).getY() == FishOrange.this.getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
        Past past = Aquarium.listPast.get(i);
        Aquarium.removeFromListPast(past);                 
        for (int j = 0; j < Aquarium.getlistFish().size(); j++) {
      // les poisson s'arrete 90 sec ( petit soucis le poisson garde son unique mouvement )
          if(Aquarium.getlistFish().get(j).getId()!=1){   
            chrono2=90;
           
            Aquarium.listFish.get(j).move=0; // si on laisse que move ben c'est celui qui a toucher qui s'arrete et pas tt les rouges
          }   
        }  
      }
    }
    for (int i = 0; i < Aquarium.getlistFish().size(); i++) {
      if(chrono2<1 && Aquarium.listFish.get(i).move == 0){
        Aquarium.listFish.get(i).move=(int) (1 + (Math.random() * (8)));

      } 
    }
   
                                                 
  }  
}
