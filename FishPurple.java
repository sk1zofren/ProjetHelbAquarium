public class FishPurple extends Fish {

  public static int chrono=20;
  public static int chrono2=20;
  public static int bonusDeco = Aquarium.numberOfDeco;

  public FishPurple(String colors, int speedMax,String nameImage,int id) {
      super(colors, Aquarium.getSpeed(), "Image/FishPurple.png",3);
      bonusDeco = Decoration.getNDeco();
     

    departureX =100;
    departureY=100;
    newTarget_X=departureX;
    newTarget_Y=departureY;

     /* 
     move=1;
     if(vitesse >= vitesseMax){ // ne fonctionne pas encore bien car ne veux pas récuperer la valeur du nombre de deco
      vitesse = vitesseMax;
      }else{
        vitesse= Aquarium.numberOfDeco;
      }
  */
  }

  
  @Override
  public void update(){
    super.update();
    chrono--;
     
    target_x=newTarget_X;
    target_y=newTarget_Y;


 for (int i = 0; i < Aquarium.listFish.size(); i++) {

  if(Aquarium.listFish.get(i).getId()==4 && Aquarium.listFish.get(i).target_x == FishPurple.this.pos_x && Aquarium.listFish.get(i).target_y == FishPurple.this.pos_y ){

newTarget_X = (int) (1 + (Math.random() * (Aquarium.getTaille())));
newTarget_Y = (int) (1 + (Math.random() * (Aquarium.getTaille())));

  }
  
 }

  
      
  for (int i = 0; i < Aquarium.listFishRed.size(); i++) {
    if(Aquarium.listFishRed.get(i).getX() == FishPurple.this.getX() && FishPurple.this.getY() < Aquarium.listFishRed.get(i).getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend
      move=4;
    }
  
    if(Aquarium.listFishRed.get(i).getX() == FishPurple.this.getX() && FishPurple.this.getY() > Aquarium.listFishRed.get(i).getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend
      move=3;
    }
        
    if(Aquarium.listFishRed.get(i).getY() == FishPurple.this.getY() && FishPurple.this.getX() < Aquarium.listFishRed.get(i).getX()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend
      move=2;
    }
  
    if(Aquarium.listFishRed.get(i).getY() == FishPurple.this.getY() && FishPurple.this.getX() > Aquarium.listFishRed.get(i).getX()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend
      move=1;
    }
  }



  
  




              for (int i = 0; i < Aquarium.listButterfly.size(); i++) {
                if(FishPurple.this.getX() == Aquarium.listButterfly.get(i).getX() && Aquarium.listButterfly.get(i).getY() == FishPurple.this.getY()){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
                  Bug bug = Aquarium.listButterfly.get(i);
                  Aquarium.removeFromListBug(bug); 
                  for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
                    if(Aquarium.getlistFish().get(j).getId()==3){   
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
              if(FishPurple.this.getX() == Aquarium.listCockroach.get(i).getX() && Aquarium.listCockroach.get(i).getY() == FishPurple.this.getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
                Bug bug = Aquarium.listCockroach.get(i);
                Aquarium.removeFromListBug(bug); 
                for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
                  if(Aquarium.getlistFish().get(j).getId()==3){   
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
            if(FishPurple.this.getX() == Aquarium.listLadyBug.get(i).getX() && Aquarium.listLadyBug.get(i).getY() == FishPurple.this.getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
              Bug bug = Aquarium.listLadyBug.get(i);
              Aquarium.removeFromListBug(bug); 
              for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
                if(Aquarium.getlistFish().get(j).getId()==3){   
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
        if(FishPurple.this.getX() == Aquarium.listPast.get(i).getX() && Aquarium.listPast.get(i).getY() == FishPurple.this.getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
          Past past = Aquarium.listPast.get(i);
          Aquarium.removeFromListPast(past);                 
          for (int j = 0; j < Aquarium.getlistFish().size(); j++) {
        // les poisson s'arrete 90 sec ( petit soucis le poisson garde son unique mouvement )
            if(Aquarium.getlistFish().get(j).getId()!=3){   
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
