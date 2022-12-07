public class FishRed extends Fish {

  public static int chrono=20; // nombre de temps du bonus de vitesse
  public static int chrono2=20;
  private static int departureX =0;
  private static int departureY = 400;
 

  public FishRed(String colors, int speedMax, String nameImage,int id) {

    super("red", Aquarium.getSpeed(), "Image/FishRed.png",4);
    newTarget_X=departureX;
    newTarget_Y=departureY;
    if(vitesse >= vitesseMax){ // car la vitesse d'un poisson ne depasse jamais la vitesse max 
    vitesse = vitesseMax;
    }
  }

  public String getColor(){
    return FishRed.super.getColors();
  }


  @Override
  public  void update(){
    super.update();
    chrono--;

    target_x=newTarget_X;
    target_y=newTarget_Y;



    if(FishRed.this.getX()==1 || FishRed.this.getX()==2){ 
      FishRed.this.setX(FishRed.this.getX()+3);
      move =   (int) (1 + (Math.random() * (8)));     
    }

    if(FishRed.this.getX() == Aquarium.getTaille()-1 || FishRed.this.getX() == Aquarium.getTaille()-2  ){
      FishRed.this.setX(FishRed.this.getX()-3);  
      move =   (int) (1 + (Math.random() * (8)));       
    }
      
    if(FishRed.this.getY() == 1 || FishRed.this.getY() == 2  ){ // le 1 c'est pour eviter qu'il rentre dans l'ecran
      FishRed.this.setY(FishRed.this.getY()+3);  
      move =   (int) (1 + (Math.random() * (8)));      
    }

    if(FishRed.this.getY() == Aquarium.getTaille()-1 || FishRed.this.getY() == Aquarium.getTaille()-2  ){ // le 1 c'est pour eviter qu'il rentre dans l'ecran
      FishRed.this.setY(FishRed.this.getY()-3);  
      move =   (int) (1 + (Math.random() * (8)));          
    }
    
    if(Aquarium.temperature.equals("cold")){
      vitesse = 1;
    }

    if(Aquarium.temperature.equals("hard")){
      vitesse = 4;
    }
    
    for (int i = 0; i < Aquarium.listDeco.size(); i++) {
      if(Aquarium.listDeco.get(i).getX() == FishRed.this.getX() && FishRed.this.getY() == Aquarium.listDeco.get(i).getY()){
        FishRed.this.setX(FishRed.this.getX()+1);  
        move =   (int) (1 + (Math.random() * (8)));
      }
    }
    // petit soucis, le poisson rouge apres avoir manger, ne sis plus ou il doit aller et aussi il ne sais pas encore aller chercher en diagonal les proies  
    for (int i = 0; i < Aquarium.listFishPrey.size(); i++) {
  
      if(Aquarium.listFishPrey.get(i).getX()== FishRed.this.getX() && FishRed.this.getY() < Aquarium.listFishPrey.get(i).getY()    ){ // si poisson Red est dans axe ordonee haut poisson mauve alors poisson mauve descend
        move=3;
      }

      if(Aquarium.listFishPrey.get(i).getX() == FishRed.this.getX() && FishRed.this.getY() > Aquarium.listFishPrey.get(i).getY()    ){ // si poisson Red est dans axe ordonee haut poisson mauve alors poisson mauve descend
        move=4;
      }

      if(Aquarium.listFishPrey.get(i).getY() == FishRed.this.getY() && FishRed.this.getX() < Aquarium.listFishPrey.get(i).getX()    ){ // si poisson Red est dans axe ordonee haut poisson mauve alors poisson mauve descend
        move=1;
      }

      if(Aquarium.listFishPrey.get(i).getY() == FishRed.this.getY() && FishRed.this.getX() > Aquarium.listFishPrey.get(i).getX()    ){ // si poisson Red est dans axe ordonee haut poisson mauve alors poisson mauve descend
        move=2;
      }
      
      if((Aquarium.listFishPrey.get(i).getX() == FishRed.this.getX()) && (FishRed.this.getY() == Aquarium.listFishPrey.get(i).getY())    ){ // si poisson Red est dans axe ordonee haut poisson mauve alors poisson mauve descend  
        Fish fish = Aquarium.listFishPrey.get(i);
        Aquarium.removeFromListFish(fish);  
        move =  (int) (1 + (Math.random() * (8)));     
      }
    }

    for (int i = 0; i < Aquarium.listButterfly.size(); i++) {
      if(FishRed.this.getX() == Aquarium.listButterfly.get(i).getX() && Aquarium.listButterfly.get(i).getY() == FishRed.this.getY()){ // si poisson Red est dans axe ordonee haut poisson mauve alors poisson mauve descend 
        Bug bug = Aquarium.listButterfly.get(i);
        Aquarium.removeFromListBug(bug); 
        for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
          if(Aquarium.getlistFish().get(j).getId()==4){   
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
    if(FishRed.this.getX() == Aquarium.listCockroach.get(i).getX() && Aquarium.listCockroach.get(i).getY() == FishRed.this.getY()    ){ // si poisson Red est dans axe ordonee haut poisson mauve alors poisson mauve descend 
      Bug bug = Aquarium.listCockroach.get(i);
      Aquarium.removeFromListBug(bug); 
      for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
        if(Aquarium.getlistFish().get(j).getId()==4){   
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
  if(FishRed.this.getX() == Aquarium.listLadyBug.get(i).getX() && Aquarium.listLadyBug.get(i).getY() == FishRed.this.getY()    ){ // si poisson Red est dans axe ordonee haut poisson mauve alors poisson mauve descend 
    Bug bug = Aquarium.listLadyBug.get(i);
    Aquarium.removeFromListBug(bug); 
    for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
      if(Aquarium.getlistFish().get(j).getId()==4){   
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
      if(FishRed.this.getX() == Aquarium.listPast.get(i).getX() && Aquarium.listPast.get(i).getY() == FishRed.this.getY()    ){ // si poisson Red est dans axe ordonee haut poisson mauve alors poisson mauve descend 
        Past past = Aquarium.listPast.get(i);
        Aquarium.removeFromListPast(past);                 
        for (int j = 0; j < Aquarium.getlistFish().size(); j++) {
      // les poisson s'arrete 90 sec ( petit soucis le poisson garde son unique mouvement )
          if(Aquarium.getlistFish().get(j).getId()!=4){   
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