public class FishBlue extends Fish {

   // ce poisson de base a une vitesse plus grande donc avev le bonus c'est encore plus
private static int chrono=20;
private static int chrono2=20;
private boolean pret=true;


  public FishBlue(String colors, int speedMax, String nameImage,int id,int speed) {
    super(colors, Aquarium.getSpeed(), "Image/FishBlue.png",2,10);
    newTarget_X=0;
    newTarget_Y=0;   
  
       
    }
      
public void ami(){
  double distanceDepart= Integer.MAX_VALUE;
  for (int i = 0; i < Aquarium.listFishFriend.size(); i++) {
    int x_dist = Aquarium.listFishFriend.get(i).pos_x-pos_x;
    int y_dist = Aquarium.listFishFriend.get(i).pos_y-pos_y;  
    double distance = Math.sqrt(Math.pow(x_dist, 2)+Math.pow(y_dist, 2)); 
    if(distance < distanceDepart && Aquarium.listFishFriend.get(i).pos_x != pos_x ){  
      newTarget_X = Aquarium.listFishFriend.get(i).pos_x;
      newTarget_Y = Aquarium.listFishFriend.get(i).pos_y;
      distanceDepart = distance;
      
    }  
  }
}  

@Override
public  void update(){
    super.update(); 
    target_x=newTarget_X;
    target_y=newTarget_Y;
    if(pret){
    ami();
    }
    
//chrono--;


 
    //System.out.println(Aquarium.getlistFishFriend().get(3).getMove());
/* 
    if(FishBlue.this.getX()==1 || FishBlue.this.getX()==2){ 
      FishBlue.this.setX(FishBlue.this.getX()+3);
      move =   (int) (1 + (Math.random() * (8)));     
    }

    if(FishBlue.this.getX() == Aquarium.getTaille()-1 || FishBlue.this.getX() == Aquarium.getTaille()-2  ){
      FishBlue.this.setX(FishBlue.this.getX()-3);  
      move =   (int) (1 + (Math.random() * (8)));       
    }
      
    if(FishBlue.this.getY() == 1 || FishBlue.this.getY() == 2  ){ // le 1 c'est pour eviter qu'il rentre dans l'ecran
      FishBlue.this.setY(FishBlue.this.getY()+3);  
      move =   (int) (1 + (Math.random() * (8)));      
    }

    if(FishBlue.this.getY() == Aquarium.getTaille()-1 || FishBlue.this.getY() == Aquarium.getTaille()-2  ){ // le 1 c'est pour eviter qu'il rentre dans l'ecran
      FishBlue.this.setY(FishBlue.this.getY()-3);  
      move =   (int) (1 + (Math.random() * (8)));          
    }
/* 
    for (int i = 0; i < Aquarium.listFishFriend.size(); i++) {

    if(Aquarium.listFishFriend.get(i).getX() == FishBlue.this.getX() && FishBlue.this.getY() < Aquarium.listFishFriend.get(i).getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend
        move=3;
       
      }

      if(Aquarium.listFishFriend.get(i).getX() == FishBlue.this.getX() && FishBlue.this.getY() > Aquarium.listFishFriend.get(i).getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend
        move=4;
      }

      if(Aquarium.listFishFriend.get(i).getY() == FishBlue.this.getY() && FishBlue.this.getX() < Aquarium.listFishFriend.get(i).getX()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend
        move=1;
      }

      if(Aquarium.listFishFriend.get(i).getY() == FishBlue.this.getY() && FishBlue.this.getX() > Aquarium.listFishFriend.get(i).getX()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend
        move=2;
      }

    }  
*/


    // pour eviter les bords 
    // si le poisson touche un bord, doit il rester bloquer ?
/* 
    if(FishBlue.this.getX() == 1 || FishBlue.this.getX() == 2  ){ // le 1 c'est pour eviter qu'il rentre dans l'ecran
    FishBlue.this.setX(FishBlue.this.getX()+3);  // il va reculer pour eviter qu'il repete l'operation a l'infini car il va toucher continuellemnt le bord
       move =   (int) (1 + (Math.random() * (8))); 
       
    }

    if(FishBlue.this.getX() == Aquarium.getTaille()-1 || FishBlue.this.getX() == Aquarium.getTaille()-2  ){ // le 1 c'est pour eviter qu'il rentre dans l'ecran
        FishBlue.this.setX(FishBlue.this.getX()-3);  
            move =   (int) (1 + (Math.random() * (8))); 
           
            
        }
    
        if(FishBlue.this.getY() == 1 || FishBlue.this.getY() == 2  ){ // le 1 c'est pour eviter qu'il rentre dans l'ecran
            FishBlue.this.setY(FishBlue.this.getY()+3);  
                move =   (int) (1 + (Math.random() * (8))); 
                
            }

            if(FishBlue.this.getY() == Aquarium.getTaille()-1 || FishBlue.this.getY() == Aquarium.getTaille()-2  ){ // le 1 c'est pour eviter qu'il rentre dans l'ecran
                FishBlue.this.setY(FishBlue.this.getY()-3);  
                    move =   (int) (1 + (Math.random() * (8))); 
                   
                    
                }




                for (int i = 0; i < Aquarium.listButterfly.size(); i++) {
                  if(FishBlue.this.getX() == Aquarium.listButterfly.get(i).getX() && Aquarium.listButterfly.get(i).getY() == FishBlue.this.getY()){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
                    Bug bug = Aquarium.listButterfly.get(i);
                    Aquarium.removeFromListBug(bug); 
                    for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
                      if(Aquarium.getlistFish().get(j).getId()==2){   
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
                if(FishBlue.this.getX() == Aquarium.listCockroach.get(i).getX() && Aquarium.listCockroach.get(i).getY() == FishBlue.this.getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
                  Bug bug = Aquarium.listCockroach.get(i);
                  Aquarium.removeFromListBug(bug); 
                  for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
                    if(Aquarium.getlistFish().get(j).getId()==2){   
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
              if(FishBlue.this.getX() == Aquarium.listLadyBug.get(i).getX() && Aquarium.listLadyBug.get(i).getY() == FishBlue.this.getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
                Bug bug = Aquarium.listLadyBug.get(i);
                Aquarium.removeFromListBug(bug); 
                for (int j = 0; j < Aquarium.getlistFish().size(); j++) {  
                  if(Aquarium.getlistFish().get(j).getId()==2){   
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
              if(FishBlue.this.getX() == Aquarium.listPast.get(i).getX() && Aquarium.listPast.get(i).getY() == FishBlue.this.getY()    ){ // si poisson orange est dans axe ordonee haut poisson mauve alors poisson mauve descend 
                Past past = Aquarium.listPast.get(i);
                Aquarium.removeFromListPast(past);                 
                for (int j = 0; j < Aquarium.getlistFish().size(); j++) {
              // les poisson s'arrete 90 sec ( petit soucis le poisson garde son unique mouvement )
                  if(Aquarium.getlistFish().get(j).getId()!=2){   
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

    
*/    
    }



}
