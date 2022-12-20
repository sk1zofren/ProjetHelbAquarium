public class Rosa extends GameObjectElement {
  
    private int CompId; // to compare id
    

    public Rosa() {
       
       
      
       
    }



 

    


       public void update(){
// TODO revoir la methode si il n'y a pas de duplication de code 
        for (int i = 0; i < Aquarium.listFish.size(); i++) { // when a fish touch a pink past all fish appears in the random position
            if (Aquarium.listFish.get(i).pos_x > getX() - Past.borderPast && Aquarium.listFish.get(i).pos_x < getX() + Past.borderPast && Aquarium.listFish.get(i).pos_y > getY() - Past.borderPast && Aquarium.listFish.get(i).pos_y < getY() + Past.borderPast) { // TODO je fais sa car vu que je travaille en pixelle, la prob que leurs coordonee se touche est très faible, duplication de code ? 
              Rosa rosa = this;
              Aquarium.removeFromListRosa(rosa);
              CompId = Aquarium.listFish.get(i).getId();
              for (int j = 0; j < Aquarium.listFish.size(); j++) {
                if (Aquarium.listFish.get(j).getId() == CompId)
                  Aquarium.listFish.get(j).pos_x = (int)(1 + (Math.random() * (Aquarium.getheight())));
                  Aquarium.listFish.get(j).pos_y = (int)(1 + (Math.random() * (Aquarium.getheight())));
      
              }
             
            }
          }
       
       }

}
