public class FishPurple extends Fish {

  public static int chrono=20;
  public static int chrono2=20;
  public static int bonusDeco = Aquarium.numberOfDeco;
  public boolean commmence=true;

  public FishPurple(String colors, int speedMax,String nameImage,int id,int speed) {
      super(colors, Aquarium.getSpeed(), "Image/FishPurple.png",3,50);
   
    
    newTarget_X=(int) (1 + (Math.random() * (Aquarium.getHeights())));;
    newTarget_Y=(int) (1 + (Math.random() * (Aquarium.getHeights())));;
    

     /* 
    
     if(vitesse >= vitesseMax){ // ne fonctionne pas encore bien car ne veux pas récuperer la valeur du nombre de deco
      vitesse = vitesseMax;
      }else{
        vitesse= Aquarium.numberOfDeco;
      }
  */
  }
public void fuit(){
  //TODO fonctionne mais le fish purple ne peut pas fuir en diagonal
  double distanceDepart= Integer.MAX_VALUE;
  for (int i = 0; i < Aquarium.listFishRed.size(); i++) {
    int x_dist = Aquarium.listFishRed.get(i).pos_x-pos_x;
    int y_dist = Aquarium.listFishRed.get(i).pos_y-pos_y;  
    double distance = Math.sqrt(Math.pow(x_dist, 2)+Math.pow(y_dist, 2)); 
    if(distance < distanceDepart ){ 
      //calcule de l'equation de la droite
      if(pos_x<Aquarium.listFishRed.get(i).pos_x){ //if the purple fish is on the left of red fish
      newTarget_X = 0;
      newTarget_Y = pos_y;
      
      }else if(pos_x>Aquarium.listFishRed.get(i).pos_x) {
        newTarget_X = Aquarium.getHeights();
        newTarget_Y = Aquarium.listFishRed.get(i).pos_y;
        
      }else if (pos_y<Aquarium.listFishRed.get(i).pos_y && pos_x == Aquarium.listFishRed.get(i).pos_x){
        newTarget_X = Aquarium.listFishRed.get(i).pos_y;
        newTarget_Y =0;
      }else if(pos_y<Aquarium.listFishRed.get(i).pos_y && pos_x == Aquarium.listFishRed.get(i).pos_x){
        newTarget_X = Aquarium.listFishRed.get(i).pos_y;
        newTarget_Y=Aquarium.getLenghts();
      }
      distanceDepart = distance;
      
    } 
  }
}
  
  @Override
  public void update(){
    super.update();
    
    target_x=newTarget_X;
    target_y=newTarget_Y;
    fuit();
    
   

/* 
 for (int i = 0; i < Aquarium.listFish.size(); i++) {

  if(Aquarium.listFish.get(i).getId()==4 && Aquarium.listFish.get(i).target_x == FishPurple.this.pos_x && Aquarium.listFish.get(i).target_y == FishPurple.this.pos_y ){

newTarget_X = (int) (1 + (Math.random() * (Aquarium.getTaille())));
newTarget_Y = (int) (1 + (Math.random() * (Aquarium.getTaille())));

  }
  
 }
*/
  
 



  
  




              for (int i = 0; i < Aquarium.listButterfly.size(); i++) {
                if(FishPurple.this.getX() == Aquarium.listButterfly.get(i).getX() && Aquarium.listButterfly.get(i).getY() == FishPurple.this.getY()){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
                  Bug bug = Aquarium.listButterfly.get(i);
                  Aquarium.removeFromListBug(bug); 
                  for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
                    if(Aquarium.getlistFish().get(j).getId()==3){   
                      
                    }  
                  }
                }   
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
         


    
     
      }
}
